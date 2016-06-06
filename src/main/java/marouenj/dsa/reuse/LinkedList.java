package marouenj.dsa.reuse;

public class LinkedList {

	/*
     * serialization / deserialization
	 */

    public static <A extends Comparable<A>> Node2<A> fromArray(A[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node2<A> head = new Node2<>(arr[0]);
        Node2<A> curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.setNext(new Node2<>(arr[i]));
            curr = curr.getNext();
        }

        return head;
    }

	/*
	 * dump
	 */

    public static <A extends Comparable<A>> void dump(Node2<A> n) {
        if (n == null) {
            return;
        }

        System.out.print(n.getKey());
        n = n.getNext();
        while (n != null) {
            System.out.print(", " + n.getKey());
            n = n.getNext();
        }
        System.out.println();
    }
	
	/*
	 * length
	 */

    public static <A extends Comparable<A>> int length(Node2<A> n) {
        int len = 0;
        while (n != null) {
            len++;
            n = n.getNext();
        }
        return len;
    }

    public static <A extends Comparable<A>> int lengthCircular(Node2<A> n) {
        if (n == null) {
            return 0;
        }

        Node2<A> moving = n;
        int len = 0;
        do {
            moving = moving.getNext();
            len++;
        } while (moving != n);

        return len;
    }
	
	/*
	 * getters
	 */

    public static <A extends Comparable<A>> Node2<A> middle(Node2<A> n) {
        if (n == null) {
            return null;
        }

        Node2<A> slow = n;
        Node2<A> fast = n;

        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
            if (fast.getNext() != null) {
                fast = fast.getNext();
            } else {
                break;
            }
        }

        return slow;
    }

    public static <A extends Comparable<A>> Node2<A> tail(Node2<A> n) {
        if (n == null) {
            return null;
        }

        while (n.getNext() != null) {
            n = n.getNext();
        }

        return n;
    }

	/*
	 * new
	 */

    public static <A extends Comparable<A>> Node2<A> reverse(Node2<A> n) {
        Node2<A> prev = null;
        Node2<A> curr = n;

        while (curr != null) {
            Node2<A> tmp = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    public static <A extends Comparable<A>> Node2<A> split(Node2<A> n) {
        if (n == null || LinkedList.length(n) == 1) {
            return null;
        }

        Node2<A> prev = null;
        Node2<A> slow = n;
        Node2<A> fast = n;

        while (fast != null) {
            fast = fast.getNext();
            prev = slow;
            slow = slow.getNext();
            if (fast != null) {
                fast = fast.getNext();
            } else {
                break;
            }
        }

        prev.setNext(null);
        return slow;
    }

    public static <A extends Comparable<A>> Node2<A> merge(Node2<A> n, Node2<A> m) {
        if (n == null) {
            return m;
        }

        if (m == null) {
            return n;
        }

        A nMin = n.getKey();
        A mMin = m.getKey();

        if (nMin.compareTo(mMin) <= 0) {
            return mergeHelper(n, m);
        }

        return mergeHelper(m, n);
    }

    private static <A extends Comparable<A>> Node2<A> mergeHelper(Node2<A> lowest, Node2<A> two) {
        Node2<A> head = lowest;
        Node2<A> one = lowest.getNext();

        while (one != null && two != null) {
            if (one.getKey().compareTo(two.getKey()) <= 0) {
                lowest.setNext(one);
                lowest = one;
                one = one.getNext();
            } else {
                lowest.setNext(two);
                lowest = two;
                two = two.getNext();
            }
        }

        if (one == null) {
            lowest.setNext(two);
        } else {
            lowest.setNext(one);
        }

        return head;
    }

    public static <A extends Comparable<A>> Node2<A> evenOdd(Node2<A> n) {
        if (n == null) {
            return null;
        }

        Node2<A> headEven = n;
        Node2<A> headOdd = n.getNext();

        Node2<A> even = headEven;
        Node2<A> odd = headOdd;

        while (true) {
            if (odd == null) {
                even.setNext(headOdd);
                break;
            }

            even.setNext(odd.getNext());

            if (even.getNext() == null) {
                even.setNext(headOdd);
                break;
            }

            even = even.getNext();
            odd.setNext(even.getNext());
            odd = odd.getNext();
        }

        return headEven;
    }

    public static <A extends Comparable<A>> void zip(Node2<A> n) {
        if (n == null) {
            return;
        }

        Node2<A> n2 = LinkedList.reverse(LinkedList.split(n));

        while (n != null && n2 != null) {
            Node2<A> t = n.getNext();
            n.setNext(n2);

            Node2<A> t2 = n2.getNext();
            n2.setNext(t);

            n = t;
            n2 = t2;
        }
    }
	
	/*
	 * insertion
	 */

    public static <A extends Comparable<A>> boolean insertAt(Pointer<Node2<A>> n, Node2<A> node, int pos) {
        if (n == null || n.getPointee() == null || node == null || pos < 0) {
            return false;
        }

        if (pos == 1) {
            insertAtHead(n, node);
            return true;
        }

        Node2<A> prev = null;
        Node2<A> curr = n.getPointee();

        while (pos > 1 && curr != null) {
            pos--;
            prev = curr;
            curr = curr.getNext();
        }

        if (curr == null) {
            return false;
        }

        prev.setNext(node);
        node.setNext(curr);
        return true;
    }

    private static <A extends Comparable<A>> void insertAtHead(Pointer<Node2<A>> n, Node2<A> node) {
        node.setNext(n.getPointee());
        n.setPointee(node);
    }

    public static <A extends Comparable<A>> boolean insertAtTail(Node2<A> n, Node2<A> node) {
        Node2<A> tail = LinkedList.tail(n);

        if (tail == null) {
            return false;
        }

        tail.setNext(node);
        return true;
    }
	
	/*
	 * is* are*
	 */

    public static <A extends Comparable<A>> boolean isPalindrome(Node2<A> n) {
        Node2<A> m = LinkedList.reverse(LinkedList.split(n));

        while (n != null && m != null) {
            if (n.getKey() != m.getKey()) {
                return false;
            }

            n = n.getNext();
            m = m.getNext();
        }

        return true;
    }

    public static <A extends Comparable<A>> Node2<A> areIntersecting(Node2<A> n1, Node2<A> n2) {
        int len1 = LinkedList.length(n1);
        int len2 = LinkedList.length(n2);
        int x = len1 - len2;

        if (x >= 0) {
            while (x-- > 0) {
                n1 = n1.getNext();
            }
        } else {
            x = -x;
            while (x-- > 0) {
                n2 = n2.getNext();
            }
        }

        while (n1 != null && n1 != n2) {
            n1 = n1.getNext();
            n2 = n2.getNext();
        }

        return n1;
    }
}
