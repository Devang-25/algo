package algo.misc;

public class BinaryCombinations {

    public static String toBinary(int i, int len) {
        StringBuilder seq = new StringBuilder();

        while (i != 0) {
            if ((i & 1) == 1) {
                seq.insert(0, '1');
            } else {
                seq.insert(0, '0');
            }
            i = i >> 1;
        }

        for (int j = seq.length(); j < len; j++) {
            seq.insert(0, '0');
        }

        return seq.toString();
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < Math.pow(2, n); i++) {
            System.out.println(toBinary(i, n));
        }
    }
}
