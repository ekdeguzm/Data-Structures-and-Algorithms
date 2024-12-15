import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T> {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
	}

	@Override
	public boolean add(T newEntry) {
		if (isEmpty()) {
			return super.add(newEntry);
		} else {
			return addEntryHelperNonRecursive(newEntry);
		}
	}

	// IMPLEMENT THIS METHOD; THIS METHOD CANNOT BE RECURSIVE
	private boolean addEntryHelperNonRecursive(T newEntry) {
		BinaryNode<T> currentNode = root;
		while (true) {
			int comparison = newEntry.compareTo(currentNode.getData());
			if (comparison <= 0) {
				if(currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				} else {
					currentNode.setLeftChild(new BinaryNode<>(newEntry));
					return true;
				}
			} else {
				if (currentNode.hasRightChild()) {
					currentNode = currentNode.getRightChild();
				} else {
					currentNode.setRightChild(new BinaryNode<>(newEntry));
					return true;
				}
			}
		}
	}

	// THIS METHOD CANNOT BE RECURSIVE.
	// Make sure to take advantage of the sorted nature of the BST!
	public int countIterative(T target) {		
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNode<T> currentNode = root;
		while (currentNode != null) {
			int comparison = target.compareTo(currentNode.getData());
			if (comparison == 0) {
				count++;
				currentNode = currentNode.getLeftChild();
			} else if (comparison < 0) {
				currentNode = currentNode.getLeftChild();
			} else {
				currentNode = currentNode.getRightChild();
			}
		}
		// consider a loop!		
		return count;
	}

	// THIS METHOD MUST BE RECURSIVE! 
	// You are allowed to create a private helper.
	// Make sure to take advantage of the sorted nature of the BST!
	public int countGreaterRecursive(T target) {
		return countGreaterRecursiveHelper(root, target);
	}	
	public int countGreaterRecursiveHelper(BinaryNode<T> node, T target) {
		if (node == null) {
			return 0;
		}
		int comparison = target.compareTo(node.getData());
		if (comparison < 0) {
			return 1 + countGreaterRecursiveHelper(node.getLeftChild(), target) + countGreaterRecursiveHelper(node.getRightChild(), target);
		} else {
			return countGreaterRecursiveHelper(node.getRightChild(), target);
		}
	}
	

	// THIS METHOD CANNOT BE RECURSIVE.
	// Hint: use a stack!
	// Make sure to take advantage of the sorted nature of the BST!
	public int countGreaterIterative(T target) {
		int count = 0; 
		Stack<BinaryNode<T>> nodeStack = new Stack<>();
		BinaryNode<T> currentNode = root;
		
		while (currentNode != null || !nodeStack.isEmpty()) {
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getRightChild();
			}
			
			currentNode = nodeStack.pop();
			if (target.compareTo(currentNode.getData()) < 0 ) {
				count++;
			}
			currentNode = currentNode.getLeftChild();
		}
		// consider a loop based on the stack!		
		return count;
	}
			
	
	// For full credit, the method should be O(n).
	// You are allowed to use a helper method.
	// The method can be iterative or recursive.
	// If you make the method recursive, you might need to comment out the call to the method in Part B.
	public int countUniqueValues() {
		Set<T> uniqueValues = new HashSet<>();
		Stack<BinaryNode<T>> nodeStack = new Stack<>();
		BinaryNode<T> currentNode = root;
		
		while(currentNode != null || !nodeStack.isEmpty()) {
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			currentNode = nodeStack.pop();
			uniqueValues.add(currentNode.getData());
			currentNode = currentNode.getRightChild();
		}
		
		return uniqueValues.size(); 
	}

}