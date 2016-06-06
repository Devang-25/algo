package marouenj.dsa.reuse.sort;

import java.util.ArrayList;
import java.util.List;

public class Merge {

    // iterative way
    public static class itr {

        public static <A extends Comparable<A>> void sort(List<A> lst) {
            int i = 0;
            int step = 1;
            while (step < lst.size()) {
                merge(lst, i, step);
                i += 2 * step;
                if (i >= lst.size()) {
                    i = 0;
                    step *= 2;
                }
            }
        }

        public static <A extends Comparable<A>> void merge(List<A> lst, int lo, int step) {
            int mi = Math.min(lo + step, lst.size());
            int hi = Math.min(mi + step, lst.size());
            List<A> tmp = new ArrayList<A>(hi - lo);
            int x = lo;
            int y = mi;
            while (x < mi && y < hi) {
                if (lst.get(x).compareTo(lst.get(y)) <= 0)
                    tmp.add(lst.get(x++));
                else
                    tmp.add(lst.get(y++));
            }
            while (x < mi)
                tmp.add(lst.get(x++));
            while (y < hi)
                tmp.add(lst.get(y++));
            for (int i = 0; i < tmp.size(); i++)
                lst.set(lo + i, tmp.get(i));
        }
    }

    // recursive way
    public static class rec {

        public static <A extends Comparable<A>> void sort(List<A> lst, int lo, int hi) {
            if (hi > lo) {
                int mid = lo + (hi - lo) / 2;
                sort(lst, lo, mid);
                sort(lst, mid + 1, hi);
                merge(lst, lo, hi);
            }
        }

        public static <A extends Comparable<A>> void merge(List<A> lst, int lo, int hi) {
            int mi = lo + (hi - lo) / 2;
            List<A> tmp = new ArrayList<A>(hi - lo);
            int x = lo;
            int y = mi + 1;
            while (x <= mi && y <= hi) {
                if (lst.get(x).compareTo(lst.get(y)) <= 0)
                    tmp.add(lst.get(x++));
                else
                    tmp.add(lst.get(y++));
            }
            while (x <= mi)
                tmp.add(lst.get(x++));
            while (y <= hi)
                tmp.add(lst.get(y++));
            for (int i = 0; i < tmp.size(); i++)
                lst.set(lo + i, tmp.get(i));
        }
    }
}
