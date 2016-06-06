package marouenj.dsa.ctci.chapter01;

import marouenj.dsa.reuse.sort.Heap;

import java.util.ArrayList;
import java.util.List;

public class Example_01_Page_48 {

    public static Boolean isAllUnique(String str) {
        if (str == null)
            return null;
        int i = -1;
        while (++i < str.length() - 1) {
            int j = i;
            while (++j < str.length() && str.charAt(i) != str.charAt(j)) ;
            if (j < str.length())
                return false;
        }
        return true;
    }

    public static Boolean isAllUnique2(String str) {
        if (str == null)
            return null;
        List<Character> lst = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            lst.add((Character) str.charAt(i));
        }
        Heap.inc.sort(lst);
        int i = 0;
        while (++i < lst.size() && lst.get(i - 1) != lst.get(i)) ;
        return (i == lst.size());
    }

    public static Boolean isAllUnique3(String str) {
        if (str == null)
            return null;
        boolean[] charSet = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if (charSet[val])
                return false;
            charSet[val] = true;
        }
        return true;
    }

    public static Boolean isAllUnique4(String str) {
        if (str == null)
            return null;
        int charSet = 0;
        for (int i = 0; i < str.length(); i++) {
            int shift = str.charAt(i) - 'a';
            if ((charSet & (1 << shift)) > 0)
                return false;
            charSet |= (1 << shift);
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            str.append((char) ((int) 'a' + i));
        }
        System.out.println(str.toString() + ", " + isAllUnique(str.toString()));
        System.out.println("aa" + ", " + isAllUnique3("aa"));
        System.out.println(str.toString() + ", " + isAllUnique(str.toString()));
        System.out.println("aa" + ", " + isAllUnique3("aa"));
        System.out.println(str.toString() + ", " + isAllUnique4(str.toString()));
        System.out.println("aa" + ", " + isAllUnique4("aa"));
        System.out.println(str.toString() + ", " + isAllUnique2(str.toString()));
        System.out.println("aa" + ", " + isAllUnique2("aa"));
    }

}
