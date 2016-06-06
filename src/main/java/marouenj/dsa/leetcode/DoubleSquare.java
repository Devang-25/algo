// http://leetcode.com/2011/01/double-square-problem-analysis.html

package marouenj.dsa.leetcode;

public class DoubleSquare {

    public static Integer card(Integer n) {
        if (n == null || n < 0)
            return null;

        int card = 0;
        int hi = (int) Math.sqrt(n);
        int lo = 0;

        while (lo <= hi) {
            int sum = hi * hi + lo * lo;
            if (sum == n) {
                card++;
                System.out.println(lo + ", " + hi);
                hi--;
                lo++;
            } else if (sum < n) {
                lo++;
            } else {
                hi--;
            }
        }
        return card;
    }

    public static void main(String[] args) {
        System.out.println(card(100));
    }

}
