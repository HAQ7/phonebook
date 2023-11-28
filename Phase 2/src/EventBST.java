// 

// ***************************

//     no need for this class 

// ***************************


//public class EventBST<T> {
//
//	BSTNode<T> root, current;
//
//	public EventBST() {
//		root = current = null;
//	}
//
//	public boolean empty() {
//		return root == null;
//	}
//
//	public boolean full() {
//		return false;
//	}
//
//	public T retrieve() {
//		return current.data;
//	}
//
//	public boolean findkey(String tkey) {
//		BSTNode<T> p = root, q = root;
//
//		if (empty())
//			return false;
//
//		while (p != null) {
//			q = p;
//			if (p.key.equals(tkey)) {
//				current = p;
//				return true;
//			} else if (current.key.compareTo(tkey) > 0)
//				p = p.left;
//			else
//				p = p.right;
//		}
//
//		current = q;
//		return false;
//	}
//
//	public boolean insert(String k, T val) {
//		BSTNode<T> p, q = current;
//
//		if (findkey(k)) {
//			current = q; // findkey() modified current
//			return false; // key already in the BST
//		}
//
//		p = new BSTNode<T>(k, val);
//		if (empty()) {
//			root = current = p;
//			return true;
//		} else {
//			// current is pointing to parent of the new key
//			if (p.key.compareTo(k) > 0)
//				current.left = p;
//			else
//				current.right = p;
//			current = p;
//			return true;
//		}
//	}
//
//	public boolean removeKey(String k) {
//		// Search for k
//		String k1 = k;
//		BSTNode<T> p = root;
//		BSTNode<T> q = null; // Parent of p
//		while (p != null) {
//
//			if (p.key.compareTo(k1) > 0) {
//				q = p;
//				p = p.left;
//			} else if (p.key.compareTo(k1) < 0) {
//				q = p;
//				p = p.right;
//			} else { // Found the key
//
//				// Check the three cases
//				if ((p.left != null) && (p.right != null)) { // Case 3: two
//					// children
//					// Search for the min in the right subtree
//					BSTNode<T> min = p.right;
//					q = p;
//					while (min.left != null) {
//						q = min;
//						min = min.left;
//					}
//					p.key = min.key;
//					p.data = min.data;
//					k1 = min.key;
//					p = min;
//					// Now fall back to either case 1 or 2
//				}
//
//				// The subtree rooted at p will change here
//				if (p.left != null) { // One child
//					p = p.left;
//				} else { // One or no children
//					p = p.right;
//				}
//
//				if (q == null) { // No parent for p, root must change
//					root = p;
//				} else {
//					if (q.key.compareTo(k1) > 0) {
//						q.left = p;
//					} else {
//						q.right = p;
//					}
//				}
//				current = root;
//				return true;
//
//			}
//		}
//
//		return false; // Not found
//	}
//
//	public boolean isConflict(String date) {
//		return isConflictH(root, date, false);
//	}
//
//	public boolean isConflictH(BSTNode bt, String date, boolean conflict) {
//		if (bt == null) {
//			return conflict;
//		}
//		conflict = isConflictH(bt.left, date, conflict);
//		if (((Event) (bt.data)).getDate().equals(date))
//			conflict = true;
//		conflict = isConflictH(bt.right, date, conflict);
//		return conflict;
//
//	}
//
//	public void printEvents() { // O(n)
//		printEventsH(root);
//	}
//
//	private void printEventsH(BSTNode bt) {
//		if (bt == null) {
//			return;
//		}
//		printEventsH(bt.left);
//		((Event) (bt.data)).printEvent();
//		printEventsH(bt.right);
//	}
//
//	public void printSharedEventC(String contactName) {
//
//	}
//
//	// H
//
//	public void printSharedContactE(ContactBST bstC, String title) {
//		int count = 0;
//		if (findkey(title)) {
//			System.out.println(++count + ". ");
//			for (int i = 0; i < ((Event) retrieve()).getContactName().length; i++)
//				bstC.searchContact(((Event) retrieve()).getContactName()[i], SearchType.name);
//		}
////		printSharedContactEH(root, bstC, title, count);
//		
//		if (count == 0)
//           System.out.println("\nSorry, there's no event with that title : \"" + title + "\".\n");
//	}
//
//	// return int
////	private void printSharedContactEH(BSTNode bt, ContactBST bstC, String title, int count) {
////		if (bt == null) {
////			return;
////		}
////		printSharedContactEH(bt.left, bstC, title, count);
////		if (findkey(title)) {
////			System.out.println(++count + ". ");
////			for (int i = 0; i < ((Event) (bt.data)).getContactName().length; i++)
////				bstC.searchContact(((Event) (bt.data)).getContactName()[i], SearchType.name);
////		}
////		printSharedContactEH(bt.right, bstC, title, count);
////	}
//
//	public void printSharedEventE(String eventTitle) {
//		int count = 0;
//		printSharedEventEH(root, eventTitle, count);
//	}
//
//	// title is unique ?
//	private void printSharedEventEH(BSTNode bt, String eventTitle, int count) {
//		if (bt == null) {
//			return;
//		}
//		printSharedEventEH(bt.left, eventTitle, count);
//		if (findkey(eventTitle)) {
//			System.out.println(++count + ". ");
//			((Event) (bt.data)).printEvent();
//		}
//		printSharedEventEH(bt.right, eventTitle, count);
//	}
//}
