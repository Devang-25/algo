package marouenj.dsa.misc;

class Solution {

    public int solution(int[] A) {
        if (A == null || A.length < 5)
            return -1;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int lo = 1;
        int hi = A.length - 2;

        boolean previouslyMin1WasSet = false;

        for (int i = lo; i <= hi; i++) {
            if (previouslyMin1WasSet) {
                if (A[i] < min1) {
                    min1 = A[i];
                } else {
                    previouslyMin1WasSet = false;
                }
            } else {
                if (A[i] < min1) {
                    previouslyMin1WasSet = true;
                    int tmp = min1;
                    min1 = A[i];
                    if (tmp < min2) {
                        min2 = tmp;
                    }
                } else if (A[i] < min2) {
                    min2 = A[i];
                }
            }
        }

        return min1 + min2;
//		return minWeight;
    }

    public static void main(String[] args) {
        int[] A = {10, 1, 2, 3, 4, 1, 10};
        System.out.println(new Solution().solution(A));
    }
}
