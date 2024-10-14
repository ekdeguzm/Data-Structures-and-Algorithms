
public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private T[] list; // Array to store the elements
    private int numberOfElements; // Number of elements currently in the list
    private final int capacity; // Maximum size of the list

    // Constructor that initializes the list with a specified capacity
    public ArrayFrontBackCappedList(int capacity) {
        this.capacity = capacity;
        this.list = (T[]) new Object[capacity]; // Create the array with the given capacity
        this.numberOfElements = 0; // Initially, there are no elements
    }

    // Returns a string representation of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(numberOfElements)
          .append("; capacity=").append(capacity)
          .append("; [");
        for (int i = 0; i < numberOfElements; i++) {
            sb.append(list[i]);
            if (i < numberOfElements - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
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

    // Retrieves the entry at a specific index
    @Override
    public T getEntry(int index) {
        if (index < 0 || index >= numberOfElements) {
            return null; // Return null for invalid index
        }
        return list[index]; // Return the element at the specified index
    }

    // Clears the list
    @Override
    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            list[i] = null; // Remove references to the objects
        }
        numberOfElements = 0; // Reset the size
    }

	@Override
	public boolean addFront(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBack(T newEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(T anEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

    // Additional methods (like adding/removing elements) would go here.
}
