package objectclass;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private final List<Object> items;
    private int cursor;

    public SimpleBag() {
        this.items = new ArrayList<>();
        beforeFirst();
    }

    public void putItem(Object item) {
        items.add(item);
        cursor++;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    public void beforeFirst() {
        cursor = -1;
    }

    public boolean hasNext() {
        return items.size() < cursor;
    }

    public Object next() {
        return items.get(cursor + 1);
    }

    public boolean contains(Object item) {
        return items.contains(item);
    }

    public int getCursor() {
        return cursor;
    }
}
