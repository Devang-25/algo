package marouenj.dsa.reuse;

import java.util.List;

public class Lists {

	/*
     * generic
	 */

    public static <A extends Comparable<A>> A swap(List<A> lst, int idx, A e) {
        if (lst == null || idx < 0 || idx >= lst.size())
            return null;
        A tmp = lst.get(idx);
        lst.set(idx, e);
        e = tmp;
        return tmp;
    }

    public static <A extends Comparable<A>> void translateDown(List<A> lst, int lo, int hi) {
        if (lst == null || lo >= hi || lo < 0 || hi >= lst.size())
            return;
        A tmp = lst.get(lo);
        for (int i = lo; i < hi; i++)
            lst.set(i, lst.get(i + 1));
        lst.set(hi, tmp);
    }

    public static <A extends Comparable<A>> void translateUp(List<A> lst, int lo, int hi) {
        if (lst == null || lo >= hi || lo < 0 || hi >= lst.size())
            return;
        A tmp = lst.get(hi);
        for (int i = hi; i > lo; i--)
            lst.set(i, lst.get(i - 1));
        lst.set(lo, tmp);
    }

    /*
     * remove duplicate values from a sorted list
     */
    public static <A extends Comparable<A>> void removeDuplicates(List<A> lst) {
        if (lst == null || lst.size() < 2)
            return;
        int i = 0;
        int j = 1;
        while (j < lst.size()) {
            if (lst.get(i).equals(lst.get(j)))
                j++;
            else {
                i++;
                lst.set(i, lst.get(j));
                j++;
            }
        }
        i++;
        while (i < lst.size())
            lst.remove(i);
    }

	/*
	 * integer-specific
	 */

    public static Integer avg(List<Integer> lst) {
        if (lst == null)
            return null;

        if (lst.size() == 0)
            return 0;

        int sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            sum += lst.get(i);
        }

        return Math.round(sum / lst.size());
    }
}
