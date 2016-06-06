package marouenj.dsa.eopi.chapter08_search;

public class Problem_05_Page_70 {

    public static int index_smallest_element_in_cyclically_sorted_array(int[] arr) {
        if (arr == null)
            return -1;
        int lo = 0;
        int up = arr.length - 1;
        while (lo < up) {
            int m = lo + (up - lo) / 2;
            if (arr[m] < arr[up])
                up = m;
            else if (arr[m] > arr[up])
                lo = m + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {279, 368, 378, 478, 550, 631, 103, 203, 220, 234};
        System.out.println(index_smallest_element_in_cyclically_sorted_array(arr));
    }
}
