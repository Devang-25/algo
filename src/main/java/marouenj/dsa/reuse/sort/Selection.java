package marouenj.dsa.reuse.sort;

public class Selection {

    public static int[] sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int idx_min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[idx_min]) {
                    idx_min = j;
                }
            }
            if (i != idx_min) {
                int tmp = arr[i];
                arr[i] = arr[idx_min];
                arr[idx_min] = tmp;
            }
        }
        return arr;
    }
}
