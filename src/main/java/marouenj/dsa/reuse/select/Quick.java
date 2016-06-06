package marouenj.dsa.reuse.select;

import java.util.List;

public class Quick {

    // smallest
    public static class inc {

        public static <A extends Comparable<A>> A select(List<A> lst, int lo, int k, int hi) {
            while (lo <= hi) {
                int p;
                p = marouenj.dsa.reuse.sort.Quick.inc.partition(lst, lo, hi);

                if (p > k - 1)
                    hi = p - 1;
                else if (p < k - 1)
                    lo = p + 1;
                else
                    return lst.get(p);
            }
            return null;
        }
    }

    // largest
    public static class dec {

        public static <A extends Comparable<A>> A select(List<A> lst, int lo, int k, int hi) {
            while (lo <= hi) {
                int p;
                p = marouenj.dsa.reuse.sort.Quick.dec.partition(lst, lo, hi);

                if (p > k - 1)
                    hi = p - 1;
                else if (p < k - 1)
                    lo = p + 1;
                else
                    return lst.get(p);
            }
            return null;
        }
    }

}
