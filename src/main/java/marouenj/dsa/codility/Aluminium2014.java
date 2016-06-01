package marouenj.dsa.codility;

// https://codility.com/programmers/challenges/aluminium2014/
public class Aluminium2014 { // rename the class to 'Solution' before pasting this into codility

    public int solution(int[] a) {
        int n = a.length;

        int sum = a[0];
        int min = a[0];

        for (int i = 1; i < n; i++) {
            sum += a[i];
            if (a[i] < min) {
                min = a[i];
            }
        }

        int maxSoFar = sum;

        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            if (sum - min > maxSoFar) {
                maxSoFar = sum - min;
            }

            if (a[lo] == min) {
                sum -= a[hi--];
            } else if (a[hi] == min) {
                sum -= a[lo++];
            } else {
                if (a[lo] <= a[hi]) {
                    sum -= a[lo++];
                } else {
                    sum -= a[hi--];
                }
            }
        }

        return maxSoFar;
    }

    public int min(int[] a, int lo, int hi) {
        int min = a[lo];

        for (int i = lo + 1; i <= hi; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }

        return min;
    }
}
