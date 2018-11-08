/*
 * Long Chu
 * ID:013444780
 * Project 1
 * Due Date: September 24, 2018
 */

package InsertionSortByLink;

class Node {
	protected String data;
	protected Node link;

	// default Constructor
	public Node() {
		link = null;
		data = "";
	}

	// parametrized Constructor
	public Node(String d, Node n) {
		data = d;
		link = n;
	}

	// Function to set link to next Node
	public void setLink(Node n) {
		link = n;
	}

	// Function to set data to current Node
	public void setData(int d) {
		data = "";
	}

	// Function to get link to next node
	public Node getLink() {
		return link;
	}

	// Function to get data from current Node
	public String getData() {
		return data;
	}
}

class linkedList {
	protected Node start;
	protected Node end;
	public int size;

	// Constructor
	public linkedList() {
		start = null;
		end = null;
		size = 0;
	}

	// This allow nodes to be add at the end
	public void insertAtEnd(String val) {
		Node nptr = new Node(val, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
	}

	// this will perform the insertion sort
	public linkedList insertionsort(Node first) {

		Node current = first; // Current will be the first node in the linked list which is the first word
		Node last = null;
		
		while (current != null && last != first) // this will end once current has travel the list
		{
			Node next = current;
			while (next.link != last) {
				if (next.data.compareTo(next.link.data) > 0) // this will compare the the two string and check which
															 // should go first
				{
					String temp = next.data;
					next.data = next.link.data; // swap the data rather than nodes
					next.link.data = temp;
				}
				next = next.link; // move on to the check if the key is lower or great than the next value
			}

			last = next;
			current = first;// this will reset current so the while loop can perform the next iteration
		}
		return this;
		
	}

	// This will display the entire linked list
	public void display() {
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.print(start.getData() + ", ");
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + ", ");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData() + "\n");
	}
}

public class InsertionSortByLinks {

	public static void main(String[] args) {

		// Put 1-20 words in an array (everything in lower cap)
		String[] words = { "egg", "cheese", "axe", "anime", "ape", "bacon", "book", "car", "game", "computer", "beauty",
						   "science", "zombie", "human", "apple", "smile", "girls", "boys", "pallets", "people" };

		linkedList sort = new linkedList();

		int arrayLength = words.length;

		// insert everything in the array into a linked list
		for (int i = 0; i < arrayLength; i++) {
			sort.insertAtEnd(words[i]);
		}
		
		System.out.print("Input: ");
		sort.display();

		// this will sort the list by insertionsort
		sort.insertionsort(sort.start);

		System.out.print("\nOutput: ");

		sort.display();
	}
}
