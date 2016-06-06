package marouenj.dsa.google;

public class LocalSerialization {

    public static void main(String[] args) {
        String str = "0123456789abcdABCD";
        String str6 = from_ascii_to_charset6(str.toCharArray());
        System.out.println(deserialise_5(str6));
    }

    /*
     * SERIALISATION
     */
    public static String from_ascii_to_charset6(char[] str) {
        if (str == null || str.length == 0)
            return null;
        char[] str6 = new char[(str.length / 4) * 3 + str.length % 4];
        for (int i = 0, j = -1; i < str.length; i++) {
            char c6;
            if (is_digit_serial(str[i])) {
                c6 = (char) (str[i] & 15);
                c6 = (char) (27 + (c6 % 5) + ((c6 >= 5) ? 32 : 0));
            } else {
                c6 = (char) (str[i] & 63);
            }
            //
            int start_at = (i * 6) % 8;
            if (start_at == 0) {
                str6[++j] = (char) (c6 << 2);
            } else if (start_at == 6) {
                str6[j] = (char) (str6[j] | (c6 >> 4));
                str6[++j] = (char) (c6 << 4);
            } else if (start_at == 4) {
                str6[j] = (char) (str6[j] | (c6 >> 2));
                str6[++j] = (char) (c6 << 6);
            } else { // if (start_at == 2)
                str6[j] = (char) (str6[j] | c6);
            }
        }
        char[] length = integer_to_char4(str.length);
        return new String(length) + new String(str6);
    }

    public static char[] integer_to_char4(int n) {
        int mask = (int) Math.pow(2, 8) - 1;
        char[] c4 = new char[4];
        for (int i = 0; i < 4; i++) {
            c4[i] = (char) ((n >> i * 8) & mask);
        }
        return c4;
    }

    public static boolean is_digit_serial(char c) {
        return c >> 6 == 0;
    }

    /*
     * DESERIALISATION
     */
    public static String deserialise_5(String buf) {
        if (buf == null)
            return null;
        int length = parse_int(buf);
        if (length < 1)
            return null;
        buf = buf.substring(4);
        char[] output = new char[length];
        for (int i = 0, j = -1; i < length; i++) {
            int start_at = (i * 6) % 8;
            char c6 = 0;
            if (start_at == 0) {
                c6 = (char) (buf.charAt(++j) >>> 2);
            } else if (start_at == 6) {
                c6 = (char) ((buf.charAt(j) & 3) << 4 | buf.charAt(++j) >>> 4);
            } else if (start_at == 4) {
                c6 = (char) ((buf.charAt(j) & 15) << 2 | buf.charAt(++j) >>> 6);
            } else { // if start_at == 2
                c6 = (char) (buf.charAt(j) & 63);
            }
            if (is_digit_deserial(c6)) {
                output[i] = (char) (48 + ((c6 & 31) - 27));
            } else {
                output[i] = (char) (64 + c6);
            }
        }
        //
        return new String(output);
    }

    public static int parse_int(String str) {
        if (str == null || str.length() < 4)
            return -1;
        int n = 0;
        for (int i = 0; i < 4; i++) {
            n |= ((int) str.charAt(i)) << i * 8;
        }
        return n;
    }

    public static boolean is_digit_deserial(char c) {
        return (c & 31) > 26;
    }

}
