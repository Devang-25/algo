package marouenj.dsa.google;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MyClient {

    public static void main(String[] args) {
        Socket soc = null;
        PrintWriter out = null;
        try {
            soc = new Socket("192.168.10.122", 5000);
            out = new PrintWriter(soc.getOutputStream(), true);
            // send an int[]
            int[] prices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            String str = prices.length + "#";
            for (int i = 0; i < prices.length; i++) {
                str = str + prices[i] + "#";
            }
            out.println(str);
            // send a string
            str = "this is Marouen JILANI. Yoroshiku!";
            out.println(serialise_string(str));
            // send strings (to be delimited at the destination)
            ArrayList<String> msgS = new ArrayList<String>();
            msgS.add("Hello!");
            msgS.add("This is me, Marouen.");
            msgS.add("I am preparing for the Google interview.");
            out.println(serialise_stringS(msgS));
            // send a msg that contains only the following characters [0..9],[A..Z],[a..z]
            str = "0123456789abcdABCD";
            out.println(from_ascii_to_charset6(str.toCharArray()));
            //
            out.close();
            soc.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String serialise_string(String s) {
        if (s == null || s.length() < 5)
            return null;
        char[] header = integer_to_char4(s.length());
        return new String(header) + s;
    }

    public static String serialise_stringS(ArrayList<String> sS) {
        if (sS == null || sS.size() == 0)
            return null;
        String s = new String(integer_to_char4(sS.size()));
        for (int i = 0; i < sS.size(); i++) {
            String t = serialise_string(sS.get(i));
            if (t == null)
                return null;
            s = s + t;
        }
        return s;
    }

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
            int start_at = ((i % 4) * 6) % 8;
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
        return (((byte) c >> 6) & 3) == 0;
    }
}
