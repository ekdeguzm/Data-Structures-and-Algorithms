import java.util.*;

public class PrimeNumberGenerator {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=2; i<10000; i++) {
			numbers.add(i);
		}		
		for(int i=0; i<numbers.size(); i++) {
			int prime = numbers.get(i);
			//System.out.println("prime is " + prime);
			Iterator<Integer> iterator = numbers.iterator();
			for(int j=0; j<=i && iterator.hasNext(); j++) { // solution 2: skip over all previous primes and the current prime
				iterator.next();
			}
			
			while(iterator.hasNext()) {
				int numToCompare = iterator.next();
				// if(numToCompare>prime && numToCompare%prime==0) { solution 1: change the conditional
				if(numToCompare%prime==0) {
					//System.out.println("removing " + numToCompare);
					iterator.remove();
				}
			}
		}
		System.out.println(numbers);
		
		

	}
	
	

}
