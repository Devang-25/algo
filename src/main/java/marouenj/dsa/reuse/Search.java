package marouenj.dsa.reuse;

import marouenj.dsa.reuse.select.Quick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Search {

	/*
     * search for an element that's exactly equal to the target
	 */

    public static <A extends Comparable<A>> int bin(A[] arr, A target) {
        if (arr == null || target == null) {
            return -1;
        }

        return bin(arr, 0, arr.length - 1, target);
    }

    public static <A extends Comparable<A>> int bin(A[] arr, int lo, int hi, A target) {
        if (arr == null || target == null) {
            return -1;
        }

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int cp = arr[mi].compareTo(target);

            if (cp > 0) {
                hi = mi - 1;
            } else if (cp < 0) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }

        return -1;
    }

	/*
	 * search for the first element that's greater than the target, or the first occurrence of the target.
	 * first is defined by the linear traversal from left to right.
	 */

    public static <A extends Comparable<A>> int bin1(A[] arr, A target) {
        if (arr == null || target == null) {
            return -1;
        }

        return bin1(arr, 0, arr.length - 1, target);
    }

    public static <A extends Comparable<A>> int bin1(A[] arr, int lo, int hi, A target) {
        if (arr == null || target == null) {
            return -1;
        }

        int latestMatch = -1;

        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int cp = arr[mi].compareTo(target);

            if (cp >= 0) {
                latestMatch = mi;
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }

        return latestMatch;
    }
	
	/*
	 * search for the kth element in two sorted arrays A and B (as if A and B were merged together into a one sorted array)
	 */

    public static <A extends Comparable<A>> A kthSorted( /* arr1 */ A[] arr1, int lo1, int hi1, /* arr2 */ A[] arr2, int lo2, int hi2, /* index */ int k) {
        if (arr1 == null || arr2 == null) {
            return null;
        }

        if (lo1 >= hi1) {
            return arr2[k - 1];
        }

        if (lo2 >= hi2) {
            return arr1[k - 1];
        }

        // ith is element that's immediately greater or equal than arr1[n-1]
        int ith = bin1(arr2, lo2, hi2, arr1[hi1]);

        if (ith == -1) { // no match: arr1[hi] is the greatest of all
            return kthSorted(arr2, lo2, hi2, arr1, lo1, hi1, k);
        }

        if (hi1 + 1 + ith == k - 1) {
            return arr2[ith];
        }

        if (hi1 + 1 + ith > k - 1) {
            return kthSorted(arr2, lo2, ith - 1, arr1, lo1, hi1, k);
        }

        // kth index is k-1
        // (k-1) - (hi1+1)
        // k-hi1-2
        return arr2[k - hi1 - 2];
    }

    public static <A extends Comparable<A>> int bin(List<A> lst, A e) {
        if (lst == null || e == null)
            return -1;

        int lo = 0;
        int hi = lst.size() - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (lst.get(mi).compareTo(e) > 0)
                hi = mi - 1;
            else if (lst.get(mi).compareTo(e) < 0)
                lo = mi + 1;
            else
                return mi;
        }
        return -1;
    }

    public static int keyInArrayWithCloseEntries(int[] close, int k) {
        if (close == null)
            return -1;
        if (close.length == 0)
            return -1;
        if (close[0] + close.length - 1 < k || close[0] - (close.length - 1) > k)
            return -1;
        int idx = 0;
        while (idx < close.length && close[idx] != k) {
            idx += k - close[idx];
        }
        if (idx >= close.length)
            return -1;
        return idx;
    }

    // O(n log k)
    public static <A extends Comparable<A>> List<A> kLargestElements(List<A> stream, int k) {
        List<A> heap = new ArrayList<A>();
        heap.add(null);

        int i = 0;

        Iterator<A> itr = stream.iterator();
        while (i++ < k && itr.hasNext()) {
            A nxt = itr.next();
            Heap.min.push(heap, nxt);
        }

        // should test if i < k, in which case there's no k largest

        while (itr.hasNext()) {
            A nxt = itr.next();
            if (nxt.compareTo(heap.get(1)) > 0) {
                Lists.swap(heap, 1, nxt);
                Heap.min.siftDown(heap, 1, heap.size() - 1);
            }
        }

        heap.remove(0);
        marouenj.dsa.reuse.sort.Heap.inc.sort(heap);

        return heap;
    }

    // O(n)
    public static <A extends Comparable<A>> List<A> kLargestElementsV2(List<A> stream, int k) {
        List<A> lst = new ArrayList<A>();

        Iterator<A> itr = stream.iterator();
        while (itr.hasNext()) {
            A nxt = itr.next();
            lst.add(nxt);
            if (lst.size() == ((k << 1) - 1)) {
                Quick.dec.select(lst, 0, k, lst.size() - 1);
                while (k < lst.size())
                    lst.remove(k);
            }
        }

        while (k < lst.size())
            lst.remove(k);

        Collections.sort(lst);

        return lst;
    }

    public static String firstDuplicateInText(String text) {
        HashSet<String> hs = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(text, " .,;:", false);
        while (st.hasMoreTokens()) {
            String nxt = st.nextToken();
            if (hs.contains(nxt))
                return nxt;
            hs.add(nxt);
        }
        return null;
    }

    public static double commonWordsInTwoLists(List<String> unsorted, List<String> sorted, HashSet<String> visited, double targetRate) {
        if (visited == null)
            visited = new HashSet<String>();

        double nbreCommonWordsSoFar = 0.0;
        int denom = unsorted.size();
        if (sorted.size() < denom)
            denom = sorted.size();

        Iterator<String> itr = unsorted.iterator();
        while ((nbreCommonWordsSoFar / denom < targetRate) && itr.hasNext()) {
            String nxt = itr.next();
            if (!visited.contains(nxt)) {
                if (Search.bin(sorted, nxt) > 0) {
                    visited.add(nxt);
                    nbreCommonWordsSoFar++;
                }
            }
        }
        return nbreCommonWordsSoFar / denom;
    }

    public static <A extends Comparable<A>> A majority(List<A> seq) {
        if (seq == null || seq.size() == 0)
            return null;

        A candidate = null;
        int count = 0;

        for (Iterator<A> itr = seq.iterator(); itr.hasNext(); ) {
            A nxt = itr.next();

            if (count == 0) {
                candidate = nxt;
                count++;
            } else if (nxt.equals(candidate))
                count++;
            else
                count--;
        }

        // check that the candidate is in fact the majority element
        count = 0;
        for (int i = 0; i < seq.size(); i++) {
            if (seq.get(i).compareTo(candidate) == 0)
                count++;
        }

        if (count > seq.size() / 2)
            return candidate;

        return null;
    }
}
