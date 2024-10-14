import java.util.*;

public class HomeworkM6Driver {
	
    public static ArrayList<Integer> findDuplicatesLinear(ArrayList<Integer> numbers) {
        LinkedList<Integer> observed = new LinkedList<>();
        LinkedList<Integer> duplicates = new LinkedList<>();

        for (int number : numbers) {
            if (observed.contains(number)) {
                duplicates.add(number);
            } else {
                observed.add(number);
            }
        }
        return new ArrayList<>(duplicates);
    }

    
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		int numberOfTimesToTest = 5; // consider starting with 1 test until you are certain it is working correctly
		boolean passedAllTests = true;
		
		for(int i=0; i<numberOfTimesToTest && passedAllTests; i++) {
			System.out.println("\n-----------------------------TESTING findDuplicatesLinear METHOD TEST #" + (i+1) + "-----------------------------");
		
			/* consider making these values smaller until you have a working method.
			 * it might be easier to debug with a smaller list.
			 * you can then increase the numbers again for more robust testing.
			 */
			int listSize = 100; 
			int minimumSingleSuplicates = 10; // minimum number of numbers on the list that will appear twice (have a "single duplicate")
			int minimumDoubleDuplicates = 5;  // minimum number of numbers on the list that will appear three times (have a "double duplicate")
			fillNumberList(numbers, listSize, minimumSingleSuplicates, minimumDoubleDuplicates);
			
			// print the list sorted (might help with testing)
			Collections.sort(numbers);
			System.out.println("\nThe original list (sorted for display purposes only):");
			System.out.println(numbers);
	
			// reshuffle the list
			Collections.shuffle(numbers);
	
			// the results should be the same for both methods
			System.out.println("\nThe duplicate lists from both methods- these should match! (Note: methods are sorted for display purposes only.)");
			List<Integer> duplicateListFromBad = findDuplicatesBad(new ArrayList<Integer>(numbers));
			Collections.sort(duplicateListFromBad);
			System.out.println("Duplicate list from bad method:  \t" + duplicateListFromBad);
	
			List<Integer> duplicateListFromLinear = findDuplicatesLinear(new ArrayList<Integer>(numbers));
			Collections.sort(duplicateListFromLinear);
			System.out.println("Duplicate list from linear method:\t" + duplicateListFromLinear);
	
			boolean match = duplicateListFromBad.equals(duplicateListFromLinear);
			if(!match) {
				passedAllTests = false;
				System.out.flush();
				System.err.println("\n*****TEST FAILED: The duplicate lists do not match.");
			} else {
				System.out.println("\nTest #" + (i+1) + ": The duplicate lists match. Test passed!");
			}
		}
		if (passedAllTests) {
			System.out.println("\n-----------------------------TESTING findDuplicatesLinear METHOD FOR EFFICIENCY -----------------------------");
			System.out.println("\nAll tests of functionality passed. Now trying to examine efficiency... ");
			System.out.println("Note: If this takes more than a minute, you might not have a linear solution. If that happens, you should force the program to quit and double check all method calls and loops!");
			efficiencyTest();
			System.out.println("Efficiency test complete.");
		} 
	}
	
	public static ArrayList<Integer> findDuplicatesBad(ArrayList<Integer> numberList) {
		ArrayList<Integer> duplicateList = new ArrayList<Integer>();
		
		// loop a: this loop is O(n)- it iterates over the whole list
		for(int i=0; i<numberList.size(); i++) {
			int numberEvaluating = numberList.get(i);
			boolean duplicateFound = false;
			
			// loop b: this loop starts at i+1 and goes to the end of the list OR until a duplicate is found
			for(int j=i+1; j<numberList.size() && !duplicateFound; j++) {
				int numberChecking = numberList.get(j);
				
				// we have found a duplicate that hasn't yet been put on the duplicateList
				if(numberEvaluating==numberChecking && !duplicateList.contains(numberEvaluating)) {
					duplicateFound = true; 
					
					// loop c: after a duplicate is found, we won't return to loop b
					// instead, loop c finishes checking the rest of the list and puts all copies of 
					// of the current duplicate on the duplicateList
					for(int k=j; k<numberList.size(); k++) {
						if(numberChecking==Integer.valueOf(numberList.get(k))) {
							duplicateList.add(numberChecking);
						}
					}
				}
			}
		}
		return duplicateList;
	}
	

	/*----------------------------------------------------------------------------------------------------------*/
	/* TESTER METHODS */
	/*----------------------------------------------------------------------------------------------------------*/
	/*
	 * The methods below are designed to help support the tests cases run from main. You don't
	 * need to use, modify, or understand these methods. You can safely ignore them. :) 
	 * 
	 * Also, you can ignore the use of generics in the tester methods. These methods use
	 * generics at a level beyond which we use in our class. I only use them here to make this a robust 
	 * and useful testing file. You are NOT required to understand the use of generics in this way.
	 */

	public static void fillNumberList(List<Integer> numbers, int listSize, int minimumSingleDuplicates, int minimumDoubleDuplicates) {
		Random generator = new Random();
		int max = 5 * listSize;
		int min = -1 * max;
		int randomRange = max - min + 1;

		// add the first round of numbers
		int numberOfNumbersToAdd = listSize - minimumSingleDuplicates - minimumDoubleDuplicates;
		numbers.add(min); // adding the min and max number to help test for array out of bounds errors
		numbers.add(min);
		numbers.add(max);
		numbers.add(max);
		numbers.add(0);
		numbers.add(0); // adding zero as a special test case
		numberOfNumbersToAdd -= 6;
		for (int i = 0; i < numberOfNumbersToAdd; i++) {
			numbers.add(generator.nextInt(randomRange) + min);
		}

		// add duplicate numbers
		Collections.shuffle(numbers);
		for (int i = 0; i < minimumSingleDuplicates; i++) {
			numbers.add(numbers.get(i));
		}
		for (int i = 0; i < minimumDoubleDuplicates; i++) {
			numbers.add(numbers.get(i));
		}	
		Collections.shuffle(numbers);

	}

	public static void efficiencyTest() {
		System.out.println("Testing...");
		List<Integer> numbers = new ArrayList<Integer>();
		int listSize = 6000000;
		int minimumSingleSuplicates = 1000; 
		int minimumDoubleDuplicates = 500;  
		fillNumberList(numbers, listSize, minimumSingleSuplicates, minimumDoubleDuplicates);
	
		long startTime = System.currentTimeMillis();
		List<Integer> duplicateListFromLinear = findDuplicatesLinear(new ArrayList<Integer>(numbers));
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		//System.out.println("Elapsed time = " + (elapsedTime));
		
		int estimatedLinearTime = 5000;
		if (elapsedTime>estimatedLinearTime) {
			System.out.flush();
			System.err.println("**********WARNING! Your solution might not be linear. Double check all method calls and loops!");
			System.err.println("Linear solutions are estimated to run in " + estimatedLinearTime + " miliseconds. Your solution ran in " + elapsedTime + ".");
		} else {
			System.out.println("Your solution appears to be linear. This test cannot know for sure, but it does appear to be!");
			System.out.println("Linear solutions are estimated to run in " + estimatedLinearTime + " miliseconds. Your solution ran in " + elapsedTime + ". If your value is close to the estimate, you might consider running the test a few more times.");
		}

	}


}
