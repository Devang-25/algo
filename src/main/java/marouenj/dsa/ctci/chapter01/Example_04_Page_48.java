package marouenj.dsa.ctci.chapter01;

import marouenj.dsa.reuse.sort.Heap;

import java.util.ArrayList;
import java.util.List;

public class Example_04_Page_48 {

    public static Boolean anagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        List<Character> lst1 = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            lst1.add((Character) str1.charAt(i));
        }
        Heap.inc.sort(lst1);

        List<Character> lst2 = new ArrayList<>();
        for (int i = 0; i < str2.length(); i++) {
            lst2.add((Character) str2.charAt(i));
        }
        Heap.inc.sort(lst2);

        return lst1.equals(lst2);
    }

    public static Boolean anagram2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        int[] charSet = new int[26];
        int i;
        for (i = 0; i < str1.length(); i++) {
            charSet[(int) str1.charAt(i) - (int) 'a']++;
        }

        for (i = 0; i < str2.length(); i++) {
            if (charSet[(int) str2.charAt(i) - (int) 'a'] == 0)
                return false;
            charSet[(int) str2.charAt(i) - (int) 'a']--;
        }

        i = -1;
        while (++i < charSet.length && charSet[i] == 0) ;

        if (i < charSet.length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String str1 = "aabbcc";
        String str2 = "aaccbb";
        System.out.println(anagram(str1, str2));
        System.out.println(anagram2(str1, str2));
    }

}
