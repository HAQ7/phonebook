
//CLASS: ContactBST.java
//        CSC212 Data structures - Project phase II
//        Fall 2023
//        EDIT DATE:
//        12-2-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

public class ContactBST<T> {
	BSTNode<T> root, current;


	public ContactBST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public T retrieve() {
		return current.data;
	}

	public boolean findkey(String tkey) {
		BSTNode<T> p = root, q = root;

		if (empty())
			return false;

		while (p != null) {
			q = p;
			if (p.key.equals(tkey)) {
				current = p;
				return true;
			} else if (p.key.compareTo(tkey) > 0)
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return false;
	}

	public boolean insert(String k, T val) {
		BSTNode<T> p, q = current;

		if (findkey(k)) {
			current = q; // findkey() modified current
			return false; // key already in the BST
		}

		p = new BSTNode<T>(k, val);
		if (empty()) {
			root = current = p;
        } else {
			// current is pointing to parent of the new key
			if (current.key.compareTo(k) > 0)
				current.left = p;
			else
				current.right = p;
			current = p;
        }
        return true;
    }

	public boolean removeKey(String k) {
		// Search for k
		String k1 = k;
		BSTNode<T> p = root;
		BSTNode<T> q = null; // Parent of p
		while (p != null) {

			if (p.key.compareTo(k1) > 0) {
				q = p;
				p = p.left;
			} else if (p.key.compareTo(k1) < 0) {
				q = p;
				p = p.right;
			} else { // Found the key

				// Check the three cases
				if ((p.left != null) && (p.right != null)) { // Case 3: two
					// children
					// Search for the min in the right subtree
					BSTNode<T> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}

				// The subtree rooted at p will change here
				if (p.left != null) { // One child
					p = p.left;
				} else { // One or no children
					p = p.right;
				}

				if (q == null) { // No parent for p, root must change
					root = p;
				} else {
					if (q.key.compareTo(k1) > 0) {
						q.left = p;
					} else {
						q.right = p;
					}
				}
				current = root;
				return true;

			}
		}

		return false; // Not found
	}


	public void searchContact(String val, SearchType type) {
		if (!searchContactH(root, val, type, false))
			System.out.println("Contact not found!");
	}

	private boolean searchContactH(BSTNode bt, String val, SearchType type , boolean found) {
		if (bt == null) {
			return found;
		}
		found = searchContactH(bt.left, val, type, found);
		if ( found && type == SearchType.phone)
			return true;
		switch (type) {
			case phone:
				if (((Contact) (bt.data)).equalsPhoneNumber(val)) {
					((Contact) bt.data).printContact();
					return true;
				}
				break;
			case email:
				if (((Contact) (bt.data)).equalsEmail(val)) {
					((Contact) bt.data).printContact();
					found = true;
				}

				break;
			case address:
				if (((Contact) (bt.data)).equalsAddress(val)) {
					((Contact) bt.data).printContact();
					found = true;
				}

				break;
			case birthday:
				if (((Contact) (bt.data)).equalsBirthday(val)) {
					((Contact) bt.data).printContact();
					found = true;
				}
				break;
		}
		found = searchContactH(bt.right, val, type, found);
        return found;
    }


	public boolean isUnique(String phoneNumber) {
		return !isUniqueH(root, phoneNumber);
	}

	private boolean isUniqueH(BSTNode bt, String phoneNumber) {
		if (bt == null) {
			return false;
		}
		if (isUniqueH(bt.left, phoneNumber))
			return true;
		if (((Contact) (bt.data)).getPhoneNumber().equals(phoneNumber)) {
			return true;
		}
        return isUniqueH(bt.right, phoneNumber);

    }

	// try to use find key
	public void printFirstNameContact(String name) {
		int count = 0;
		count = printFirstNameContactH(root, name, count);
		if (count == 0)
			System.out.println("\nThere's no contact that has \"" + name + "\" as a first name.\n");
	}

	private int printFirstNameContactH(BSTNode bt, String name, int count) {
		if (bt == null) {
			return count;
		}
		count = printFirstNameContactH(bt.left, name, count);
		if (((Contact) (bt.data)).getName().startsWith(name)) {
			System.out.println(++count + ". \n********");
			((Contact) (bt.data)).printContact();
			System.out.println("********\n");
		}
		count = printFirstNameContactH(bt.right, name, count);
		return count;
	}
}