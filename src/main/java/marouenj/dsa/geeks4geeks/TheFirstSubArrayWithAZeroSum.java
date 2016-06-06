package marouenj.dsa.geeks4geeks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
// Given an array of positive and negative numbers, find if there is a sub-array with 0 sum.
public class TheFirstSubArrayWithAZeroSum {

    // o(n2)
    public static int[] first(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int[]{-1, -1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                return new int[]{i, i};
            int tSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                tSum += arr[j];
                if (tSum == 0)
                    return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    // o(n)
    // hashing
    public static Boolean second(int arr[]) {
        if (arr == null || arr.length == 0)
            return null;

        // key: sum between 0 and i
        // val: list of indexes (i) satisfying the zero sum
        Map<Integer, Set<Integer>> hash = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            Set<Integer> set = null;
            if (hash.containsKey(sum)) {
                set = hash.get(sum);
            } else {
                set = new TreeSet<Integer>();
            }
            set.add(i);
            hash.put(sum, set);
        }

        for (Iterator<Integer> itr = hash.keySet().iterator(); itr.hasNext(); ) {
            if (hash.get(itr.next()).size() == 1) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, -2, 1, 3, -4, 1, 4, -2, -2, -5};

        int[] between = first(arr);
        System.out.println(between[0] + ", " + between[1]);

        System.out.println(second(arr));
    }

}