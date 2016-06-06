package marouenj.dsa.misc;

import java.util.Stack;

public class WordSearchInGrid {

    public static boolean serach_first_char(char[][] mat, String word) {
        boolean found = false;
        int i = 0;
        int j = 0;
        while (!found && j < mat.length) {
            if (mat[j][i] == word.charAt(0)) {
                found = search_remaining(mat, word, i, j);
            }
            i = ++i % mat[0].length;
            if (i == 0)
                j++;
        }
        return found;
    }

    public static boolean search_remaining(char[][] mat, String word, int i, int j) {
        boolean found = false;
        Stack<Quadruple<Integer, Integer, String, Integer>> stack = new Stack<Quadruple<Integer, Integer, String, Integer>>();
        for (int dir = 0; dir < dir_idx.length; dir++)
            stack.push(new Quadruple<Integer, Integer, String, Integer>(i + dir_idx[dir][0], j + dir_idx[dir][1], word.substring(1), dir));
        while (!found && !stack.isEmpty()) {
            Quadruple<Integer, Integer, String, Integer> current = stack.pop();
            int current_i = current.getA();
            int current_j = current.getB();
            char current_char = current.getC().charAt(0);
            if (current_j > -1 && current_j < mat.length && current_i > -1 && current_i < mat[0].length && mat[current_j][current_i] == current_char) {
                if (current.getC().length() == 1) {
                    found = true;
                    System.out.println("found: " + word + " at " + i + ", " + j + " on " + current.getD());
                } else {
                    current_i += dir_idx[current.getD()][0];
                    current_j += dir_idx[current.getD()][1];
                    current.setA(current_i);
                    current.setB(current_j);
                    current.setC(current.getC().substring(1));
                    stack.push(current);
                }
            }
        }
        return found;
    }

    static class Quadruple<A, B, C, D> {

        public Quadruple(A a, B b, C c, D d) {
            super();
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        public C getC() {
            return c;
        }

        public void setC(C c) {
            this.c = c;
        }

        public D getD() {
            return d;
        }

        public void setD(D d) {
            this.d = d;
        }

        private A a;
        private B b;
        private C c;
        private D d;
    }

//	private static int U = 0;
//	private static int R = 1;
//	private static int D = 2;
//	private static int L = 3;
//	private static int UR = 4;
//	private static int UL = 5;
//	private static int DR = 6;
//	private static int DL = 7;

    private static int[][] dir_idx = {
            {0, -1},
            {1, 0},
            {0, +1},
            {-1, 0},
            {+1, -1},
            {-1, -1},
            {+1, +1},
            {-1, +1}
    };

    public static void main(String[] args) {
        char[][] mat = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'},
        };
        serach_first_char(mat, "abcd");
    }
}
