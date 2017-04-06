package H3;
import java.util.PriorityQueue;

public class PrioritnyFront<E> implements FrontInterface<E> {

	PriorityQueue<PQueueElement<E>> internalPQueue;

	public PrioritnyFront() {
		internalPQueue = new PriorityQueue<PQueueElement<E>>();
	}


	@Override
	public void enqueue(E elem, int prio) {
		internalPQueue.add(new PQueueElement<E>(elem, prio));
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		return internalPQueue.poll().getValue();
	}

	@Override
	public boolean isEmpty() {
		return internalPQueue.isEmpty();
	}



	public static void main(String[] args) {
		PrioritnyFront<String> f = new PrioritnyFront<String>();
		f.enqueue(new String("janka"), 5);
		f.enqueue(new String("danka"), 2);
		f.enqueue(new String("hanka"), 1);
		f.enqueue(new String("anka"), 4);
		f.enqueue(new String("zuzanka"), 3);
		f.enqueue(new String("elenka"), 1);
		f.enqueue(new String("zofka"), 6);
		f.enqueue(new String("evka"), 4);
		System.out.println(f);
		while (!f.isEmpty())
			System.out.println(f.dequeue());
	}

}
