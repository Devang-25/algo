package marouenj.dsa.reuse.sort;

public class Insertion {

    public static <A extends Comparable<A>> void sort(A arr[]) {
        for (int i = 1; i < arr.length; i++) {
            A tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(tmp) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
    }
}
