package marouenj.dsa.eopi.chapter07_heap;

import marouenj.dsa.reuse.Gen;
import marouenj.dsa.reuse.Heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem_01_Page_63 {

    public static <T extends Comparable<T>> List<T> init(List<Iterator<T>> files) {
        List<T> maxHeap = new ArrayList<T>();
        maxHeap.add(null);
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).hasNext()) {
                T nxt = files.get(i).next();
                Heap.max.push(maxHeap, nxt);
            }
        }
        return maxHeap;
    }

    public static <T extends Comparable<T>> void mergeSortedFiles(List<Iterator<T>> files, List<T> file, List<T> maxHeap) {

        List<T> bak = new ArrayList<T>();
        bak.add(null);

        boolean hasNext = true;
        while (hasNext) {
            hasNext = false;
            boolean heapUpdated = true;
            while (heapUpdated) {
                heapUpdated = false;
                for (int i = 0; i < files.size(); i++) {
                    if (files.get(i).hasNext()) {
                        hasNext = true;
                        T nxt = files.get(i).next();
                        if (nxt.compareTo(maxHeap.get(1)) < 0) {
                            heapUpdated = true;
                            Heap.max.push(bak, maxHeap.get(1));
                            maxHeap.set(1, nxt);
                            Heap.max.siftDown(maxHeap, 1, maxHeap.size() - 1);
                        } else {
                            Heap.max.push(bak, nxt);
                        }
                    }
                }
            }
            maxHeap.remove(0);
            marouenj.dsa.reuse.sort.Heap.inc.sort(maxHeap);
            maxHeap.remove(0);
            for (int i = 0; i < maxHeap.size(); i++) {
                file.add(maxHeap.get(i));
            }
            maxHeap = bak;
            bak = new ArrayList<T>();
            bak.add(null);
        }
    }

    public static void main(String[] args) {
        List<Long> file1 = Gen.timestampSerie(10000, 5);
        List<Long> file2 = Gen.timestampSerie(10000, 5);
        List<Long> file3 = Gen.timestampSerie(10000, 5);
        List<Iterator<Long>> files = new ArrayList<>();
        files.add(file1.iterator());
        files.add(file2.iterator());
        files.add(file3.iterator());

        List<Long> maxHeap = init(files);

        List<Long> file = new ArrayList<>();
        mergeSortedFiles(files, file, maxHeap);

        for (Iterator<Long> itr = file.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }
    }

}
