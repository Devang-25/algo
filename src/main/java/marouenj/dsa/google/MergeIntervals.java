package marouenj.dsa.google;

import marouenj.dsa.reuse.Pair;

import java.util.ArrayList;

public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Pair<Integer, Integer>> intervals = new ArrayList<Pair<Integer, Integer>>();
        intervals.add(new Pair<Integer, Integer>(0, 2));
        intervals.add(new Pair<Integer, Integer>(1, 2));
        intervals.add(new Pair<Integer, Integer>(2, 5));
        intervals.add(new Pair<Integer, Integer>(2, 6));
        System.out.println(intervals.toString());
        ArrayList<Pair<Integer, Integer>> merged = merge(intervals);
        System.out.println(merged.toString());
    }

    public static ArrayList<Pair<Integer, Integer>> merge(ArrayList<Pair<Integer, Integer>> intervals) {
        ArrayList<Pair<Integer, Integer>> merged = new ArrayList<Pair<Integer, Integer>>();
        int currentMin = intervals.get(0).getA();
        int maxSoFar = intervals.get(0).getB();
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).getA() == currentMin) {
                if (intervals.get(i).getB() > maxSoFar) {
                    maxSoFar = intervals.get(i).getB();
                }
            } else {
                merged.add(new Pair<Integer, Integer>(currentMin, maxSoFar));
                currentMin = intervals.get(i).getA();
                maxSoFar = intervals.get(i).getB();
            }
        }
        return merged;
    }
}
