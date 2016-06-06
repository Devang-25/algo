package marouenj.dsa.careercup;

import marouenj.dsa.reuse.sort.Bubble;

public class Arrays {

    /*
     * http://www.careercup.com/question?id=5107200865337344
     * Given three arrays A,B,C with n elements each and a number 'K', find whether there exists a,b,c where a belongs to A, b to B and c to C such that a+b+c = K. It should be done in NlogN time.
     */
    public static boolean _1(Integer[] A, Integer[] B, Integer[] C, int K) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0) {
            return false;
        }

        Bubble.sort(A);
        Bubble.sort(B);
        Bubble.sort(C);

        return three(A, B, C, K);
    }

    private static boolean three(Integer[] X, Integer[] Y, Integer[] Z, int K) {
        int x = X.length - 1;
        int y = Y.length - 1;
        int z = Z.length - 1;

        while (x > -1 && y > -1 && z > -1) {
            int sum = X[x] + Y[y] + Z[z];

            if (sum < K) {
                return false;
            }

            if (sum == K) {
                return true;
            }

            // decrement the largest number
            if (X[x] > Y[y]) {
                if (X[x] > Z[z]) {
                    x--;
                } else {
                    z--;
                }
            } else {
                if (Y[y] > Z[z]) {
                    y--;
                } else {
                    z--;
                }
            }
        }

        if (x == -1) {
            return two(Y, y, Z, z, X[0], K);
        }

        if (y == -1) {
            return two(X, x, Z, z, Y[0], K);
        }

        return two(X, x, Y, y, Z[0], K);
    }

    public static boolean two(Integer[] X, int x, Integer[] Y, int y, Integer prev, int K) {
        while (x > -1 && y > -1) {
            int sum = X[x] + Y[y] + prev;

            if (sum < K) {
                return false;
            }

            if (sum == K) {
                return true;
            }

            if (X[x] > Y[y]) {
                x--;
            } else {
                y--;
            }
        }

        if (x == -1) {
            return one(Y, y, prev + X[0], K);
        }

        return one(X, x, prev + Y[0], K);
    }

    public static boolean one(Integer[] X, int x, Integer prev, int K) {
        while (x > -1) {
            int sum = X[x] + prev;

            if (sum < K) {
                return false;
            }

            if (sum == K) {
                return true;
            }

            x--;
        }

        return false;
    }
}
