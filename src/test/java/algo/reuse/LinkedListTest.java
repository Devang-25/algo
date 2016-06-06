package algo.reuse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListTest {

    @Test
    public void fromArray() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertEquals(head.getKey(), new Integer(1));
        head = head.getNext();
        Assert.assertEquals(head.getKey(), new Integer(2));
        head = head.getNext();
        Assert.assertEquals(head.getKey(), new Integer(3));
        head = head.getNext();
        Assert.assertEquals(head.getKey(), new Integer(4));
        head = head.getNext();
        Assert.assertEquals(head.getKey(), new Integer(5));
        head = head.getNext();
        Assert.assertEquals(head.getKey(), new Integer(6));
        head = head.getNext();
        Assert.assertEquals(head.getKey(), new Integer(7));
        head = head.getNext();
        Assert.assertNull(head);
    }

    @Test
    public void dump_1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        LinkedList.dump(null);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void dump_2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Node2<Integer> head = LinkedList.fromArray(arr);

        LinkedList.dump(head);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6, 7\n");
    }

    @Test
    public void length_null() {
        Assert.assertEquals(LinkedList.length(null), 0);
    }

    @Test
    public void length_singleNode() {
        Integer[] arr = new Integer[]{1};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertEquals(LinkedList.length(head), 1);
    }

    @Test
    public void length_longList() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertEquals(LinkedList.length(head), arr.length);
    }

    @Test
    public void reverse_null() {
        Assert.assertNull(LinkedList.reverse(null));
    }

    @Test
    public void reverse_singleNode() {
        Integer[] arr = new Integer[]{1};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> reverse = LinkedList.reverse(head);
        Assert.assertEquals(reverse.getKey(), head.getKey());
        Assert.assertNull(reverse.getNext());
    }

    @Test
    public void reverse_twoNodes() {
        Integer[] arr = new Integer[]{1, 2};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> reverse = LinkedList.reverse(head);
        Assert.assertEquals(reverse.getKey(), (Integer) 2);
        Assert.assertEquals(reverse.getNext().getKey(), (Integer) 1);
        Assert.assertNull(reverse.getNext().getNext());
    }

    @Test
    public void split_null() {
        Node2<Integer> second = LinkedList.split(null);

        Assert.assertNull(second);
    }

    @Test
    public void split_oneElement() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> second = LinkedList.split(head);
        LinkedList.dump(head);
        LinkedList.dump(second);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1\n");
    }

    @Test
    public void split_twoElements() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> second = LinkedList.split(head);
        LinkedList.dump(head);
        LinkedList.dump(second);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1\n2\n");
    }

    @Test
    public void split_threeElements() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2, 3};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> second = LinkedList.split(head);
        LinkedList.dump(head);
        LinkedList.dump(second);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2\n3\n");
    }

    @Test
    public void split_odd() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> second = LinkedList.split(head);
        LinkedList.dump(head);
        LinkedList.dump(second);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6\n7, 8, 9, 10, 11\n");
    }

    @Test
    public void split_even() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> second = LinkedList.split(head);
        LinkedList.dump(head);
        LinkedList.dump(second);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6\n7, 8, 9, 10, 11, 12\n");
    }

    @Test
    public void insertAt_nullPointer() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Node2<Integer> node = new Node2<>(2);

        Assert.assertFalse(LinkedList.insertAt(null, node, 1));
    }

    @Test
    public void insertAt_nullList() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Pointer<Node2<Integer>> ptr = new Pointer<>(null);
        Node2<Integer> node = new Node2<>(2);

        Assert.assertFalse(LinkedList.insertAt(ptr, node, 1));
    }

    @Test
    public void insertAt_nullNode() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Pointer<Node2<Integer>> ptr = new Pointer<>(new Node2<Integer>(1));

        Assert.assertFalse(LinkedList.insertAt(ptr, null, 1));
    }

    @Test
    public void insertAt_negativePos() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Pointer<Node2<Integer>> ptr = new Pointer<>(new Node2<Integer>(1));
        Node2<Integer> node = new Node2<>(2);

        Assert.assertFalse(LinkedList.insertAt(ptr, node, -1));
    }

    @Test
    public void insertAt_firstPos() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] arr = new Integer[]{2, 3, 4, 5};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Pointer<Node2<Integer>> ptr = new Pointer<>(head);
        Node2<Integer> node = new Node2<>(1);

        LinkedList.insertAt(ptr, node, 1);
        head = ptr.deref();
        LinkedList.dump(head);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5\n");
    }

    @Test
    public void insertAt_MiddlePos() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 7, 8};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Pointer<Node2<Integer>> ptr = new Pointer<>(head);
        Node2<Integer> node = new Node2<>(6);

        LinkedList.insertAt(ptr, node, 6);
        head = ptr.deref();
        LinkedList.dump(head);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8\n");
    }

    @Test
    public void insertAtTail_nullList() {
        Assert.assertFalse(LinkedList.insertAtTail(null, new Node2<Integer>(1)));
    }

    @Test
    public void insertAtTail_nullNode() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertTrue(LinkedList.insertAtTail(head, null));

        LinkedList.dump(head);
        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8\n");

    }

    @Test
    public void insertAtTail_even() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> node = new Node2<>(9);

        LinkedList.insertAtTail(head, node);
        LinkedList.dump(head);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9\n");
    }

    @Test
    public void merge_twoAreNull() {
        Assert.assertNull(LinkedList.merge(null, null));
    }

    @Test
    public void merge_oneIsNull() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertEquals(LinkedList.merge(head, null), head);
        Assert.assertEquals(LinkedList.merge(null, head), head);
    }

    @Test
    public void merge_firstArgHasLowestElement() {
        Integer[] arr1 = new Integer[]{1, 3, 5, 7};
        Integer[] arr2 = new Integer[]{2, 4, 6, 8};

        Node2<Integer> head1 = LinkedList.fromArray(arr1);
        Node2<Integer> head2 = LinkedList.fromArray(arr2);

        Node2<Integer> actual = LinkedList.merge(head1, head2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(actual);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8\n");
    }

    @Test
    public void merge_secondArgHasLowestElement() {
        Integer[] arr1 = new Integer[]{1, 3, 5, 7};
        Integer[] arr2 = new Integer[]{2, 4, 6, 8};

        Node2<Integer> head1 = LinkedList.fromArray(arr1);
        Node2<Integer> head2 = LinkedList.fromArray(arr2);

        Node2<Integer> actual = LinkedList.merge(head2, head1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(actual);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8\n");
    }

    @Test
    public void merge_firstArgIsLongest() {
        Integer[] arr1 = new Integer[]{1, 3, 5, 7, 9, 10, 11, 12, 13};
        Integer[] arr2 = new Integer[]{2, 4, 6, 8};

        Node2<Integer> head1 = LinkedList.fromArray(arr1);
        Node2<Integer> head2 = LinkedList.fromArray(arr2);

        Node2<Integer> actual = LinkedList.merge(head1, head2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(actual);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13\n");
    }

    @Test
    public void merge_secondArgIsLongest() {
        Integer[] arr1 = new Integer[]{1, 3, 5, 7};
        Integer[] arr2 = new Integer[]{2, 4, 6, 8, 9, 10, 11, 12, 13};

        Node2<Integer> head1 = LinkedList.fromArray(arr1);
        Node2<Integer> head2 = LinkedList.fromArray(arr2);

        Node2<Integer> actual = LinkedList.merge(head1, head2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(actual);

        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13\n");
    }

    @Test
    public void evenOdd_null() {
        Assert.assertNull(LinkedList.evenOdd(null));
    }

    @Test
    public void evenOdd_oneNode() {
        Integer[] arr = new Integer[]{0};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertEquals(LinkedList.evenOdd(head), head);
    }

    @Test
    public void evenOdd_twoNodes() {
        Integer[] arr = new Integer[]{0, 1};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Assert.assertEquals(LinkedList.evenOdd(head), head);
    }

    @Test
    public void evenOdd_threeNodes() {
        Integer[] arr = new Integer[]{0, 1, 2};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> evenOdd = LinkedList.evenOdd(head);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(evenOdd);

        Assert.assertEquals(baos.toString(), "0, 2, 1\n");
    }


    @Test
    public void evenOdd_fourNodes() {
        Integer[] arr = new Integer[]{0, 1, 2, 3};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> evenOdd = LinkedList.evenOdd(head);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(evenOdd);

        Assert.assertEquals(baos.toString(), "0, 2, 1, 3\n");
    }

    @Test
    public void evenOdd_1() {
        Integer[] arr = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Node2<Integer> head = LinkedList.fromArray(arr);

        Node2<Integer> evenOdd = LinkedList.evenOdd(head);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(evenOdd);

        Assert.assertEquals(baos.toString(), "0, 2, 4, 6, 8, 10, 12, 1, 3, 5, 7, 9, 11, 13\n");
    }

    @Test
    public void areIntersecting() {
        Integer[] arr1 = new Integer[]{11, 12, 13, 14, 15};
        Integer[] arr2 = new Integer[]{21, 22, 23, 24, 25, 26, 27};
        Integer[] arr3 = new Integer[]{50, 60, 70, 80, 90, 100};

        Node2<Integer> head1 = LinkedList.fromArray(arr1);
        Node2<Integer> head2 = LinkedList.fromArray(arr2);
        Node2<Integer> head3 = LinkedList.fromArray(arr3);

        Node2<Integer> tail1 = LinkedList.tail(head1);
        tail1.setNext(head3);

        Node2<Integer> tail2 = LinkedList.tail(head2);
        tail2.setNext(head3);

        Assert.assertEquals(LinkedList.areIntersecting(head1, head2), head3);
    }

    @Test
    public void zip_odd() {
        Integer[] arr = new Integer[]{0, 1, 2, 3, 4};
        Node2<Integer> head = LinkedList.fromArray(arr);

        LinkedList.zip(head);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(head);

        Assert.assertEquals(baos.toString(), "0, 4, 1, 3, 2\n");
    }

    @Test
    public void zip_even() {
        Integer[] arr = new Integer[]{0, 1, 2, 3, 4, 5};
        Node2<Integer> head = LinkedList.fromArray(arr);

        LinkedList.zip(head);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LinkedList.dump(head);

        Assert.assertEquals(baos.toString(), "0, 5, 1, 4, 2, 3\n");
    }
}
