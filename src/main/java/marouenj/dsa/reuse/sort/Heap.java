package marouenj.dsa.reuse.sort;

import java.util.Collections;
import java.util.List;

public class Heap<A extends Comparable<A>> {

    public static class inc {

        public static <A extends Comparable<A>> void sort(List<A> lst) {
            lst.add(0, null);
            marouenj.dsa.reuse.Heap.max.heapifyUp(lst); // or down
            int i = lst.size() - 1;
            while (i > 1) {
                Collections.swap(lst, 1, i);
                marouenj.dsa.reuse.Heap.max.siftDown(lst, 1, i - 1);
                i--;
            }
            lst.remove(0);
        }
    }

    public static class dec {

        public static <T extends Comparable<T>> void sort(List<T> lst) {
            if (lst.get(0) != null) { // fix
                lst.add(0, null);
            }

            marouenj.dsa.reuse.Heap.min.heapifyUp(lst); // or down
            int i = lst.size() - 1;
            while (i > 1) {
                Collections.swap(lst, 1, i);
                marouenj.dsa.reuse.Heap.min.siftDown(lst, 1, i - 1);
                i--;
            }
            lst.remove(0);
        }
    }
}
