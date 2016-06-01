package marouenj.dsa.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://codility.com/programmers/challenges/lithium2013/
public class Lithium2013 {

    public int solution(int[][] arr, int p) {
        int nClocks = arr.length;
        int mHands = arr[0].length;

        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < nClocks; i++) { // per clock
            int[] clock = arr[i];

            int min = clock[0];
            for (int j = 1; j < mHands; j++) { // get the min
                if (clock[j] < min) {
                    min = clock[j];
                }
            }

            for (int j = 0; j < mHands; j++) { // subtract the min
                clock[j] -= min;
                clock[j]++;
            }

            int min2 = -1;
            for (int j = 0; j < mHands; j++) { // get a value that's not the min
                if (clock[j] != 1) {
                    min2 = clock[j];
                    break;
                }
            }

            if (min2 != -1) {
                for (int j = 0; j < mHands; j++) { // get the second min
                    if (clock[j] == 1) {
                        continue;
                    }

                    if (clock[j] < min2) {
                        min2 = clock[j];
                    }
                }

                int half = 1 + p / 2;
                if (min2 > half) {
                    for (int j = 0; j < mHands; j++) { // rotate hands
                        if (clock[j] != 1) {
                            clock[j] = 1 + (p - clock[j] + 1);
                        }
                    }
                }
            }

            Arrays.sort(clock); // sort

            String hash = clock[0] + "";
            for (int j = 1; j < mHands; j++) { // create signature
                hash += "," + clock[j];
            }

            int old = 0;
            if (hm.containsKey(hash)) { // add to hash map
                old = hm.get(hash);
            }
            hm.put(hash, old + 1);
        }

        int count = 0;

        Set<String> keys = hm.keySet();
        for (String key : keys) { // combinations per signature
            int occ = hm.get(key);
            count += (occ * (occ - 1) >> 1);
        }

        return count;
    }
}
