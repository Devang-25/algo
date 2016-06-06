/*
 * Time limit : 2sec / Stack limit : 256MB / Memory limit : 256MB
 * 
 * Question:
 * Your task is to connect N computers with cables that can communicate in both directions and to check if those computers can actually interact with each other.
 * Your work will follow the two instructions shown below:
 * 
 * make A B time
 * Connect Computer A and Computer B with a cable.
 * This cable will become unavailable when the value is bigger than time seconds. If the value equals to time seconds, the cable is still available.
 * Multiple cables may be connected between aforementioned Computer A and B.
 * 
 * check A B time
 * Predict if computer A and B can communicate within time seconds with the connected cable(s).
 * Computer A and B may be connected through other computers.
 * If Computer A and B can communicate, output YES in one string. If they can’t, output NO in one string.
 * The cables that are connected by all the make instructions existing after particular check instruction are not available in time series.
 * The instructions will be processed in the descending order of input.
 * 
 * Determine if Computer A and B are able to communicate every time there is check instruction. If they can communicate, please output YES in one string. If not, output NO in one string.
 * 
 * Input
 * Input will be given in the following format from Standard Input:
 * N Q
 * S1 A1 B1 time1
 * :
 * SQ AQ BQ timeQ
 * 
 * On the first string, N(2≦N≦20), an integer which shows the number of computers, and Q(1≦Q≦500), another integer which shows the number of the instructions, will be given with a half-width break.
 * From the second string to the N−th string, you will be given instructions.
 * 1≦A_k , B_k≦N and 1≦time_k≦10^4 are guaranteed.
 * There are only two kinds of S_k: make or check.
 * 
 * Output
 * Determine if Computer A and B are able to communicate every time there is check instruction. If they can communicate, please output YES in one string. If not, output NO in one string.
 * 
 * Also, make sure to insert a line break at the end of the output.
 * 
 * Input Example # 1
 * 3 5
 * make 1 2 1000
 * check 1 3 500
 * make 3 2 2000
 * check 1 3 500
 * check 1 3 1500
 * 
 * Output Example #1
 * NO
 * YES
 * NO
 * 
 * Input Example #2
 * 4 11
 * make 1 2 2000
 * make 2 3 3000
 * make 3 4 2500
 * check 1 4 1500
 * check 1 3 2000
 * check 1 3 2500
 * make 1 4 3000
 * check 1 3 2500
 * check 1 3 3000
 * make 2 4 3000
 * check 1 3 3000
 * Output Example #2
 * YES
 * YES
 * NO
 * YES
 * NO
 * YES
 */

package marouenj.dsa.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Task03 {

    // parse N and Q
    // gen matrix
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> out = new ArrayList<>();

        String[] str = in.nextLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int Q = Integer.parseInt(str[1]);

        int[][] mat = genConnectionMatrix(N);

        allQueries(in, out, mat, N, Q);

        in.close();

        // output
        for (int i = 0; i < out.size(); i++)
            System.out.println(out.get(i));
    }

    // gen matrix
    public static int[][] genConnectionMatrix(int N) {
        int[][] mat = new int[N - 1][];

        for (int i = 0; i < N - 1; i++) {
            mat[i] = new int[N - 1 - i];
        }

        return mat;
    }

    // for each query, parse make/check, nodes and time
    // call the appropriate function
    public static void allQueries(Scanner in, List<String> out, int[][] mat, int N, int Q) {
        for (int i = 0; i < Q; i++) {
            String[] str = in.nextLine().split(" ");
            int lo = Integer.parseInt(str[1]);
            int hi = Integer.parseInt(str[2]);
            if (lo > hi) {
                int t = lo;
                lo = hi;
                hi = t;
            }
            int time = Integer.parseInt(str[3]);
            if (str[0].equals("make")) {
                make(in, out, mat, N, lo, hi, time);
            } else if (str[0].equals("check")) {
                check(in, out, mat, lo, hi, time);
            } else {
                System.exit(1);
            }
        }
    }

    // if update is necessary, account for all the repercussions on the network
    public static void make(Scanner in, List<String> out, int[][] mat, int N, int lo, int hi, int time) {
        int lo_mapped = lo - 1;
        int hi_mapped = hi - lo_mapped - 2;

        if (mat[lo_mapped][hi_mapped] < time) {
            mat[lo_mapped][hi_mapped] = time;
            expandFrom(in, out, mat, N, lo);
            expandFrom(in, out, mat, N, hi);
        }
    }

    // expand the network of those who are connected to curr
    public static void expandFrom(Scanner in, List<String> out, int[][] mat, int N, int curr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(curr);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            for (int i = 1; i < curr; i++) {
                if (isConnected(mat, i, curr)) {
                    for (int j = curr + 1; j <= N; j++) {
                        int min = Math.min(get(mat, i, curr), get(mat, curr, j));
                        if (get(mat, i, j) < min) {
                            put(mat, i, j, min);
                            stack.push(i);
                            stack.push(j);
                        }
                    }
                }
            }
            for (int i = curr + 1; i <= N; i++) {
                if (isConnected(mat, curr, i)) {
                    for (int j = curr + 1; j < i; j++) {
                        int min = Math.min(get(mat, curr, i), get(mat, curr, j));
                        if (get(mat, j, i) < min) {
                            put(mat, j, i, min);
                            stack.push(i);
                            stack.push(j);
                        }
                    }
                    for (int j = i + 1; j <= N; j++) {
                        int min = Math.min(get(mat, curr, i), get(mat, curr, j));
                        if (get(mat, i, j) < min) {
                            put(mat, i, j, min);
                            stack.push(i);
                            stack.push(j);
                        }
                    }
                }
            }
        }
    }

    public static void check(Scanner in, List<String> out, int[][] mat, int lo, int hi, int time) {
        if (get(mat, lo, hi) >= time)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static boolean isConnected(int[][] mat, int lo, int hi) {
        int lo_mapped = lo - 1;
        int hi_mapped = hi - lo_mapped - 2;

        return mat[lo_mapped][hi_mapped] > 0;
    }

    public static int get(int[][] mat, int lo, int hi) {
        int lo_mapped = lo - 1;
        int hi_mapped = hi - lo_mapped - 2;

        return mat[lo_mapped][hi_mapped];
    }

    public static void put(int[][] mat, int lo, int hi, int val) {
        int lo_mapped = lo - 1;
        int hi_mapped = hi - lo_mapped - 2;

        mat[lo_mapped][hi_mapped] = val;
    }
}
