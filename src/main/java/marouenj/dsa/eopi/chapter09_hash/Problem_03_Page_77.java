package marouenj.dsa.eopi.chapter09_hash;

import marouenj.dsa.reuse.Node2;

public class Problem_03_Page_77 {

    public static <T extends Comparable<T>> void dump(Node2<T> root) {
        if (root != null) {
            System.out.println(root.getKey() + ", " + root.address());
            dump(root.getLeft());
            dump(root.getRight());
        }
    }

//	public static void main(String[] args) {
//		Integer[] pre1 = {3, 2, 1, 0};
//		Integer[] in1  = {0, 1, 2, 3};
//		Node2<Integer> root1 = Tree2.TreeFromPreOrderInOrder(in1, 0, in1.length-1, pre1, 0, pre1.length-1);
//		
//		Integer[] pre2 = {9, 5, 3, 7, 11};
//		Integer[] in2  = {3, 5, 7, 9, 11};
//		Node2<Integer> root2 = Tree2.TreeFromPreOrderInOrder(in2, 0, in2.length-1, pre2, 0, pre2.length-1);
//
//		Integer[] pre3 = {2, 1, 0, 5, 3, 7};
//		Integer[] in3  = {0, 1, 2, 3, 5, 7};
//		Node2<Integer> root3 = Tree2.TreeFromPreOrderInOrder(in3, 0, in3.length-1, pre3, 0, pre3.length-1);
//		
//		dump(root1);
//		System.out.println();
//		dump(root2);
//		System.out.println();
//		dump(root3);
//		System.out.println();
//		
//		Map<Node2<Integer>, Node2<Integer>> dic = new HashMap<>();
//		
//		Node2<Integer> root1c = Tree2.getCanonical(root1, dic);
//		Node2<Integer> root2c = Tree2.getCanonical(root2, dic);
//		Node2<Integer> root3c = Tree2.getCanonical(root3, dic);
//
//		dump(root1c);
//		System.out.println();
//		dump(root2c);
//		System.out.println();
//		dump(root3c);
//		System.out.println();
//		
//	}
}
