package marouenj.dsa.eopi.chapter08_search;

import marouenj.dsa.reuse.Gen;
import marouenj.dsa.reuse.select.Quick;

import java.util.List;

public class Problem_13_Page_72 {

    public static void main(String args[]) {
        int size = 20;
        int max_val = 20;
        List<Integer> lst = Gen.listOfInteger(size, max_val, false);

        int k = 5;

        System.out.println(lst.toString());
        System.out.println(Quick.dec.select(lst, 0, k, lst.size() - 1));
        System.out.println(lst.toString());
    }
}
