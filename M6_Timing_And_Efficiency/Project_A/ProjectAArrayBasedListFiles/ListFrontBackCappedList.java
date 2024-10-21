import java.util.ArrayList;
import java.util.List;

public class ListFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private List<T> list;  
    private int capacity;  
    
    public ListFrontBackCappedList(int capacity) {
        list = new ArrayList<>(capacity);
        this.capacity = capacity;
    }
    
    @Override
    public boolean addBack(T element) {
        if (isFull()) {
            return false;
        }
        return list.add(element);  
    }
    
    @Override
    public boolean addFront(T element) {
        if (isFull()) {
            return false;
        }
        list.add(0, element);  
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
    public boolean contains(T element) {
        return list.contains(element);
    }
    
    @Override
    public int indexOf(T element) {
        return list.indexOf(element);
    }
    
    @Override
    public int lastIndexOf(T element) {
        return list.lastIndexOf(element);
    }
    
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    @Override
    public boolean isFull() {
        return list.size() >= capacity;
    }
    
    @Override
    public T getEntry(int position) {
        if (position < 0 || position >= list.size()) {
            return null;  // Invalid position
        }
        return list.get(position);
    }
    
    @Override
    public void clear() {
        list.clear();
    }
    
    @Override
    public String toString() {
        return "Size: " + list.size() + "\nCapacity: " + capacity + "\nElements: " + list.toString();
    }

}

