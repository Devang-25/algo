package marouenj.dsa.careercup;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// http://www.careercup.com/question?id=5697297964859392
// Input : {1,2,3,4,5,5,5,6,7,7}
// Output: 5 is repeated 3 times, 7 is repeated 2 times
public class _5697297964859392 {

    public void solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        Map<Integer, Integer> occ = new HashMap<>();
        for (int key : arr) {
            Integer val = 1;
            if (occ.containsKey(key)) {
                val = occ.get(key) + 1;
            }
            occ.put(key, val);
        }

        Set<Pair> sorted = new TreeSet<>();
        for (int key : occ.keySet()) {
            int val = occ.get(key);
            Pair p = new Pair(key, val);
            sorted.add(p);
        }

        for (Pair p : sorted) {
            System.out.print(p.number + " is repeated " + p.occ + " times, ");
        }
    }

    private static class Pair implements Comparable<Pair> {

        private final Integer number;
        private final Integer occ;

        private Pair(int number, int occ) {
            this.number = number;
            this.occ = occ;
        }

        @Override
        public int compareTo(Pair o) {
            int rez = o.occ.compareTo(this.occ);
            if (rez != 0) {
                return rez;
            }

            return this.number.compareTo(o.number);
        }
    }
}
