package marouenj.dsa.careercup.google;

public class BitManipulation {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        // 32 bit proc
        int max1 = 1;
        for (int i = 1; i <= 31; i++) {
            max1 <<= 1;
        }
        max1 = ~max1;
        System.out.println(max1);
        System.out.println(Integer.toBinaryString(max1));

        // 64 bit proc
        long max2 = 1;
        for (int i = 1; i <= 63; i++) {
            max2 <<= 1;
        }
        max2 = ~max2;
        for (int i = 1; i <= 32; i++) {
            max2 >>>= 1;
        }
        System.out.println(max2);
        System.out.println(Integer.toBinaryString((int) max2));
    }
}
