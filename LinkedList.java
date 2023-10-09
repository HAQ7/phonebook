
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

    public boolean full() {
        return false;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.next == null;
    }

    // Adding method
    public void insert(T val) {
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

    //insert a sorted contact list
    public void insertSortedC(String name, T val) {
        if (empty()) {
            insert(val);
            return;
        }

        findFirst();
        if (((Contact) head.data).getName().compareTo(name) > 0) {

            Node<T> temp = new Node<T>(val);
            temp.next = head;
            head = temp;
            return;
        }
        while (!last()) {
            if (((Contact) current.next.data).getName().compareTo(name) > 0) {
                insert(val);
                return;
            }
            findNext();
        }
        insert(val);
    }

    //insert a sorted event list
    public void insertSortedE(String title, T val) {
        if (empty()) {
            insert(val);
            return;
        }
        findFirst();
        if (((Event) head.data).getTitle().compareTo(title) > 0) {

            Node<T> temp = new Node<T>(val);
            temp.next = head;
            head = temp;
            return;
        }
        while (!last()) {
            if (((Event) current.next.data).getTitle().compareTo(title) > 0) {
                insert(val);
                return;
            }
            findNext();
        }
        insert(val);

    }

    public void searchContact(String val, SearchType type) {
        boolean found = false;
        findFirst();
        do {
            switch (type) {
                case name:
                    if (((Contact) (current.data)).equalsName(val)) {
                        ((Contact) current.data).printContact();
                        return;
                    }
                    break;
                case phone:
                    if (((Contact) (current.data)).equalsPhoneNumber(val)) {
                        ((Contact) current.data).printContact();
                        return;
                    }
                    break;
                case email:
                    if (((Contact) (current.data)).equalsEmail(val)) {
                        ((Contact) current.data).printContact();
                        found = true;
                    }
                        break;
                case address:
                    if (((Contact) (current.data)).equalsAddress(val)){
                        ((Contact) current.data).printContact();
                        found = true;
                    }
                        break;
                case birthday:
                    if (((Contact) (current.data)).equalsBirthday(val)){
                        ((Contact) current.data).printContact();
                        found = true;
                    }
                        break;
            }
            findNext();
        } while(current != null);
        findFirst();
        if (!found)
            System.out.println("Contact not found!");
    }
    // Deleting method

    public void remove() {
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



}
