import java.util.*;

public class ListDeque<T> implements DequeInterface<T> {

	protected List<T> list; // note: this is List from the Java standard library java.util package

	// ANY OTHER VARIABLES AND CONSTRUCTORS GO HERE

	public ListDeque() {
		list = new ArrayList<T>();
	}

	@Override
	public void addToBack(T element) {
		list.add(element);
	}

	@Override
	public void addToFront(T element) {
		list.add(0, element);
	}

	@Override
	public T removeFront() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty, not able to remove from front.");
		}
		return list.remove(0);
	}

	@Override
	public T removeBack() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty, not able to remove from back.");
		}
		return list.remove(list.size() - 1);
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty, not able to get front.");
		}
		return list.get(0);
	}

	@Override
	public T getBack() {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty, canot able to get back.");
		}
		return list.get(list.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void clear() {
		list.clear();
	}

	/*
	 * these methods have either been implemented for you or you are not required to
	 * implement them for the homework
	 */
	public T dequeue() {
		return removeFront();
	}

	public void enqueue(T element) {
		addToBack(element);
	}

	public T getSecond() {
		return null;
	}

}
