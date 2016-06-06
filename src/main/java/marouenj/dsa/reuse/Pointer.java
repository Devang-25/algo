package marouenj.dsa.reuse;

public class Pointer<A> {

    private A pointee;

    public Pointer(A p) {
        pointee = p;
    }

	/*
     * get/set
	 */

    public A getPointee() {
        return pointee;
    }

    public void setPointee(A p) {
        pointee = p;
    }

	/*
	 * alias
	 */

    public A deref() {
        return getPointee();
    }
}
