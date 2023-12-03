
//CLASS: LinkedList.java
//        CSC212 Data structures - Project phase II
//        Fall 2023
//        EDIT DATE:
//        12-2-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

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
    public void insert(T val) { // O(1)
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
    // O(n)
    public void insertSorted(String identifier, T val) {
        if (empty()) {
            insert(val);
            return;
        }
        boolean canInsertHead = false;
        if (val instanceof Contact) {
            canInsertHead = ((Contact) head.data).getName().compareTo(identifier) > 0;
        } else if (val instanceof Event) {
            canInsertHead = ((Event) head.data).getTitle().compareTo(identifier) > 0;
        }
        findFirst();
        if (canInsertHead) {
            Node<T> temp = new Node<T>(val);
            temp.next = head;
            head = temp;
            return;
        }
        while (!last()) {
            if (val instanceof Contact) {
                if (((Contact) current.next.data).getName().compareTo(identifier) > 0) {
                    insert(val);
                    return;
                }
            }
            else if (val instanceof Event) {
                if (((Event) current.next.data).getTitle().compareTo(identifier) > 0) {
                    insert(val);
                    return;
                }
            }
                findNext();

        }
        insert(val);
    }

    // Deleting method

    public void remove() { // O(n)
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
