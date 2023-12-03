//CLASS: BSTNode.java
//        CSC212 Data structures - Project phase II
//        Fall 2023
//        EDIT DATE:
//        12-2-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

public class BSTNode<T> {
	public String key;
	public T data;
	public BSTNode<T> left, right;
	
	/** Creates a new instance of BSTNode */
	public BSTNode(String k, T val) {
		key = k;
		data = val;
		left = right = null;
	}
	
	public BSTNode(String k, T val, BSTNode<T> l, BSTNode<T> r) {
		key = k;
		data = val;
		left = l;
		right = r;
	}

}


