
public class PracticeTester {

	public static void main(String[] args) {

	Pair<Integer> numberPair1 = new Pair<Integer>(3,4);
	Pair<Integer> numberPair2 = new Pair<Integer>(4,3);
	Pair<Integer> numberPair3 = new Pair<Integer>(4,4);
	System.out.println(numberPair1.equals(numberPair2)); // true
	System.out.println(numberPair2.equals(numberPair3)); // false
	
	Pair<String> wordPair1 = new Pair<String>("cat", "dog");
	Pair<String> wordPair2 = new Pair<String>("dog", "cat");
	System.out.println(wordPair1.equals(wordPair2)); // true
	
	Quad<Integer,String> quad1 = new Quad<Integer,String>(numberPair1,wordPair1);
	Quad<Integer,String> quad2 = new Quad<Integer,String>(numberPair2,wordPair2);
	System.out.println(quad1.equals(quad2)); // true
	
	}

}
