package marouenj.dsa.indeed;

import marouenj.dsa.reuse.Search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SearchCommonWordsInTwoLists {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> sho = null;
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("/Users/marwan/dev/workspace/String,100,000"));
            sho = (ArrayList<String>) oos.readObject();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<String> lon = null;
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("/Users/marwan/dev/workspace/String,1,000,000"));
            lon = (ArrayList<String>) oos.readObject();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        long before;
        long after;

        before = System.currentTimeMillis();
        Collections.sort(sho);
//		Collections.sort(lon);
        after = System.currentTimeMillis();
        long time_sort = after - before;

        HashSet<String> visited = new HashSet<String>();

        double rate = 0.0;

        before = System.currentTimeMillis();
        rate = Search.commonWordsInTwoLists(lon, sho, visited, 0.05);
//		rate = Search.commonWordsInTwoLists(sho, lon, visited, 0.05);
        after = System.currentTimeMillis();
        long time_search = after - before;

        System.out.println("Rate: " + rate);
        System.out.println("Time to sort:   " + time_sort);
        System.out.println("Time to search: " + time_search);
        System.out.println("Total : " + (time_sort + time_search));
    }

}
