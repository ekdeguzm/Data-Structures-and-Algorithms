/*
 * Write a generic class that represents a Quad, defined as a pair of Pair objects.
The Pair objects could hold different types 
(for example, a Quad could be made up of a Pair of Integers and a Pair of Strings). 
 * Post the class header, instance data variables, and constructor.
 */


public class Quad<T, S> {
	
	private Pair<T> pair1;
	private Pair<S> pair2;
	
	public Quad(Pair<T> pair1, Pair<S> pair2) {
		this.pair1 = pair1;
		this.pair2 = pair2;
	}

	public Pair<T> getPair1() {
		return pair1;
	}

	public void setPair1(Pair<T> pair1) {
		this.pair1 = pair1;
	}

	public Pair<S> getPair2() {
		return pair2;
	}

	public void setPair2(Pair<S> pair2) {
		this.pair2 = pair2;
	}
	
	/*
	 * Write an equals method for the Quad class described above. 
	 * Two Quad objects are equal if the two Pair objects in the current 
	 * Quad are equal to the two Pair objects in the other Quad, ignoring order.
	 */
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Quad<?,?>) {
			Quad<?,?> otherQuad = (Quad<?,?>) other;
			
			boolean sameOrder = pair1.equals(otherQuad.pair1) && pair2.equals(otherQuad.pair2);
			boolean oppositeOrder = pair1.equals(otherQuad.pair2) && pair2.equals(otherQuad.pair1);
			
			return sameOrder || oppositeOrder;
		} else {
			return false;
		}
	}
	

}
