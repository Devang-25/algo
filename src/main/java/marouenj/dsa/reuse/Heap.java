package marouenj.dsa.reuse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Heap<A extends Comparable<A>> {

    public static class min {

        public static <A extends Comparable<A>> void siftUp(List<A> heap, int from, int to) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (from < 1 || from > heap.size()) {
                throw new IndexOutOfBoundsException();
            }

            while (from > to && heap.get(from / 2).compareTo(heap.get(from)) > 0) {
                Collections.swap(heap, from / 2, from);
                from /= 2;
            }
        }

        public static <A extends Comparable<A>> void siftDown(List<A> heap, int from, int to) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (from < 1 || from > heap.size()) {
                throw new IndexOutOfBoundsException();
            }

            while (from * 2 <= to) {
                int pos2 = from * 2;
                if (pos2 + 1 <= to && heap.get(pos2).compareTo(heap.get(pos2 + 1)) > 0) {
                    pos2++;
                }
                if (heap.get(from).compareTo(heap.get(pos2)) > 0) {
                    Collections.swap(heap, from, pos2);
                    from = pos2;
                } else {
                    break;
                }
            }
        }

        public static <A extends Comparable<A>> void push(List<A> heap, A a) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            heap.add(a);
            siftUp(heap, heap.size() - 1, 1);
        }

        public static <A extends Comparable<A>> A pop(List<A> heap) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (heap.size() == 1) {
                return null;
            }

            A min = heap.get(1);
            heap.set(1, heap.remove(heap.size() - 1));
            siftDown(heap, 1, heap.size() - 1);

            return min;
        }

        public static <A extends Comparable<A>> void heapifyUp(List<A> heap) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            int idx = 2;
            while (idx < heap.size()) {
                siftUp(heap, idx, 1);
                idx++;
            }
        }

        public static <A extends Comparable<A>> void heapifyDown(List<A> heap) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            int idx = (heap.size() - 1) / 2;
            while (idx > 0) {
                siftDown(heap, idx, heap.size() - 1);
                idx--;
            }
        }
    }

    public static class max {

        public static <A extends Comparable<A>> void siftUp(List<A> heap, int from, int to) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (from < 1 || from > heap.size()) {
                throw new IndexOutOfBoundsException();
            }

            while (from > to && heap.get(from / 2).compareTo(heap.get(from)) < 0) {
                Collections.swap(heap, from / 2, from);
                from /= 2;
            }
        }

        public static <A extends Comparable<A>> void siftUp(List<A> heap, int from, int to, Comparator<A> comparator) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (from < 1 || from > heap.size()) {
                throw new IndexOutOfBoundsException();
            }

            while (from > to && comparator.compare(heap.get(from / 2), heap.get(from)) < 0) {
                Collections.swap(heap, from / 2, from);
                from /= 2;
            }
        }

        public static <A extends Comparable<A>> void siftDown(List<A> heap, int from, int to) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (from < 1 || from > heap.size()) {
                throw new IndexOutOfBoundsException();
            }

            while (from * 2 <= to) {
                int pos2 = from * 2;
                if (pos2 + 1 <= to && heap.get(pos2).compareTo(heap.get(pos2 + 1)) < 0) {
                    pos2++;
                }
                if (heap.get(from).compareTo(heap.get(pos2)) < 0) {
                    Collections.swap(heap, from, pos2);
                    from = pos2;
                } else {
                    break;
                }
            }
        }

        public static <A extends Comparable<A>> void siftDown(List<A> heap, int from, int to, Comparator<A> comparator) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (from < 1 || from > heap.size()) {
                throw new IndexOutOfBoundsException();
            }

            while (from * 2 <= to) {
                int pos2 = from * 2;
                if (pos2 + 1 <= to && comparator.compare(heap.get(pos2), heap.get(pos2 + 1)) < 0) {
                    pos2++;
                }
                if (comparator.compare(heap.get(from), heap.get(pos2)) < 0) {
                    Collections.swap(heap, from, pos2);
                    from = pos2;
                } else {
                    break;
                }
            }
        }

        public static <A extends Comparable<A>> void push(List<A> heap, A a) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            heap.add(a);
            siftUp(heap, heap.size() - 1, 1);
        }

        public static <A extends Comparable<A>> void push(List<A> heap, A a, Comparator<A> comparator) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            heap.add(a);
            siftUp(heap, heap.size() - 1, 1, comparator);
        }

        public static <A extends Comparable<A>> A pop(List<A> heap) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (heap.size() == 1) {
                return null;
            }

            A min = heap.get(1);
            heap.set(1, heap.remove(heap.size() - 1));
            siftDown(heap, 1, heap.size() - 1);

            return min;
        }

        public static <A extends Comparable<A>> A pop(List<A> heap, Comparator<A> comparator) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            if (heap.size() == 1) {
                return null;
            }

            A min = heap.get(1);
            A last = heap.remove(heap.size() - 1);

            if (heap.size() == 1) {
                heap.add(last);
            } else {
                heap.set(1, last);
            }
            siftDown(heap, 1, heap.size() - 1, comparator);

            return min;
        }

        public static <A extends Comparable<A>> void heapifyUp(List<A> heap) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            int idx = 2;
            while (idx < heap.size()) {
                siftUp(heap, idx, 1);
                idx++;
            }
        }

        public static <A extends Comparable<A>> void heapifyDown(List<A> heap) {
            if (heap == null) {
                throw new NullPointerException();
            }

            if (heap.get(0) != null) { // fix
                heap.add(0, null);
            }

            int idx = (heap.size() - 1) / 2;
            while (idx > 0) {
                siftDown(heap, idx, heap.size() - 1);
                idx--;
            }
        }
    }

    public static <A extends Comparable<A>> A peek(List<A> heap) {
        if (heap == null) {
            throw new NullPointerException();
        }

        if (heap.size() == 0) {
            return null;
        }

        if (heap.get(0) != null) { // fix
            heap.add(0, null);
        }

        if (heap.size() == 1) {
            return null;
        }

        return heap.get(1);
    }

    public static <A extends Comparable<A>> int size(List<A> heap) {
        if (heap == null) {
            throw new NullPointerException();
        }

        int size = heap.size();
        if (heap.get(0) == null) {
            size--;
        }

        return size;
    }

    public static <A extends Comparable<A>> A kthLargest(List<A> heap, int k) {
        if (heap == null) {
            throw new NullPointerException();
        }

        if (k < 1) {
            throw new IllegalArgumentException("Order 'k' is negative");
        }

        if (Heap.size(heap) < k) {
            throw new IllegalArgumentException("Heap size is less than order 'k'");
        }

        List<Integer> q = new ArrayList<>();
        q.add(null);

        DerefComparator<A> comparator = new DerefComparator<A>(heap);

        int curr = 1;
        while (true) {
            k--;
            if (k == 0) {
                break;
            }

            curr *= 2;
            if (curr >= heap.size()) {
                curr = Heap.max.pop(q, comparator);
                continue;
            }

            if (curr + 1 < heap.size()) {
                int cp = heap.get(curr).compareTo(heap.get(curr + 1));
                if (cp >= 0) {
                    Heap.max.push(q, curr + 1, comparator);
                } else {
                    Heap.max.push(q, curr, comparator);
                    curr++;
                }
            }

            // compare curr with the max of q
            Integer max = Heap.peek(q);
            if (heap.get(curr).compareTo(heap.get(max)) < 0) {
                Heap.max.push(q, curr, comparator);
                curr = Heap.max.pop(q, comparator);
            }
        }

        return heap.get(curr);
    }

    public static class DerefComparator<A extends Comparable<A>> implements Comparator<Integer> {

        private List<A> heap;

        public DerefComparator(List<A> heap) {
            this.heap = heap;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            int i1 = (int) o1;
            int i2 = (int) o2;
            return heap.get(i1).compareTo(heap.get(i2));
        }

    }
}
