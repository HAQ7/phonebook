
//INTERFACE: List.java
//        CSC212 Data structures - Project phase I
//        Fall 2023
//        EDIT DATE:
//        10-16-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)
public interface List<T> {
	public void findNext();

	public void findFirst();

	public T retrieve();

	public void update(T val);

	public void insert(T val);

	public void remove();

	public boolean full();

	public boolean empty();

	public boolean last();
}
