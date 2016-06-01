package marouenj.dsa.codility;

// https://codility.com/programmers/challenges/argon2015/
public class Argon2015 { // rename the class to 'Solution' before pasting this into codility

    public int solution(int[] days) {
        int n = days.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi && days[lo] == 1) {
            lo++;
        }

        while (hi >= lo && days[hi] == 0) {
            hi--;
        }

        if (lo >= hi) {
            return 0;
        }

        int ones = 0;
        for (int i = lo; i <= hi; i++) {
            ones += days[i];
        }

        int pivot = 0;

        int minSoFar = lo + (n - 1 - hi);

        int lOnes = 0;
        int lZeros = 0;
        int rOnes = ones;
        int rZeros = hi - lo + 1 - rOnes;

        int l1s = lOnes;
        int l0s = lZeros;
        int r1s = rOnes;
        int r0s = rZeros;
        for (int p = lo + 1; p <= hi; p++) {
            if (days[p - 1] == 0) {
                l0s++;
                r0s--;
            } else {
                l1s++;
                r1s--;
            }
            double lPercent = (0D + l1s) / (p - lo);
            double rPercent = (0D + r1s) / (hi - p + 1);
            if (lPercent < 0.5 && rPercent > 0.5) {
                int minCandidate = Math.abs(Math.min(l0s - 1 - (l1s + lo), 0) + Math.min(r1s - 1 - (r0s + n - 1 - hi), 0));
                if (minCandidate <= minSoFar) {
                    pivot = p;
                    minSoFar = minCandidate;
                    lOnes = l1s;
                    lZeros = l0s;
                    rOnes = r1s;
                    rZeros = r0s;
                }
            }
        }

        if (pivot == 0) {
            return 0;
        }

        int fromLo = Math.min(lZeros - 1 - lOnes, lo);
        int fromHi = Math.min(rOnes - 1 - rZeros, n - 1 - hi);

        return fromLo + lZeros + lOnes + rZeros + rOnes + fromHi;
    }
}
