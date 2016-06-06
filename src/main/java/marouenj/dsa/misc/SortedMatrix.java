package marouenj.dsa.misc;

public class SortedMatrix {

    public static int get_col_range(int[][] mat, int a) {
        int len = mat[0].length - 1;
        int lo = 0;
        int hi = len;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (a >= mat[0][m])
                lo = m + 1;
            else
                hi = m - 1;
        }
        return lo;
    }

    public static int[] get_XY(int[][] mat, int x, int hi) {
        boolean found = false;
        int i = -1;
        int j = -1;
        while (!found && ++i <= hi) {
            j = bin_search(mat, x, i);
            if (j >= 0)
                found = true;
        }
        int[] xy = {-1, -1};
        if (found) {
            xy[0] = i;
            xy[1] = j;
        }
        return xy;
    }

    public static int bin_search(int[][] mat, int x, int col) {
        int idx = -1;
        boolean found = false;
        int lo = 0;
        int hi = mat.length - 1;

        while (!found && lo <= hi) {
            int m = lo + (hi - lo) / 2;
            if (mat[m][col] > x)
                hi = m - 1;
            else if (mat[m][col] < x)
                lo = m + 1;
            else {
                found = true;
                idx = m;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4, 5},
                {3, 6, 7, 8, 9},
                {4, 7, 10, 12, 13},
                {5, 10, 15, 19, 23},
                {17, 18, 19, 20, 25}
        };
        int x = 7;
        int hi = get_col_range(mat, x);
        System.out.println(hi);
        int[] xy = get_XY(mat, x, hi);
        System.out.println(xy[0] + ", " + xy[1]);
    }
}
