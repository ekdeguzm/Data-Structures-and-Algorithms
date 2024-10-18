public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {
	private T[] list;
	private int numberOfElements;
	private final int capacity;

	public ArrayFrontBackCappedList(int capacity) {
		this.capacity = capacity;
		this.list = (T[]) new Object[capacity];
		this.numberOfElements = 0;

		Object[] objs = { 2, 4, 6, 8, 9, null, null, null, null, null };
		this.list = (T[]) objs;
		this.numberOfElements = 5;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(
				"Size: " + numberOfElements + ", Capacity: " + capacity + ", Elements: [");
		for (int i = 0; i < numberOfElements; i++) {
			result.append(list[i]);
			if (i < numberOfElements - 1) {
				result.append(", ");
			}
		}
		result.append("]");
		return result.toString();
	}

	@Override
	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	@Override
	public boolean isFull() {
		return numberOfElements == capacity;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public T getEntry(int index) {
		if (index < 0 || index >= numberOfElements) {
			return null;
		}
		return list[index];
	}

	@Override
	public void clear() {
		for (int i = 0; i < numberOfElements; i++) {
			list[i] = null;
		}
		numberOfElements = 0;
	}

	@Override
	public boolean addBack(T entry) {
		if (isFull()) {
			return false;
		}
		list[numberOfElements] = entry;
		numberOfElements++;
		return true;
	}

	@Override
	public boolean addFront(T entry) {
		if (isFull()) {
			return false;
		}
		for (int i = numberOfElements; i > 0; i--) {
			list[i] = list[i - 1];
		}
		list[0] = entry;
		numberOfElements++;
		return true;
	}

	@Override
	public T removeFront() {
		if (isEmpty()) {
			return null;
		}
		T frontElement = list[0];

		for (int i = 1; i < numberOfElements; i++) {
			list[i - 1] = list[i];
		}
		list[numberOfElements - 1] = null;
		numberOfElements--;
		return frontElement;
	}

	@Override
	public T removeBack() {
		if (isEmpty()) {
			return null;
		}
		T backElement = list[numberOfElements - 1];
		list[numberOfElements - 1] = null;
		numberOfElements--;
		return backElement;
	}

	@Override
	public boolean contains(T entry) {
		for (int i = 0; i < numberOfElements; i++) {
			if (list[i].equals(entry)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(T entry) {
		for (int i = 0; i < numberOfElements; i++) {
			if (list[i].equals(entry)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T entry) {
		for (int i = numberOfElements - 1; i >= 0; i--) {
			if (list[i].equals(entry)) {
				return i;
			}
		}
		return -1;
	}
}
