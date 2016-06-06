package marouenj.dsa.reuse.sort;

import java.util.Collections;
import java.util.List;

public class Quick {

    // incremental sort
    public static class inc {

        public static <A extends Comparable<A>> void sort(List<A> lst, int lo, int hi) {
            if (lo < hi) {
                int p;
                p = partition(lst, lo, hi);
                sort(lst, lo, p - 1);
                sort(lst, p + 1, hi);
            }
        }

        public static <A extends Comparable<A>> int partition(List<A> lst, int lo, int hi) {
            int ultimate_pivot_index = lo;
            for (int i = lo; i < hi; i++) {
                if (lst.get(i).compareTo(lst.get(hi)) < 0) {
                    Collections.swap(lst, ultimate_pivot_index, i);
                    ultimate_pivot_index++;
                }
            }
            Collections.swap(lst, ultimate_pivot_index, hi);
            return ultimate_pivot_index;
        }
    }


    // decremental sort
    public static class dec {

        public static <A extends Comparable<A>> void sort(List<A> lst, int lo, int hi) {
            if (lo < hi) {
                int p;
                p = partition(lst, lo, hi);
                sort(lst, lo, p - 1);
                sort(lst, p + 1, hi);
            }
        }

        public static <A extends Comparable<A>> int partition(List<A> lst, int lo, int hi) {
            int ultimate_pivot_index = lo;
            for (int i = lo; i < hi; i++) {
                if (lst.get(i).compareTo(lst.get(hi)) > 0) {
                    Collections.swap(lst, i, ultimate_pivot_index);
                    ultimate_pivot_index++;
                }
            }
            Collections.swap(lst, ultimate_pivot_index, hi);
            return ultimate_pivot_index;
        }
    }

}
