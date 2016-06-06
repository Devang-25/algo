package marouenj.dsa.eopi.chapter08_search;

import marouenj.dsa.reuse.Search;

public class Problem_18_Page_74 {

    public static void main(String[] args) {
        int[] close = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Search.keyInArrayWithCloseEntries(close, 8));
    }

}
