package H3;
public class ListPF<E> implements FrontInterface<E> {

	private Elem<E> head;

	public ListPF() {
		head = null;
	}

	@Override
	public void enqueue(E elem, int prio) {
		Elem<E> newEl = new Elem<E>(prio, elem, null);
		if (head == null) {
			head = newEl;
			return;
		}

		if (head.getPrior() < prio) {
			newEl.setNext(head);
			head = newEl;
			return;
		}

		Elem<E> active = head, next = head.getNext();
		while (next != null && next.getPrior() > prio) {
			active = next;
			next = active.getNext();
		}
		newEl.setNext(next);
		active.setNext(newEl);
	}

	@Override
	public E dequeue() {
		if (!isEmpty()) {
			E res = head.getElement();
			head = head.getNext();
			return res;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	public static void main(String[] args) {
		ListPF<String> f = new ListPF<String>();
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
