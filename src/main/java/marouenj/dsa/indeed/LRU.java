package marouenj.dsa.indeed;

import java.util.LinkedList;

public class LRU<E> extends LinkedList<E> {

    private static final long serialVersionUID = 1L;

    private int max_size;

    public LRU(int max_size) {
        super();
        this.max_size = max_size;
    }

    @Override
    public boolean offerFirst(E e) {
        if (super.contains(e))
            super.remove(e);
        if (super.size() == max_size)
            super.pollLast();
        super.offerFirst(e);
        return true;
    }

    public static void main(String[] args) {
        LRU<String> lru = new LRU<String>(3);
        lru.offerFirst("Marouen");
        System.out.println(lru.toString());
        lru.offerFirst("Marouen");
        System.out.println(lru.toString());
        lru.offerFirst("Jilani");
        System.out.println(lru.toString());
        lru.offerFirst("Shayma");
        System.out.println(lru.toString());
        lru.offerFirst("Jilani");
        System.out.println(lru.toString());
        lru.offerFirst("Yasmine");
        System.out.println(lru.toString());
        lru.offerFirst("Shayma");
        System.out.println(lru.toString());
    }
}
