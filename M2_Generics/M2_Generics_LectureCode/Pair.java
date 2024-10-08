
public class Pair<T> {

	private T item1, item2;

	public Pair(T item1, T item2) {
		this.item1 = item1;
		this.item2 = item2;
	}

	public T getItem1() {
		return item1;
	}

	public T getItem2() {
		return item2;
	}

	public void setItem1(T item1) {
		this.item1 = item1;
	}

	public void setItem2(T item2) {
		this.item2 = item2;
	}

	@Override
	public String toString() {
		return item1.toString() + "\t" + item2.toString();
	}

	public boolean sameItems() {
		return item1.equals(item2);
		// return item1==item2; INCORRECT! tests for aliases, not logical equivalence
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; // Returns true if the objects are the same
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false; // Check if obj is null or if it's not an instance of Pair
		}
		Pair<?> other = (Pair<?>) obj; // We are makin g a cast here

		// Check if the items are equal ignoring order
		return (this.item1.equals(other.item1) && this.item2.equals(other.item2))
				|| this.item1.equals(other.item2) && this.item2.equals(other.item1);
	}

}
