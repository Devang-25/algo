package marouenj.dsa.eopi.chapter12_meta;

import marouenj.dsa.reuse.Pair;
import marouenj.dsa.reuse.sort.Quick;

import java.util.ArrayList;
import java.util.List;

public class Problem_01_Page_97 {

    public List<Pair<Integer, Integer>> buildSkyline(List<Building> buildings) {
        if (buildings == null || buildings.size() == 0)
            return null;
        Quick.inc.sort(buildings, 0, buildings.size());
        List<Pair<Integer, Integer>> skyline = new ArrayList<>();
        // first
        int curr_l = buildings.get(0).getL();
        int curr_h = buildings.get(0).getH();
        int curr_r = buildings.get(0).getR();
        add(skyline, curr_l, curr_h, true);
        add(skyline, curr_r, curr_h, false);

        int prev_r = curr_r;
        int prev_h = curr_h;

        int i;
        for (i = 1; i < buildings.size() - 1; i++) {
            if ((curr_l = buildings.get(i).getL()) > prev_r) {
                add(skyline, prev_r, prev_h, false);
                prev_r = -1;
                prev_h = -1;
            }
            if ((curr_h = buildings.get(i).getH()) > prev_h && curr_l < buildings.get(i + 1).getL()) {
                add(skyline, curr_l, curr_h, true);
                prev_r = curr_r;
                prev_h = curr_h;
            }
        }
        // last
        if ((curr_l = buildings.get(i).getL()) > prev_r) {
            add(skyline, prev_r, prev_h, false);
            prev_r = -1;
            prev_h = -1;
        }
        if ((curr_h = buildings.get(i).getH()) > prev_h) {
            add(skyline, curr_l, curr_h, true);
            prev_r = curr_r;
            prev_h = curr_h;
        }

        return null;
    }

    public void add(List<Pair<Integer, Integer>> skyline, int x, int h, boolean up) {
        if (up) {
            skyline.add(new Pair<>(x, 0));
            skyline.add(new Pair<>(x, h));
        } else {
            skyline.add(new Pair<>(x, h));
            skyline.add(new Pair<>(x, 0));
        }
    }

}

class Building implements Comparable<Building> {

    private int l; // left corner
    private int r; // right corner
    private int h; // height

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public int compareTo(Building o) {
        int cmp;
        cmp = (l < o.l) ? -1 : ((l == o.l) ? 0 : 1);
        if (cmp != 0)
            return cmp;
        cmp = (h < o.h) ? -1 : ((h == o.h) ? 0 : 1);
        if (cmp != 0)
            return cmp;
        cmp = (r < o.r) ? -1 : ((r == o.r) ? 0 : 1);
        return cmp;
    }

    @Override
    public String toString() {
        return "[" + l + ", " + h + ", " + r + "]";
    }

}