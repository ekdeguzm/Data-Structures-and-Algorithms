import java.util.*;
/*
 * An expandable, array-based implementation of a multiset.
 */
public class ExpandableArrayMultiset<T> extends ArrayMultiset<T> implements Multiset<T> {
	
	
	public ExpandableArrayMultiset(int capacity) {
		super(capacity);
		if(capacity<=0) {
			throw new IllegalArgumentException("Invalid Capacity of " + capacity);
		}
	}
	
	public ExpandableArrayMultiset() {
		super();
	}
	
	@Override
	public boolean add(T element) {
		if (isArrayFull()) {
			expandArray();
		}
		return super.add(element);
	}


	public boolean isFull() {
		return false;
	}


	public void trimToSize() {
		// YOUR CODE HERE
	}
	
	private boolean isArrayFull() {
		return size()==setArray.length;
	}
	
	private void expandArray() {		
		setArray = Arrays.copyOf(setArray, setArray.length * 2);
		
	}
	

}
