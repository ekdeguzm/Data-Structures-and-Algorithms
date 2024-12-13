
public class VoterHashTableSeparateChaining {

	public Node<Voter>[] hashTable; // made public for testing purposes only!
	public int tableSize; // made public for testing purposes only!

	public VoterHashTableSeparateChaining(int size) {
		hashTable = (Node<Voter>[]) new Node[size];
		tableSize = size;
	}

	public int calculateArrayLocation(int voterID) {
		return Math.abs(voterID) % tableSize;
	}

	public boolean addVoter(Voter voterToAdd) {
		int location = calculateArrayLocation(voterToAdd.getId());
		Node<Voter> current = hashTable[location];

		// completing extra credit.
		while (current != null) {
			if (current.data.equals(voterToAdd)) {
				return false;
			}
			current = current.next;
		}

		Node<Voter> newNode = new Node<>(voterToAdd);
		newNode.next = hashTable[location];
		hashTable[location] = newNode;
		return true;
	}

	public Voter getVoter(int voterID) {
		int location = calculateArrayLocation(voterID);
		Node<Voter> current = hashTable[location];

		while (current != null) {
			if (current.data.getId() == voterID) {
				return current.data;
			}
			current = current.next;
		}

		return null;
	}

	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			if (hashTable[i] != null) {
				System.out.print("Location " + i + ": ");
				Node<Voter> current = hashTable[i];
				while (current != null && current.next != null) {
					System.out.print(current.data.getName() + " -> ");
					current = current.next;
				}
				System.out.println(current.data.getName());
			}
		}
	}

}
