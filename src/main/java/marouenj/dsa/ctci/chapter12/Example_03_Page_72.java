package marouenj.dsa.ctci.chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example_03_Page_72 {

    public static int firstMissing(List<Integer> list, int memorySize) {
        int min = Collections.min(list);
        int max = Collections.max(list);
        int card = max - min + 1;

        int x = getX(card);
        int twoX = (int) Math.pow(2, x);

        int y = getX(memorySize * 8);
        int twoY = (int) Math.pow(2, y);

        if (twoX <= twoY) {
            return min + firstMissingInMemory(list, min, max, twoX);
        }

        int[] blocks = new int[twoX / twoY];

        int blockSize = twoY;

        int i;
        for (i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            int blockIdx = curr / blockSize;
            blocks[blockIdx]++;
        }

        i = -1;
        while (++i < blocks.length)
            return firstMissingInMemory(list, i * blockSize, (i + 1) * blockSize - 1, twoY);

        return -1;
    }

    public static int getX(int num) {
        int leftmost = leftmost(num);
        if (leftmost <= 0)
            return leftmost;
        int rightmost = rightmost(num);
        if (leftmost == rightmost)
            return leftmost;
        return leftmost + 1;
    }

    public static int leftmost(Integer num) {
        if (num < 0)
            return -1;
        if (num == 0)
            return 0;
        int mask = 1 << Integer.SIZE - 2;
        int shiftNum = -1;
        while ((num & mask) == 0) {
            mask = mask >> 1;
            shiftNum++;
        }
        return Integer.SIZE - 1 - shiftNum - 1;
    }

    public static int rightmost(Integer num) {
        if (num < 0)
            return -1;
        if (num == 0)
            return 0;
        int mask = 1;
        int shiftNum = 0;
        while ((num & mask) == 0) {
            mask = mask << 1;
            shiftNum++;
        }
        return shiftNum + 1;
    }

    public static Integer firstMissingInMemory(List<Integer> list, int lo, int hi, int maxNew) {
        int numBins = maxNew / Integer.SIZE;
        if (maxNew % Integer.SIZE != 0)
            numBins++;
        int[] bins = new int[numBins];

        int i;
        for (i = 0; i < list.size(); i++) {
            Integer curr = list.get(i);
            if (curr >= lo && curr <= hi) {
                curr -= lo;
                int binIdx = curr / Integer.SIZE;
                int idxWithinBin = curr % Integer.SIZE;
                bins[binIdx] |= (1 << idxWithinBin);
            }
        }

        i = -1;
        while (++i < bins.length) {
            int j = -1;
            while (++j < Integer.SIZE)
                if ((bins[i] & (1 << j)) == 0)
                    return lo + i * Integer.SIZE + j;
        }

        return null;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int missing = 350;
        for (int i = 0; i < missing; i++)
            list.add(i);
        for (int i = missing + 1; i < 445; i++)
            list.add(i);
        Collections.shuffle(list);
        System.out.println(firstMissing(list, 10));
    }

}
