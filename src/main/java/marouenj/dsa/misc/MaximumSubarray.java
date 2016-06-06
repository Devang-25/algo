package algo.misc;

public class MaximumSubarray {

    public static void main(String[] args) {
        Integer[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArr = 0;
        int curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr += arr[i];
            curr = Math.max(curr, arr[i]);
            maxSubArr = Math.max(maxSubArr, curr);
        }
        System.out.println(maxSubArr);
    }
}
