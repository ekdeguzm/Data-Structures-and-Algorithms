import java.util.ArrayList;
import java.util.Iterator;

public class Box<T> {
	
	private T thing;
	
	//private int thingCount; 
	// Once we add the history, we can get rid of the count variable and just use history.size() + 1.
	// In general, it's always best to avoid storing the same information in two different places- this
	// can be difficult to maintain and lead to errors. For this class, I created a private method to 
	// return the count in case we ever decide to change the design decision and put things in history 
	// when they are added to the box. If we made that change, we would then only have to change the 
	// private method, rather than changing the count throughout the class.
	
	private ArrayList<T> history;
	
	public Box(T firstThing) {
		this.thing = firstThing;
		
		// design decision: only putting things in the history when they are replaced
		history = new ArrayList<>(); 
	}
	
	public T getContents() {
		return thing;
	}
	private int thingCount() {
		return history.size()+1;
	}
	
	public void replaceContents(T newThing) {
		history.add(this.thing);
		this.thing = newThing;
	}
	public boolean contains(T someThing) {
		return this.thing.equals(someThing);
	}
	
	public boolean replaceIfDifferent(T newThing) {
		if(contains(newThing)) {
			return false;
		} else {
			replaceContents(newThing);
			return true;
		}
	}
	

	public boolean hasDuplicates() {
		if(history.contains(thing)) {
			return true;
		} else {
			for(int i=0; i<history.size(); i++) {
				T historicalThing = history.get(i);
				for(int j=i+1; j<history.size(); j++) {
					T comparisonThing = history.get(j);
					if(historicalThing.equals(comparisonThing)) {
						return true;
					}
				}
			}
			return false;
		}
	}
	
	public int totalFrequency(T item) {
		return historicalFrequency(item) + (item.equals(this.thing) ? 1 : 0 );
	}
	public int historicalFrequency(T item) {
		int count = 0;
		Iterator<T> iterator = history.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(item)) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public String toString() {
		return thing.toString() + " (item " + thingCount() + ")";
	}
	

	@Override
	public boolean equals(Object other) {
		if(other instanceof Box<?>) {
			Box<?> otherBox = (Box<?>) other;
			
			boolean sameThing = this.thing.equals(otherBox.thing);
			boolean sameCount = this.thingCount()==otherBox.thingCount();
			boolean sameHistory = this.history.equals(otherBox.history);
			
			return sameThing && sameCount && sameHistory;
			
		} else {
			return false;
		}
	}
	
}
