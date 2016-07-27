package marouenj.dsa.leetcode;

import java.util.ArrayList;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 10;
        }

        if (n == 2) {
            return 91;
        }

        if (n > 10) {
            n = 10;
        }

        int all = 9;
        ArrayList<Integer> prev = new ArrayList<>();
        for (int i = 3; i <= n; i++) {
            all += 9; // 11..1, 22..2, ..., 99..9
            all += 9; // 10.0, 20.0, ..., 90.0
            int p = 8;
            int curr = i * p * 9 + (i - 1) * 9;
            for (int j = 0; j < prev.size(); j++) {
                p--;
                int old = prev.get(j);
                int new_ = i * p * old + (i - 1) * old;
                prev.set(j, new_);
            }
            prev.add(0, curr);
        }

        for (int i = 0; i < prev.size(); i++) {
            all += prev.get(i);
        }

        return (int) Math.pow(10, n) - all;
    }
}