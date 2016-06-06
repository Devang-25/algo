package algo.misc;

import java.util.Stack;

public class MaximumRectangularAreaUnderHistogram {

    public static int max_1(int[] hist) {
        int max = -1;

        Stack<Integer> val = new Stack<Integer>();
        Stack<Integer> leftSpan = new Stack<Integer>();

        for (int i = 0; i < hist.length; i++) {
            int span = 0;
            while (!val.empty() && val.peek() >= hist[i]) {
                int tmp_val = val.pop();
                int tmp_leftSpan = leftSpan.pop();
                span += tmp_leftSpan;
                max = Math.max(max, span * tmp_val);
            }
            val.push(hist[i]);
            leftSpan.push(span + 1);
        }

        int tmp_rightSpan = 0;
        while (!val.empty()) {
            int span = leftSpan.pop() + tmp_rightSpan;
            max = Math.max(max, span * val.pop());
            tmp_rightSpan = span;
        }

        return max;
    }

    public static void main(String args[]) {
        int[] hist = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(max_1(hist));
    }

}
