package H3;
public class PrioElem<E> implements Comparable<PrioElem<E>>{

	private E value;
	private int priority;

	public PrioElem(E value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public E getValue() {
		return value;
	}

	@Override
	public int compareTo(PrioElem<E> o) {
		return (o.priority - priority);
	}

}