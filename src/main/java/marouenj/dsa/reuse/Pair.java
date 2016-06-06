package marouenj.dsa.reuse;

@SuppressWarnings("rawtypes")
public class Pair<A extends Comparable<A>, B extends Comparable<B>> implements Comparable<Pair> {

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return this.a;
    }

    public B getB() {
        return this.b;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void setB(B b) {
        this.b = b;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public int compareTo(Pair o) {
        int cmp = this.a.compareTo((A) o.a);
        if (cmp != 0)
            return cmp;
        return this.b.compareTo((B) o.b);
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || !(o instanceof Pair))
            return false;
        Pair<A, B> p = (Pair<A, B>) o;
        return this.a.equals(p.a) && this.b.equals(p.b);
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }

    public String toString() {
        return "[" + a.toString() + ", " + b.toString() + "]";
    }

    private A a;
    private B b;
}
