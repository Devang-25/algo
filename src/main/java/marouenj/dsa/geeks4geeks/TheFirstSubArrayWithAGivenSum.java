package marouenj.dsa.geeks4geeks;

// http://www.geeksforgeeks.org/find-subarray-with-given-sum/
// Given an unsorted array of nonnegative integers, find a continuous sub-array which adds to a given number.
public class TheFirstSubArrayWithAGivenSum {

    // o(n2)
    public static int[] first(int[] arr, int sum) {
        if (arr == null || arr.length == 0 || sum < 0)
            return new int[]{-1, -1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sum)
                return new int[]{i, i};
            int tSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                tSum += arr[j];
                if (tSum == sum)
                    return new int[]{i, j};
                if (tSum > sum)
                    break;
            }
        }

        return new int[]{-1, -1};
    }

    // o(n)
    public static int[] second(int arr[], int sum) {
        if (arr == null || arr.length == 0 || sum < 0)
            return new int[]{-1, -1};

        int i = 0;
        int j = 0;
        int pad = -sum;
        for (; i < arr.length; i++) {
            if (i > 0)
                pad -= arr[i - 1];
            if (pad == 0)
                return new int[]{i, j};
            if (pad > 0)
                continue;
            for (; j < arr.length; j++) {
                pad += arr[j];
                if (pad == 0)
                    return new int[]{i, j};
                if (pad > 0)
                    break;
            }
        }

        return new int[]{-1, -1};
    }

    // o(n)
    public static int[] third(int arr[], int sum) {
        if (arr == null || arr.length == 0 || sum < 0)
            return new int[]{-1, -1};

        int tSum = 0;

        for (int lo = 0, hi = 0; hi < arr.length; hi++) {
            tSum += arr[hi];

            while (tSum > sum && lo <= hi) {
                tSum -= arr[lo];
                lo++;
            }

            if (tSum == sum) {
                return new int[]{lo, hi};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 15;

        int[] between = first(arr, sum);
        System.out.println(between[0] + ", " + between[1]);

        between = second(arr, sum);
        System.out.println(between[0] + ", " + between[1]);

        between = third(arr, sum);
        System.out.println(between[0] + ", " + between[1]);
    }

}