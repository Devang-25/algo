package algo.reuse;

import marouenj.dsa.reuse.Heap;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapTest {

    @Test
    public void kthLargest() {
        Integer[] arr = new Integer[]{100, 70, 65, 64, 63, 61, 60, 60, 60, 59, 55, 50, 50, 49, 49, 49, 48, 48, 48, 48, 45, 40, 40, 40, 39, 20, 20, 10, 10, 6, 5, 2, 1};

        List<Integer> heap = new ArrayList<Integer>(Arrays.asList(arr));
        Heap.max.heapifyUp(heap);

        for (int i = 0; i < arr.length; i++) {
            Assert.assertEquals(Heap.kthLargest(heap, i + 1), arr[i]);
        }
    }
}
