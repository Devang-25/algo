package marouenj.dsa.careercup.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Arrays {

	/*
     * http://www.careercup.com/question?id=5697297964859392
	 * Write program for the following scenario
	 * Input : {1,2,3,4,5,5,5,6,7,7}
	 * Output: 5 is repeated 3 times, 7 is repeated 2 times
	 */

    public static void _2(Integer[] arr) {
        if (arr == null) {
            return;
        }

        // populate hash map
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int val = 1;

            if (hm.containsKey(key)) {
                val += hm.get(key);
            }

            hm.put(key, val);
        }

        // populate tree map
        Map<Integer, List<Integer>> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });

        for (Iterator<Integer> itr = hm.keySet().iterator(); itr.hasNext(); ) {
            Integer next = itr.next();

            List<Integer> val = new ArrayList<>();
            val.add(next);

            Integer key = hm.get(next);

            if (tm.containsKey(key)) {
                List<Integer> old = tm.get(key);
                val.addAll(old);
            }

            tm.put(key, val);
        }

        // dump
        for (Iterator<Integer> itr = tm.keySet().iterator(); itr.hasNext(); ) {
            Integer key = itr.next();

            List<Integer> vals = tm.get(key);
            Collections.sort(vals);

            for (int i = 0; i < vals.size(); i++) {
                System.out.print(vals.get(i) + " is repeated " + key + " times, ");
            }
        }

        System.out.println();
    }

    public static void _2_2(Integer[] arr) {
        if (arr == null) {
            return;
        }

        // populate a hasmap
        Map<Pair, Pair> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer key = arr[i];
            Integer val = 1;
            Pair p = new Pair(key, val);

            if (hm.containsKey(p)) {
                Integer old = hm.get(p).val;
                p.val += old;
            }

            hm.put(p, p);
        }

        Collection<Pair> c = hm.values();
        List<Pair> l = new ArrayList<>(c);
        Collections.sort(l);

        for (Iterator<Pair> itr = l.iterator(); itr.hasNext(); ) {
            Pair next = itr.next();
            System.out.print(next.key + " is repeated " + next.val + " times, ");
        }
        System.out.println();
    }

    static class Pair implements Comparable<Pair> {

        public Integer key;
        public Integer val;

        public Pair(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair p = (Pair) o;
            return this.key.equals(p.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public int compareTo(Pair o) {
            int c = val.compareTo(o.val);
            if (c != 0) {
                return -c;
            }
            return key.compareTo(o.key);
        }
    }
}
