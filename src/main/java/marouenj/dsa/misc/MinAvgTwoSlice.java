/*
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements).
 * The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
 * To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * 
 * For example, array A such that:
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * 
 * contains the following example slices:
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * 
 * The goal is to find the starting position of a slice whose average is minimal.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average.
 * If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 * 
 * For example, given array A such that:
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * 
 * Assume that:
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * 
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified. 
 */

package marouenj.dsa.misc;

public class MinAvgTwoSlice {

    public static int solution(int[] A) {
        int idx = 0;
        int sum = A[0] + A[1];
        float denom = 2;

        int idx_sofar = 0;
        int sum_sofar = A[0] + A[1];
        float denom_sofar = 2;

        for (int i = 2; i < A.length - 1; i++) {
            int sum_old_expanded = sum_sofar + A[i];
            float denom_old_expanded = denom_sofar + 1;

            int sum_new = A[i - 1] + A[i];
            float denom_new = 2;

            if (sum_old_expanded / denom_old_expanded < sum_new / denom_new) {
                sum_sofar = sum_old_expanded;
                denom_sofar = denom_old_expanded;
            } else {
                idx_sofar = i - 1;
                sum_sofar = sum_new;
                denom_sofar = denom_new;
            }
            if (sum_sofar / denom_sofar < sum / denom) {
                idx = idx_sofar;
                sum = sum_sofar;
                denom = denom_sofar;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 5, 1, 5, 8};

        System.out.println(solution(A));
    }
}
