/*
  THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
  CODE WRITTEN BY OTHER STUDENTS. Han-Yu Chen
*/

public class CircularList {
	
	private ListElem tail;		// pointer to the last element in list
	private int size;		// size of the list
	
	public CircularList(){
		/*
		 * build an empty CircularList
		 */
		 
		tail = null;
		size = 0;
	}

	public boolean isEmpty(){
		while(size == 0){
			return true;
		}
		return false;
		
	}

	public int getSize(){
		return size;
	}

	public Integer remove(){
		if(size == 0) {
			return null;
		} else {
			size -= 1;
			ListElem head = tail.next;
			tail.next = tail.next.next;
			return head.value;
		}
	}

	public void insert(ListElem newElem) {
		if (size == 0) {
			tail = newElem;
			tail.next = tail;
		} else {
			newElem.next = tail.next; // second first is the previous tail.next
			tail.next = newElem; // newElem = newHead of the list
		}
		size += 1;
	}

	public void rotate() {
		ListElem oldTail = tail;
		ListElem newTail = tail.next;
		while(tail.next.next != newTail){
			tail = tail.next;
		}

		tail.next = oldTail;
		tail = tail.next.next;
	}

	public void printList() {
		ListElem oldTail = tail;
		while(tail.next != oldTail) {
			System.out.println(tail.next.value);
			tail = tail.next;
		}
	}

	public ListElem getTail() {
		return tail;
	}

  // Insert your methods here

}
