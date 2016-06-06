package marouenj.dsa.geeks4geeks;

import java.util.HashMap;

// http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
// Given an array containing only 0s and 1s, find the largest subarray which contains equal number of 0s and 1s.
public class TheLargestSubArrayWithEqualNumberOf0sAnd1s {

    // o(n)
    public static int[] first(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int[]{0, 0};

        int n = arr.length;
        int from = 0;
        int to = 0;

        // first pass: convert 0 to -1
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        // second pass: compute sum of subarray from 0 to i
        int[] left = new int[n];
        left[0] = arr[0];
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + arr[i];
            if (left[i] < min) {
                min = left[i];
            } else if (left[i] > max) {
                max = left[i];
            }
        }

        // third pass: check the largest subarray starting from index 0
        for (int i = 1; i < n; i += 2) {
            if (left[i] == 0) {
                to = i;
            }
        }

        // fourth pass: check the largest subarray starting from an index greater than 0
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (!hm.containsKey(left[i])) {
                hm.put(left[i], i);
            } else if (i - hm.get(left[i]) > to - from) {
                to = i;
                from = hm.get(left[i]) + 1;
            }
        }

        return new int[]{from, to};
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1};

        int[] between = first(arr);
        System.out.println(between[0] + ", " + between[1]);
    }
}
