package marouenj.dsa.reuse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Gen {

    // String

    public static String string(int word_len_bound) {
        int word_len = (int) (1 + Math.random() * (word_len_bound - 1));
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < word_len; j++) {
            char letter = (char) (65 + (int) (Math.random() * 25));
            s.append(letter);
        }
        return s.toString();
    }

    public static List<String> listOfString(int list_len, int word_len_bound) {
        List<String> lst = new ArrayList<String>(list_len);
        for (int i = 0; i < list_len; i++) {
            lst.add(string(word_len_bound));
        }
        return lst;
    }

    public static List<String> listOfStringWithMajority(String dominant, double rate, int list_len, int word_len_bound) {
        List<String> lst = new ArrayList<String>(list_len);
        for (int i = 0; i < list_len; i++) {
            if (Math.random() <= rate)
                lst.add(dominant);
            else
                lst.add(string(word_len_bound));
        }
        return lst;
    }

    // Integer

    public static Integer integer(int max_val) {
        return (int) (Math.random() * max_val);
    }

    public static Integer[] arrayOfInteger(int max_len, int max_val, boolean var_len) {
        int len = max_len;
        if (var_len)
            len = (int) (Math.random() * max_len);
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            int val = (int) (Math.random() * max_val);
            arr[i] = val;
        }
        return arr;
    }

    public static List<Integer> listOfInteger(int max_len, int max_val, boolean var_len) {
        int len = max_len;
        if (var_len)
            len = (int) (Math.random() * max_len);
        List<Integer> arr = new ArrayList<Integer>(len);
        for (int i = 0; i < len; i++) {
            int val = (int) (Math.random() * max_val);
            arr.add(i, val);
        }
        return arr;
    }

    // Long

    public static List<Long> timestampSerie(int n, int step) {
        List<Long> lst = new ArrayList<Long>();
        long current = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            current += (int) (Math.random() * step);
            lst.add(current);
        }
        return lst;
    }

    public static List<Long> timestampSerieWithDelay(int n, int step, int k) {
        List<Long> lst = timestampSerie(n, step);
        for (int i = n - k - 1; i >= 0; ) {
            int delay = (int) (Math.random() * k);
            Lists.translateDown(lst, i, i + delay);
            i -= (k - delay + 1);
        }
        return lst;
    }

    public static void main(String[] args) {
        List<String> lon01 = Gen.listOfString(100000, 10);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/marwan/dev/workspace/gen/String,100,000"));
            oos.writeObject(lon01);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

//	public static void main(String[] args) {
//		try {
//			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/marwan/dev/workspace/String,100,000"));
//			ArrayList<String> lon01 = (ArrayList<String>) ois.readObject();
//			ois.close();
//			System.out.println(lon01.size() + ", " + lon01.get(0));
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

}
