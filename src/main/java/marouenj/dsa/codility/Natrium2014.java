package marouenj.dsa.codility;

// https://codility.com/programmers/challenges/natrium2014/
public class Natrium2014 {

    public int solution(int[] a) {
        int n = a.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            if (a[lo] <= a[hi]) {
                return hi - lo;
            }

            if (lo == hi) {
                return 0;
            }

            int loDiff = a[lo] - a[lo + 1];
            int hiDiff = a[hi - 1] - a[hi];

            if (loDiff > 0 && hiDiff > 0) {
                if (loDiff > hiDiff) {
                    lo++;
                } else {
                    hi--;
                }
                continue;
            }

            if (loDiff > 0) {
                lo++;
                continue;
            }

            if (hiDiff > 0) {
                hi--;
                continue;
            }

            if (loDiff > hiDiff) {
                lo++;
            } else {
                hi--;
            }
        }

        return 0;
    }
}
