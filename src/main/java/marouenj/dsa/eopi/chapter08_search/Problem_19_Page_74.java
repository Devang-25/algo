package marouenj.dsa.eopi.chapter08_search;

import marouenj.dsa.reuse.Gen;
import marouenj.dsa.reuse.Search;

import java.util.List;

public class Problem_19_Page_74 {

    public static void main(String[] args) {
        List<String> seq = Gen.listOfStringWithMajority("Marouen", 0.51, 1000000, 10);
        System.out.println(Search.majority(seq));
    }

}
