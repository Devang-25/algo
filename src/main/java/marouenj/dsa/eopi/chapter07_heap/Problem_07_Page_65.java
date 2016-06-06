package marouenj.dsa.eopi.chapter07_heap;

import marouenj.dsa.reuse.Gen;
import marouenj.dsa.reuse.Heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem_07_Page_65 {

    public static List<Long> sortQuasiSorted(List<Long> quasiSorted, int k) {

        List<Long> sorted = new ArrayList<Long>();

        List<Long> heap = new ArrayList<Long>();
        heap.add(null);

        int i = 0;

        Iterator<Long> itr = quasiSorted.iterator();
        while (i < k && itr.hasNext()) {
            Heap.min.push(heap, itr.next());
            i++;
        }

        for (; i < quasiSorted.size(); i++) {
            Heap.min.push(heap, itr.next());
            sorted.add(Heap.min.pop(heap));
        }

        Long remain = Heap.min.pop(heap);
        while (remain != null) {
            sorted.add(remain);
            remain = Heap.min.pop(heap);
        }

        return sorted;
    }

    public static void main(String[] args) {
        List<Long> seq = Gen.timestampSerieWithDelay(20, 5, 3);
        for (int i = 0; i < seq.size(); i++)
            System.out.println(seq.get(i));

        System.out.println();

        seq = sortQuasiSorted(seq, 3);
        for (int i = 0; i < seq.size(); i++)
            System.out.println(seq.get(i));
    }

}
