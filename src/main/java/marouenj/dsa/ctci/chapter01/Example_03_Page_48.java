package marouenj.dsa.ctci.chapter01;

public class Example_03_Page_48 {

    public static String removeDuplicates(String str) {
        char[] chars = str.toCharArray();
        int hi = chars.length;
        int i = -1;
        while (++i < hi - 1) {
            int j = i;
            int shiftBy = 0;
            while (++j < hi) {
                if (chars[i] == chars[j]) {
                    shiftBy++;
                } else {
                    chars[j - shiftBy] = chars[j];
                }
            }
            hi -= shiftBy;
        }
        return new String(chars, 0, hi);
    }

    public static void main(String[] args) {
        String str = "aaaaaaaaaabbbbbbbbbbcccccccccc";
        System.out.println(removeDuplicates(str));
    }

}
