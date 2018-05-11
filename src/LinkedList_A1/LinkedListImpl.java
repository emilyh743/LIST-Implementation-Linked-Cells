package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the
					// head)
	int size;

	public LinkedListImpl() {// this constructor is needed for testing purposes.
								// Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part
								// of your data set!
		size = 0;
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to
							// grab your linkedList easily.
		return sentinel;
	}

	public boolean insert(double elt, int index) {
		Node current = new Node(elt);

		if (index > size() || index < 0) {
			return false;
		} // insert at the beginning

		else if (size() == 0) {
			sentinel.prev = current;
			sentinel.next = current;
			current.prev = sentinel;
			current.next = sentinel;

			size++;
			return true;
		} // insert at index 0

		// else if (index == 0) {
		// sentinel.getNext().prev = current;
		// current.next = sentinel;
		// current.prev = sentinel;
		// sentinel.next = current;
		//
		// size++;
		// return true;
		//
		// } // insert if size is same as index

		else if (size == index) {
			sentinel.prev.next = current;
			current.prev = sentinel.prev;
			current.next = sentinel;
			sentinel.prev = current;

			size++;
			return true;

		} // insert node

		else {
			Node temp = sentinel.next;
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					current.next = temp;
					current.prev = temp.prev;
					current.prev.next = current;
					current.next.prev = current;

					size++;
					return true;
				}
				temp = temp.getNext();
			}
		}
		return false;
	}

	public boolean remove(int index) {
		// check if no list. can't remove if no list exists...
		if (size() == 0) {
			return false;
		}
		// check if valid input
		else if (index > size() || index < 0) {
			return false;
		} else {

			// remove element in list
			Node temp = sentinel.getNext();
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;

					size--;
					return true;
				}
				temp = temp.getNext();
			}
			return false;
		}
	}

	public double get(int index) {
		if (size() == 0) {
			return Double.NaN;
		} else if (index > size() || index < 0) {
			return Double.NaN;
		} else {
			Node temp = sentinel.next;

			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp.getData();
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	public void clear() {
		size = 0;
		sentinel.prev = null;
		sentinel.next = null;

	}

}