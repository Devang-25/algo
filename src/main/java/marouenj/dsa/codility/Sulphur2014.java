package marouenj.dsa.codility;

// https://codility.com/programmers/challenges/sulphur2014/
public class Sulphur2014 { // rename the class to 'Solution' before pasting this into codility

    public int solution(int[] a, int[] b, int[] c) {
        int step = 0;

        for (int i = 0; i < a.length; i++) {
            // first a rope should sustain its own weight
            a[i] -= b[i];
            if (a[i] < 0) {
                return step;
            }

            // the above ropes should sustain the newly added weight
            int j = i;
            while (c[j] != -1) {
                j = c[j];
                a[j] -= b[i];
                if (a[j] < 0) {
                    return step;
                }
            }

            // no rope broke
            step++;
        }

        return step;
    }
}
