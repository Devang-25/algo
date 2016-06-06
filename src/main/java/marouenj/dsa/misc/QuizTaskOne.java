/*
 * Problem description:
 * You are given a list of pairs. Each pair contains a food item and its price.
 * For example, ((apple, 120), (banana, 200), (apple, 150), ...).
 * Specific food items may occur multiple times within the list of pairs, with potentially varying prices.
 * For each food item, output the lowest, highest, and average price (rounded down to the nearest integer) for that item.
 * The output list should be lexicographically (alphabetically) sorted by name of food item.
 * 
 * Input:
 * Test cases will be provided in the following multi-line format.
 * The first line contains one integer, C, which is the number of test cases that will follow.
 * Each test case has the following format.
 * The first line contains one integer, N, which is the number of lines that will follow.
 * Each line contains one word, F[i], followed by a space, then one integer, X[i].
 * This gives one food item and price per line.
 * All N pairs form the input list.
 * 
 * Limits:
 * Test case count: 1 <= C <= 20
 * Line count per test case: 1 <= N <= 1000
 * Food item name: F[i] is composed of one to ten lowercase English letters.
 * Price range: 1 <= X[i] <= 1000
 * 
 * Output:
 * For each test case, output the following.
 * First, a single line with the format Case #i:
 * where i is the index of the test case, starting from 1.
 * Then, for each food item in the test case�s input list, output one line in this format:
 * X L H M
 * where X is the food item, L is its lowest price, H is its highest price, and M is its average price.
 * The average price M should be rounded down to the nearest integer.
 * The output list of food items must be sorted by item name in lexicographical order.
 * Each item may only appear once. The test cases should be in numerical order starting from 1.
 * 
 * Sample input:
 * 3
 * 3
 * banana 90
 * apple 100
 * apple 260
 * 5
 * grapefruit 120
 * grape 200
 * grapefruit 150
 * grapefruit 150
 * grape 180
 * 2
 * apple 100
 * apple 101
 * 
 * Sample output:
 * Case #1:
 * apple 100 260 180
 * banana 90 90 90
 * Case #2:
 * grape 180 200 190
 * grapefruit 120 150 140
 * Case #3:
 * apple 100 101 100
 */

package marouenj.dsa.misc;

import marouenj.dsa.reuse.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class QuizTaskOne {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> out = new ArrayList<>();

        int C = Integer.parseInt(in.nextLine());

        for (int i = 0; i < C; i++) {
            out.add("Case #" + (i + 1));
            forEachTestcase(in, out);
        }

        in.close();

        // output
        for (int i = 0; i < out.size(); i++)
            System.out.println(out.get(i));
    }

    public static void forEachTestcase(Scanner in, List<String> out) {
        Map<String, List<Integer>> tm = new TreeMap<>();

        int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            forEachEntry(in, tm);
        }

        for (Iterator<String> itr = tm.keySet().iterator(); itr.hasNext(); ) {
            String fruit = itr.next();

            int min = Collections.min(tm.get(fruit));
            int max = Collections.max(tm.get(fruit));
            int avg = Lists.avg(tm.get(fruit));

            out.add(fruit + " " + min + " " + max + " " + avg);
        }
    }

    public static void forEachEntry(Scanner in, Map<String, List<Integer>> tm) {
        String buffer = in.nextLine();
        int idx = buffer.indexOf(' ');
        String fruit = buffer.substring(0, idx);
        int price = Integer.parseInt(buffer.substring(idx + 1));

        if (!tm.containsKey(fruit)) {
            List<Integer> lst = new ArrayList<>();
            lst.add(price);

            tm.put(fruit, lst);
        } else {
            List<Integer> lst = tm.get(fruit);
            lst.add(price);

            tm.remove(fruit);
            tm.put(fruit, lst);
        }
    }
}
