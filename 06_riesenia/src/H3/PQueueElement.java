package H3;
public class PQueueElement<E> implements Comparable<PQueueElement<E>>{

	private E value;
	private int priority;

	public PQueueElement(E value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public E getValue() {
		return value;
	}

	@Override
	public int compareTo(PQueueElement<E> o) {
		return (o.priority - priority);
	}


}
