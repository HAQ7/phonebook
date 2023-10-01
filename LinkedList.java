
public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T val) {
		current.data = val;
	}

	public void insert(T val) { // Adding method
		Node<T> temp;
		if (empty()) {
			current = head = new Node<T>(val);
		} else {
			temp = current.next;
			current.next = new Node<T>(val);
			current = current.next;
			current.next = temp;
		}
	}

	public void remove() {// Deleting method
		if (current == head) {
			head = head.next;
		} else {
			Node<T> temp = head;
			while (temp.next != current) {
				temp = temp.next;
			}
			temp.next = current.next;
		}
		if (current.next == null) {
			current = head;
		} else {
			current = current.next;
		}
	}

	public boolean full() {
		return false;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean isUnique(String name ,String phoneNumber) {//check if there an existing contact that holds name and phone number
		if(empty())return true;
		Node<T> temp =head;
		while(temp!=null) {
			if(((Contact)temp.data).getName().equals(name) || ((Contact)temp.data).getPhoneNumber().equals(phoneNumber))
				return false;
			temp=temp.next;
		}
		return true;
	}
	public void searchConatctToPrint( String val ) { //print all contacts that have an attribute matches "val"
		Node<T> temp = head;
		while (temp != null) {
			if (((Contact) (temp.data)).equalsContact(val))
				((Contact) (temp.data)).printContact();
			temp = temp.next;
		}
		
	}
	public void insertSortedC(String name , T val) {//insert a sorted contact list
		if(empty())
			current = head = new Node<T>(val);
		Node<T> temp;
		if(((Contact)head.data).getName().compareTo(name) > 0){//if it dosen't work change ">" to ">="
			
			temp=new Node<T>(val);
			temp.next=head;
			head=temp;
			return;
			}
		findFirst();
		while(!last()) {
			if(((Contact)current.next.data).getName().compareTo(name) > 0){//if it dosen't work change ">" to ">="
			temp=current.next;
			current.next = new Node<T>(val);
			current = current.next;
			current.next = temp;
			return;
			}
			findNext();
		}
		insert(val);//insert at the end
	}
	public void insertSortedE(String title , T val) {//insert a sorted event list
		if(empty())
			current = head = new Node<T>(val);
		Node<T> temp;
		if(((Event)head.data).getTitle().compareTo(title) > 0){//if it dosen't work change ">" to ">="
			
			temp=new Node<T>(val);
			temp.next=head;
			head=temp;
			return;
			}
		current=head;
		while(!last()) {
			if(((Event)current.next.data).getTitle().compareTo(title) > 0){//if it dosen't work change ">" to ">="
			temp=current.next;
			current.next = new Node<T>(val);
			current = current.next;
			current.next = temp;
			return;
			}
			findNext();
		}
		insert(val);//insert at the end
	}

	


}
