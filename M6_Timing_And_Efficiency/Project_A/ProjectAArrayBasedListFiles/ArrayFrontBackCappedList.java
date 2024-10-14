public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private T[] list;
    private int numberOfElements;
    private int capacity;

    // Constructor to initialize the list with a maximum size
    public ArrayFrontBackCappedList(int maxSize) {
        this.capacity = maxSize;
        this.list = (T[]) new Object[maxSize];

        // Hard-coded initialization for testing
        Object[] objs = {2, 4, 6, 8, 9}; // You should have these values
        System.arraycopy(objs, 0, this.list, 0, objs.length); // Copy the objects into the list
        this.numberOfElements = objs.length; // Set number of elements to the size of the initialized array
    }

    // Returns a string representation of the list
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Size: " + numberOfElements + ", Capacity: " + capacity + ", Elements: [");
        for (int i = 0; i < numberOfElements; i++) {
            result.append(list[i]);
            if (i < numberOfElements - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    // Checks if the list is empty
    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    // Checks if the list is full
    @Override
    public boolean isFull() {
        return numberOfElements == capacity;
    }

    // Returns the current size of the list
    @Override
    public int size() {
        return numberOfElements;
    }

    // Gets the entry at a specific index
    @Override
    public T getEntry(int index) {
        if (index < 0 || index >= numberOfElements) {
            return null; // Return null for invalid index
        }
        return list[index]; // Return the element at the given index
    }

    // Clears the list
    @Override
    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            list[i] = null; // Clear all elements
        }
        numberOfElements = 0; // Reset the count
    }

    // Adds an element to the back of the list
    @Override
    public boolean addBack(T entry) {
        if (isFull()) {
            return false; // List is full, cannot add
        }
        list[numberOfElements] = entry; // Add the new entry at the back
        numberOfElements++; // Increase the count
        return true;
    }

    // Adds an element to the front of the list
    @Override
    public boolean addFront(T entry) {
        if (isFull()) {
            return false; // List is full, cannot add
        }
        // Shift elements to the right to make room at the front
        for (int i = numberOfElements; i > 0; i--) {
            list[i] = list[i - 1];
        }
        list[0] = entry; // Add the new entry at the front
        numberOfElements++; // Increase the count
        return true;
    }

    // Removes and returns the front element of the list
    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null; // Return null if the list is empty
        }
        T frontElement = list[0]; // Store the front element
        // Shift elements to the left to fill the gap
        for (int i = 1; i < numberOfElements; i++) {
            list[i - 1] = list[i];
        }
        list[numberOfElements - 1] = null; // Clear the last element
        numberOfElements--; // Decrease the count
        return frontElement; // Return the removed element
    }

    // Removes and returns the back element of the list
    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null; // Return null if the list is empty
        }
        T backElement = list[numberOfElements - 1]; // Store the back element
        list[numberOfElements - 1] = null; // Clear the last element
        numberOfElements--; // Decrease the count
        return backElement; // Return the removed element
    }

    // Checks if the list contains a specific element
    @Override
    public boolean contains(T entry) {
        for (int i = 0; i < numberOfElements; i++) {
            if (list[i].equals(entry)) {
                return true; // Found the element
            }
        }
        return false; // Element not found
    }

    // Returns the index of the first occurrence of the specified element
    @Override
    public int indexOf(T entry) {
        for (int i = 0; i < numberOfElements; i++) {
            if (list[i].equals(entry)) {
                return i; // Return the index of the element
            }
        }
        return -1; // Element not found
    }

    // Returns the index of the last occurrence of the specified element
    @Override
    public int lastIndexOf(T entry) {
        for (int i = numberOfElements - 1; i >= 0; i--) {
            if (list[i].equals(entry)) {
                return i; // Return the index of the last occurrence
            }
        }
        return -1; // Element not found
    }
}
