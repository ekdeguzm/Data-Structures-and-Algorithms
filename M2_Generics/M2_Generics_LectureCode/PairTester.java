
public class PairTester {

	public static void main(String[] args) {
		Pair<Integer> numberPair = new Pair<>(3, 4);
		Pair<String> wordPair = new Pair<>("hello", "goodbye");

		System.out.println(numberPair);
		System.out.println(wordPair);

		// testing our sameItems method
		String s1 = new String("apple");
		String s2 = new String("apple");
		Pair<String> wordPair2 = new Pair<String>(s1, s2);
		System.out.println("wordPair2 contains the same items? " + wordPair2.sameItems());

		// testing the equals method
		Pair<Integer> numberPair2 = new Pair<>(4, 3);
		System.out.println("numberPair equals numberPair2? " + numberPair.equals(numberPair2));

		PairDifferent<Integer, String> numberWordPair = new PairDifferent<Integer, String>(2, "hello");
		PairDifferent<Integer, Integer> doubleNumberPair = new PairDifferent<Integer, Integer>(1, 1);

		System.out.println(numberWordPair);
		System.out.println(doubleNumberPair);
	}

}
