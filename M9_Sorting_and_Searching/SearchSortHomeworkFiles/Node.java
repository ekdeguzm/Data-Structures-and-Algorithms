public class Node<T> {

	public T data;
	public Node<T> next;

	public Node(T dataPortion) {
		data = dataPortion;
		next = null;
	}

	public Node(T dataPortion, Node<T> nextNode) {
		data = dataPortion;
		next = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T newData) {
		data = newData;
	}

	public Node<T> getNextNode() {
		return next;
	}

	public void setNextNode(Node<T> nextNode) {
		next = nextNode;
	}
}



//Merge Sort
//Trace

//Initial Array: [37, 23, 28, 21, 12, 34, 15, 19]

//Step 1: Split down to 1-element arrays
//[37, 23, 28, 21]       [12, 34, 15, 19]
//[37, 23] [28, 21]      [12, 34] [15, 19]
//[37] [23] [28] [21]    [12] [34] [15] [19]

//Step 2: Merge arrays back together
//Merging [37] and [23]
//[23, 37]

//Merging [28] and [21]
//[21, 28]

//Result after first merges: 
//[23, 37]       [21, 28]

//Merging [23, 37] and [21, 28]
//[21, 23, 28, 37]

//Result after merging left side: 
//[21, 23, 28, 37]   [12, 34, 15, 19]

//Merging [12] and [34]
//[12, 34]

//Merging [15] and [19]
//[15, 19]

//Result after first merges: 
//[12, 34]       [15, 19]

//Merging [12, 34] and [15, 19]
//[12, 15, 19, 34]

//Final Merge: Merging [21, 23, 28, 37] and [12, 15, 19, 34]
//[12, 15, 19, 21, 23, 28, 34, 37]

//Final Sorted Array: [12, 15, 19, 21, 23, 28, 34, 37]





//Shell Sort

//Trace

//Initial Array: [30, 20, 24, 16, 10, 25, 12, 14]

//Gap Calculation: Start with gap=8/2=4, adjust to next odd number 5
//Gap=5

//Comparison and Swap:
//[30, 20, 24, 16, 10, 25, 12, 14]
//[10, 20, 24, 16, 30, 25, 12, 14] // 30 swap 10
//[10, 20, 24, 16, 30, 25, 12, 14] // No swap
//[10, 20, 12, 16, 30, 25, 24, 14] // 24 swap 12
//[10, 20, 12, 14, 30, 25, 24, 16] // 16 swap 14
//Result after gap 5: [10, 20, 12, 14, 30, 25, 24, 16]

//Gap=3
//Comparison and Swap:
//[10, 20, 12, 14, 30, 25, 24, 16]
//[10, 14, 12, 20, 30, 25, 24, 16] // 20 swap 14
//[10, 14, 12, 20, 30, 25, 24, 16] // No swap
//[10, 14, 12, 20, 30, 25, 24, 16] // No swap
//[10, 14, 12, 20, 24, 25, 30, 16] // 30 swap 24
//[10, 14, 12, 20, 24, 16, 30, 25] // 25 swap 16
//Result after gap 3: [10, 14, 12, 20, 24, 16, 30, 25]

//Gap=2
//Comparison and Swap:
//[10, 14, 12, 20, 24, 16, 30, 25]
//[10, 12, 14, 20, 24, 16, 30, 25] // 14 swap 12
//[10, 12, 14, 20, 16, 24, 30, 25] // 24 swap 16
//[10, 12, 14, 20, 16, 24, 25, 30] // 30 swap 25
//Result after gap 2: [10, 12, 14, 16, 20, 24, 25, 30]

//Gap=1
//Comparison and Swap:
//[10, 12, 14, 16, 20, 24, 25, 30] // No swaps needed as the array is already sorted

//Final Sorted Array: [10, 12, 14, 16, 20, 24, 25, 30]
