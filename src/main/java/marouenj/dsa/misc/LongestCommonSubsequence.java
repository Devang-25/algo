package algo.misc;

public class LongestCommonSubsequence {

    public static int LCS_REC(char[] arr1, int curr1, char[] arr2, int curr2) {
        if (curr1 < 0 || curr2 < 0) {
            return 0;
        }

        if (arr1[curr1] == arr2[curr2]) {
            return 1 + LCS_REC(arr1, curr1 - 1, arr2, curr2 - 1);
        }

        return Math.max(LCS_REC(arr1, curr1 - 1, arr2, curr2), LCS_REC(arr1, curr1, arr2, curr2 - 1));
    }

    // m x n
    public static int LCS_ITR_1(char[] arr1, char[] arr2) {
        int m = arr1.length + 1;
        int n = arr2.length + 1;

        if (n < m) {
            m = arr2.length + 1;
            n = arr1.length + 1;
            char[] arr_t;
            arr_t = arr1;
            arr1 = arr2;
            arr2 = arr_t;
        }

        int[][] arr = new int[n][m];

        for (int i = 0; i < m; i++) {
            arr[0][i] = 0;
        }

        for (int j = 0; j < n; j++) {
            arr[j][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr1[j - 1] == arr2[i - 1]) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[n - 1][m - 1];
    }

    // 2 * min(m, n)
    public static int LCS_ITR_2(char[] arr1, char[] arr2) {
        int m = arr1.length + 1;
        int n = arr2.length + 1;

        if (n < m) {
            m = arr2.length + 1;
            n = arr1.length + 1;
            char[] arr_t;
            arr_t = arr1;
            arr1 = arr2;
            arr2 = arr_t;
        }

        // arr_1 is shorter than arr_2

        int[][] arr = new int[2][m];

        for (int i = 0; i < m; i++) {
            arr[0][i] = 0;
        }

        arr[1][0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr1[j - 1] == arr2[i - 1]) {
                    arr[i % 2][j] = 1 + arr[(i - 1) % 2][j - 1];
                } else {
                    arr[i % 2][j] = Math.max(arr[(i - 1) % 2][j], arr[i % 2][j - 1]);
                }
            }
        }

        return arr[1][m - 1];
    }

    // 1 + min(m, n)
    public static int LCS_ITR_3(char[] arr1, char[] arr2) {
        int m = arr1.length + 1;
        int n = arr2.length + 1;

        if (n < m) {
            m = arr2.length + 1;
            n = arr1.length + 1;
            char[] arr_t;
            arr_t = arr1;
            arr1 = arr2;
            arr2 = arr_t;
        }

        // arr_1 is shorter than arr_2

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = 0;
        }

        int left = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int tmp = left;
                if (arr1[j - 1] == arr2[i - 1]) {
                    left = 1 + arr[j - 1];
                } else {
                    left = Math.max(left, arr[j]);
                }
                arr[j - 1] = tmp;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        char[] arr_1 = {'z', 'z', 'z', 'a', 'b', 'c', 'd'};
        char[] arr_2 = {'y', 'y', 'a', 'b', 'c'};
        System.out.println(LCS_REC(arr_1, arr_1.length - 1, arr_2, arr_2.length - 1));
        System.out.println(LCS_ITR_1(arr_1, arr_2));
        System.out.println(LCS_ITR_2(arr_1, arr_2));
        System.out.println(LCS_ITR_3(arr_1, arr_2));
    }

}
