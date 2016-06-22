package marouenj.dsa.reuse;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchTree2 {

    /**
     * Check if a binary tree is a binary search tree
     *
     * @param n   Root
     * @param min Minimal value as determined by the {@link java.util.Comparator}
     * @param max Maximal value as determined by the {@link java.util.Comparator}
     * @param <A> Key type
     * @return True if tree is BST
     */
    public static <A extends Comparable<A>> boolean isSearchTree2(Node2<A> n, A min, A max) {
        if (min == null || max == null) {
            throw new NullPointerException();
        }

        return isSearchTree2Helper(n, min, max);
    }

    private static <A extends Comparable<A>> boolean isSearchTree2Helper(Node2<A> n, A min, A max) {
        if (n == null) {
            return true;
        }

        A key = n.getKey();
        if (key.compareTo(min) <= 0 || key.compareTo(max) >= 0) {
            return false;
        }

        return isSearchTree2Helper(n.getLeft(), min, n.getKey()) && isSearchTree2Helper(n.getRight(), n.getKey(), max);
    }

	/*
     * search
	 */

    public static <A extends Comparable<A>> Node2<A> min(Node2<A> n) {
        if (n == null) {
            return null;
        }

        while (n.getLeft() != null) {
            n = n.getLeft();
        }

        return n;
    }

    public static <A extends Comparable<A>> Node2<A> max(Node2<A> n) {
        if (n == null) {
            return null;
        }

        while (n.getRight() != null) {
            n = n.getRight();
        }

        return n;
    }

    public static <A extends Comparable<A>> Node2<A> get(Node2<A> n, A key) {
        if (n == null || key == null) {
            return null;
        }

        while (n != null) {
            A curr = n.getKey();

            if (curr.compareTo(key) == 0) {
                return n;
            }

            if (curr.compareTo(key) > 0) {
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        }

        return null;
    }

    public static <A extends Comparable<A>> Node2<A> getMinFirst(Node2<A> n, A key) {
        if (key == null) {
            throw new RuntimeException("unvalid arg");
        }

        if (n == null) {
            return null;
        }

        A min = n.getKey();
        int c = min.compareTo(key);

        if (c > 0) {
            return null;
        }

        if (c == 0) {
            return n;
        }

        while (true) {
            Node2<A> l = n.getLeft();
            Node2<A> r = n.getRight();

            if (l == null && r == null) {
                return null;
            }

            if (l != null && r != null) {
                min = l.getKey();
                c = min.compareTo(key);

                if (c > 0) {
                    return null;
                }

                if (c == 0) {
                    return l;
                }

                min = r.getKey();
                c = min.compareTo(key);

                if (c > 0) {
                    n = l;
                    continue;
                }

                if (c == 0) {
                    return r;
                }

                n = r;
                continue;
            }

            if (l != null) {
                n = l;
            } else { // r != null
                n = r;
            }

            min = n.getKey();
            c = min.compareTo(key);

            if (c > 0) {
                return null;
            }

            if (c == 0) {
                return n;
            }
        }
    }

    public static <A extends Comparable<A>> Node2<A> succ(Node2<A> n, A key) {
        Node2<A> curr = get(n, key);

        if (curr == null) {
            return null;
        }

        if (curr.getRight() != null) {
            return min(curr.getRight());
        }

        return succAbove(n, key);
    }

    private static <A extends Comparable<A>> Node2<A> succAbove(Node2<A> n, A key) {
        Node2<A> succ = null;

        int cmp = n.getKey().compareTo(key);
        while (cmp != 0) {
            if (cmp > 0) {
                succ = n;
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
            cmp = n.getKey().compareTo(key);
        }

        return succ;
    }

    public static <A extends Comparable<A>> Node2<A> larger(Node2<A> n, A key) {
        if (key == null) {
            throw new RuntimeException("unvalid arg");
        }

        if (n == null) {
            return null;
        }

        A potential = null;

        while (n != null) {
            A curr = n.getKey();
            int c = curr.compareTo(key);

            if (c > 0) {
                potential = curr;
                n = n.getLeft();
            } else {
                n = n.getRight();
            }
        }

        if (potential == null) {
            return null;
        }

        return new Node2<>(potential);
    }

    public static <A extends Comparable<A>> List<A> kLargest(Node2<A> n, int k) {
        if (k <= 0) {
            throw new RuntimeException("unvalid arg");
        }

        List<A> kLargest = new ArrayList<>();

        if (n == null) {
            return kLargest;
        }

        boolean push = true;
        Stack<Node2<A>> potential = new Stack<>();

        while (k > 0 && (push || !potential.isEmpty())) {
            if (push) {
                potential.push(n);
                if (n.getRight() != null) {
                    n = n.getRight();
                } else {
                    push = false;
                }
            } else { // pop
                n = potential.pop();
                kLargest.add(0, n.getKey());
                k--;
                if (n.getLeft() != null) {
                    n = n.getLeft();
                    push = true;
                }
            }
        }

        return kLargest;
    }

	/*
     * set
	 */

    public static <A extends Comparable<A>> boolean insert(Node2<A> n, A key) {
        if (n == null || key == null) {
            return false;
        }

        while (true) {
            A curr = n.getKey();
            int c = curr.compareTo(key);

            if (c == 0) {
                return false;
            }

            if (c > 0) { // left
                if (n.getLeft() == null) {
                    n.setLeft(new Node2<>(key));
                    return true;
                }
                n = n.getLeft();
            } else { // right
                if (n.getRight() == null) {
                    n.setRight(new Node2<>(key));
                    return true;
                }
                n = n.getRight();
            }
        }
    }

    public static <A extends Comparable<A>> boolean remove(Pointer<Node2<A>> ptrRoot, A key) {
        return false;
    }

    public static <K extends Comparable<K>> boolean remove(K key, Pointer<Node2<K>> root) {
        Node2<K> par = null;
        Node2<K> moving = root.getPointee();
        while (moving != null && moving.getKey().compareTo(key) != 0) {
            par = moving;
            if (moving.getKey().compareTo(key) > 0)
                moving = moving.getLeft();
            else
                moving = moving.getRight();
        }

        if (moving == null) // not found
            return false;

        if (moving.getRight() == null) {
            replaceParentChildLink(root, par, moving, moving.getLeft());
        } else {
            Node2<K> succ = min(moving.getRight());
            remove(succ.getKey(), new Pointer<Node2<K>>(moving));
            succ.setLeft(moving.getLeft());
            if (moving.getRight() == succ)
                succ.setRight(null);
            else
                succ.setRight(moving.getRight());

            replaceParentChildLink(root, par, moving, succ);
        }
        return true;
    }

    public static <K extends Comparable<K>> void replaceParentChildLink(Pointer<Node2<K>> root, Node2<K> par, Node2<K> child, Node2<K> newChild) {
        if (par == null) {
            root.setPointee(newChild);
        } else {
            if (par.getLeft() == child) {
                par.setLeft(newChild);
            } else {
                par.setRight(newChild);
            }
        }
    }
	
	/*
	 * to linked list
	 */

    public static <K extends Comparable<K>> Node2<K> toLinkedList(Node2<K> n) {
        if (n == null) {
            return null;
        }

        Node2<K> min = min(n);

        Node2<K> prev = null;
        Stack<Node2<K>> stack = new Stack<>();

        while (n != null || !stack.empty()) {
            if (n != null) {
                stack.push(n);
                n = n.getLeft();
            } else {
                n = stack.pop();
                if (prev != null) {
                    n.setPrev(prev);
                    prev.setNext(n);
                }
                prev = n;
                n = n.getRight();
            }
        }

        return min;
    }
}
