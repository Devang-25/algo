package marouenj.dsa.eopi.chapter08_search;

import marouenj.dsa.reuse.Search;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Problem_14_Page_73 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            System.out.println("loading...");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/marwan/dev/workspace/Integer,1,000,000"));
            List<Integer> seq = (ArrayList<Integer>) ois.readObject();
            ois.close();
            System.out.println("starting...");
            List<Integer> largest = Search.kLargestElementsV2(seq, 15);
            System.out.println(largest);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
