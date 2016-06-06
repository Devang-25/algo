package marouenj.dsa.codechef;

import java.util.Arrays;
import java.util.Scanner;

// http://www.codechef.com/problems/SWARM

public class Swarm {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            String[] params = sc.nextLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int k = Integer.parseInt(params[1]);
            int a = Integer.parseInt(params[2]);
            int b = Integer.parseInt(params[3]);
            int c = Integer.parseInt(params[4]);
            int m = Integer.parseInt(params[5]);
            int[] nbre_of_points = Swarm.nbre_of_points_per_side(n, a, b, c, m);
            System.out.println(Arrays.toString(nbre_of_points));
            System.out.println(nbre_of_k_gons(nbre_of_points, n, k));
        }
        sc.close();
    }

    public static int[] nbre_of_points_per_side(int n, int a, int b, int c, int m) {
        int[] nbre_points = new int[n];
        nbre_points[0] = a;
        for (int i = 1; i < n; i++) {
            nbre_points[i] = (b * nbre_points[i - 1] + c) % m;
        }
        return nbre_points;
    }

    public static int nbre_of_k_gons(int[] nbre_of_points, int n, int k) {
        int nbre_of_k_gons = 0;
        for (int i = 0; i < Math.pow(2, n); i++) {
            int j = i;
            int[] pos = new int[k];
            int idx_pos = 0;
            int current_bit = 0;
            while (j != 0 && idx_pos < k) {
                if ((j & 1) == 1)
                    pos[idx_pos++] = current_bit;
                current_bit++;
                j = j >> 1;
            }
            if (j == 0 && idx_pos == k) {
                System.out.println(Integer.toString(i, 2));
                int prod = 1;
                for (int x = 0; x < k; x++) {
                    prod *= nbre_of_points[pos[x]];
                }
                nbre_of_k_gons += (prod % 1000000007);
            }
        }
        return nbre_of_k_gons;
    }

}
