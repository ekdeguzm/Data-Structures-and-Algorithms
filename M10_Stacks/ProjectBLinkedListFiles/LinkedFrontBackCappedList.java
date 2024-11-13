public class LinkedFrontBackCappedList<T extends Comparable<? super T>> 
        implements FrontBackCappedList<T>, Comparable<LinkedFrontBackCappedList<T>> {


	private Node head, tail;
	private int size;
	private final int capacity;

    public LinkedFrontBackCappedList(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Size: ").append(size).append(", Capacity: ").append(capacity).append("\n");
        if (size > 0) {
            sb.append("Head: ").append(head.data).append(", Tail: ").append(tail.data).append("\n");
            Node current = head;
            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }
        } else {
            sb.append("List is empty.");
        }
        return sb.toString();
    }
	
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
	
    @Override
    public boolean isFull() {
        return size == capacity;
    }
	
    @Override
    public int size() {
        return size;
    }
	
    @Override
    public T getEntry(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
	
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    @Override
    public boolean addFront(T element) {
        if (isFull()) {
            return false; 
        }
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }
    
    @Override
    public boolean addBack(T element) {
        if (isFull()) {
            return false; 
        }
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null; 
        }
        T removedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null; 
        }
        size--;
        return removedData;
    }

    @Override
    public T removeBack() {
        if (isEmpty()) {
            return null; 
        }
        T removedData = tail.data;
        if (head == tail) {
            head = tail = null; 
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        size--;
        return removedData;
    }

    @Override
    public boolean contains(T element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T element) {
        Node current = head;
        int index = -1;
        int currentIndex = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                index = currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return index;
    }

	@Override
	public int compareTo(LinkedFrontBackCappedList<T> other) {
	    Node current = this.head;
	    Node otherCurrent = other.head;
	    
	    while (current != null && otherCurrent != null) {
	        int result = current.data.compareTo(otherCurrent.data);
	        if (result != 0) {
	            return result;  
	        }
	        current = current.next;
	        otherCurrent = otherCurrent.next;
	    }
	    
	    if (current == null && otherCurrent == null) {
	        return 0;  
	    }
	    
	    if (current == null) {
	        return -1;  
	    } else {
	        return 1; 
	    }
	}
	
	public class Node {
		public T data;
		public Node next;

		private Node(T dataValue) {
			data = dataValue;
			next = null;
		}

		private Node(T dataValue, Node nextNode) {
			data = dataValue;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
}
