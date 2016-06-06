/*
 * Problem description:
 * There are several projects, and each is denoted by a one letter name.
 * Each project may depend on one or more other projects (or none).
 * For example, if project A depends on project B, then project A cannot complete before project B.
 * Suppose you are given a list L, of K such dependencies, and also a list D, of J projects that have been delayed.
 * Output a list of all projects that will be delayed, in lexicographical (alphabetical) order.
 * You can assume that a project, A, will be delayed if any project A depends on is delayed.
 * The input is guaranteed to contain no circular dependencies.
 * 
 * Input:
 * Test cases will be provided in the following multi-line format.
 * The first line contains one integer, C, which is the number of test cases that will follow.
 * Each test case has the following format.
 * The first line of a test case contains two integers, K and J, separated by a space.
 * K is the number of dependencies, and J is the number of delayed projects.
 * K lines follow, each with the format:
 * X depends on Y
 * where X and Y are the names of projects, which are single uppercase English letters.
 * Each pair gives a project dependency: Y must complete before X can complete.
 * All K lines together form the list L of project dependencies.
 * Finally, the last line contains J space­delimited project names (single letters, uppercase).
 * This gives the list D of length J of projects that have been delayed.
 * Each project in D is listed in the dependency list at least once.
 * 
 * Limits:
 * Test case count: 1 <= C <= 20
 * Number of dependencies: 1 <= K <= 100
 * Number of projects: 1 <= J <= 26
 * Project name: Each name is a single uppercase letter from A to Z.
 * 
 * Output:
 * For each test case, output one line containing the test case index, starting from 1, followed by ...
 * a space-­delimited list of projects that will be delayed.
 * The list must be in lexicographically sorted order.
 * The resulting line should be in this format:
 * Case #i: X[1] X[2] ...
 * where i is the index of the test case, starting from 1, and X[k] are the names of the projects that were delayed.
 * 
 * Sample input:
 * 3
 * 2 1
 * B depends on A
 * C depends on B
 * B
 * 5 2
 * P depends on Q
 * P depends on S
 * Q depends on R
 * R depends on T
 * S depends on T
 * Q S
 * 8 2
 * B depends on A
 * C depends on B
 * C depends on E
 * D depends on C
 * D depends on F
 * E depends on A
 * F depends on E
 * G depends on F
 * B F
 * 
 * Sample output:
 * Case #1: B C
 * Case #2: P Q S
 * Case #3: B C D F G
 */

package marouenj.dsa.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class QuizTaskTwo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> out = new ArrayList<>();

        int C = Integer.parseInt(in.nextLine());

        for (int i = 0; i < C; i++) {
            forEachTestcase(in, out, i + 1);
        }

        in.close();

        // output
        for (int i = 0; i < out.size(); i++)
            System.out.println(out.get(i));
    }

    public static void forEachTestcase(Scanner in, List<String> out, int caseId) {
        Map<Character, List<Character>> dep = new HashMap<>();
        Set<Character> delayed = new TreeSet<>();

        String buffer = in.nextLine();
        int idx = buffer.indexOf(' ');
        int K = Integer.parseInt(buffer.substring(0, idx));
        int J = Integer.parseInt(buffer.substring(idx + 1));

        for (int i = 0; i < K; i++) {
            forEachDependency(in, dep);
        }

        buffer = in.nextLine();

        for (int i = 0; i < J; i++) {
            forEachDelayed(in, dep, delayed, buffer.charAt(i * 2));
        }

        String oneOutput = "Case #" + caseId;
        for (Iterator<Character> itr = delayed.iterator(); itr.hasNext(); ) {
            oneOutput += " " + itr.next();

        }
        out.add(oneOutput);
    }

    public static void forEachDependency(Scanner in, Map<Character, List<Character>> dep) {
        String buffer = in.nextLine();

        char then = buffer.charAt(0);
        char first = buffer.charAt(buffer.length() - 1);

        if (!dep.containsKey(first)) {
            List<Character> lst = new ArrayList<>();
            lst.add(then);

            dep.put(first, lst);
        } else {
            List<Character> lst = dep.get(first);
            lst.add(then);

            dep.remove(first);
            dep.put(first, lst);
        }
    }

    public static void forEachDelayed(Scanner in, Map<Character, List<Character>> dep, Set<Character> delayed, Character curr) {
        Stack<Character> stack = new Stack<>();
        stack.push(curr);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            delayed.add(curr);
            if (dep.containsKey(curr)) {
                for (Iterator<Character> itr = dep.get(curr).iterator(); itr.hasNext(); ) {
                    stack.push(itr.next());
                }
            }
        }
    }
}
