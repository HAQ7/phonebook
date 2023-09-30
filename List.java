
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
