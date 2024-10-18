import java.util.ArrayList;
import java.util.List;

public class ListFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private List<T> list; 
    private int capacity;  

    public ListFrontBackCappedList(int maxSize) {
        this.capacity = maxSize;
        this.list = new ArrayList<>(maxSize);
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public boolean isFull() {
        return list.size() >= capacity;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T getEntry(int index) {
        if (index < 0 || index >= list.size()) {
            return null; 
        }
        return list.get(index);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean addBack(T entry) {
        if (isFull()) {
            return false;
        }
        list.add(entry);
        return true;
    }

    @Override
    public boolean addFront(T entry) {
        if (isFull()) {
            return false; 
        }
        list.add(0, entry); 
        return true;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }
        return list.remove(0); 
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null; 
        }
        return list.remove(list.size() - 1); 
    }

    @Override
    public boolean contains(T entry) {
        return list.contains(entry);
    }

    @Override
    public int indexOf(T entry) {
        return list.indexOf(entry);
    }

    @Override
    public int lastIndexOf(T entry) {
        return list.lastIndexOf(entry);
    }
}
