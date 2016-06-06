package marouenj.dsa.indeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Job implements Comparable<Job> {

    private String title;
    private String company;
    private String location;
    private String desc;
    private List<String> descTokens;

    public Job(String title, String company, String location, String desc) {
        super();
        this.title = title;
        this.company = company;
        this.location = location;
        this.desc = desc;
        this.descTokens = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(desc);
        while (st.hasMoreTokens())
            this.descTokens.add(st.nextToken().toString());
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getDesc() {
        return desc;
    }

    public List<String> getDescTokens() {
        return descTokens;
    }

    @Override
    public int compareTo(Job o) {
        int cmp = company.compareTo(o.getCompany());
        if (cmp != 0)
            return cmp;
        cmp = title.compareTo(o.getTitle());
        if (cmp != 0)
            return cmp;
        cmp = location.compareTo(o.getLocation());
        if (cmp != 0)
            return cmp;
        return 0;
    }

    @Override
    public String toString() {
        return "[ " + getCompany() + ", " + getTitle() + ", " + getLocation() + ", " + getDesc() + " ]";
    }

    public static void main(String[] args) {
        List<Job> c = new ArrayList<Job>();
        c.add(new Job("Google", "Software engineer", "Tokyo", "desc"));
        c.add(new Job("Yahoo", "Software engineer", "Zurich", "desc"));
        c.add(new Job("Google", "Software engineer", "Albania", "desc"));
        c.add(new Job("Yahoo", "Data science engineer", "Tokyo", "desc is very long"));
        c.add(new Job("Yahoo", "Data science engineer", "Tokyo", "desc"));
        c.add(new Job("Yahoo", "Data science engineer", "Tokyo", "desc is long"));
        c.add(new Job("Google", "Software engineer", "Zurich", "desc"));
        c.add(new Job("Microsoft", "Software engineer", "Seattle", "desc"));
        Collections.sort(c);
        for (Job j : c) {
            System.out.println(j);
        }
    }
}
