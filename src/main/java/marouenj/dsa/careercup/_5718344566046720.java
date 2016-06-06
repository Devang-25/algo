package marouenj.dsa.careercup;

import java.util.Arrays;

// https://www.careercup.com/question?id=5718344566046720
// Given an array of strings, remove the anagrams
public class _5718344566046720 {

    public String[] solution(String[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        // sort individual strings (car -> acr)
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            Arrays.sort(chars);
            arr[i] = new String(chars);
        }

        // sort the arr of sorted strings
        Arrays.sort(arr);

        // remove anagrams
        int curr = 0;
        int nextWrite = 0;
        boolean unique = true;
        while (curr < arr.length - 1) {
            if (arr[curr].equals(arr[curr + 1])) {
                unique = false;
            } else {
                if (unique) {
                    arr[nextWrite] = arr[curr];
                    nextWrite++;
                } else {
                    unique = true;
                }
            }
            curr++;
        }

        if (!arr[curr - 1].equals(arr[curr])) {
            arr[nextWrite] = arr[curr];
            nextWrite++;
        }

        // write to new arr
        String[] newArr = new String[nextWrite];
        for (int i = 0; i < nextWrite; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }
}
