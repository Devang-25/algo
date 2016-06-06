package marouenj.dsa.google;

public class BitManipulation {

    public static void main(String[] args) {
//		tutorial_1();
        int i = 1 | (1 << Integer.SIZE - 1);
        int j = 2 | (2 << Integer.SIZE - 3);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("0" + Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString(i | j));
        System.out.println(bitPatternIsPalindrome(i | j));
    }

    // tutorial on shifting signed integers with <<, >> and >>>
    public static void tutorial_1() {
        int n = 1024;
        //
        System.out.println(n);
        System.out.println(n >> 1);
        System.out.println(n >>> 1);
        System.out.println(-n);
        System.out.println(-n >> 1);
        System.out.println(-n >>> 1);
        //
        System.out.println("000000000000000000000" + Integer.toBinaryString(n));
        System.out.println("0000000000000000000000" + Integer.toBinaryString(n >> 1));
        System.out.println("0000000000000000000000" + Integer.toBinaryString(n >>> 1));
        System.out.println(Integer.toBinaryString(-n));
        System.out.println(Integer.toBinaryString(-n >> 1));
        System.out.println("0" + Integer.toBinaryString(-n >>> 1));
    }

    public static boolean bitPatternIsPalindrome(int x) {
        int n = Integer.SIZE;
        int i = -1;
        while (++i < n / 2 && (x & (1 << i)) == (x & (1 << n - i - 1) >>> n - 2 * i - 1)) ;
        return i == n / 2;
    }

}
