package H6;

public class ListPF<E> implements FrontInterface<E> {
	Elem<E> head;
	int size;

	ListPF() {
		head = null;
		size = 0;
	}

	@Override
	public void enqueue(E elem, int prio) {
		// TODO Auto-generated method stub
		Elem<E> newElem = new Elem<E>(prio, elem, null);
		if (isEmpty()) {
			head = newElem;
		}
		else if (prio < head.getPrior()) {
			newElem.setNext(head);
			head = newElem;
		}
		else {
			Elem<E> p = head;
			Elem<E> prev = null;
			while (p != null && prio > p.getPrior()) {
				prev = p;
				p = p.getNext();
			}
			prev.setNext(newElem);
			newElem.setNext(p);
		}
		size++;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		Elem<E> res = head;
		head = head.getNext();
		size--;
		return res.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

	public static void main(String[] args) {
		ListPF<String> f = new ListPF<String>();
        f.enqueue(new String("janka"), 5);
        f.enqueue(new String("danka"), 2);
        f.enqueue(new String("hanka"), 1);
        f.enqueue(new String("anka"), 4);
        f.enqueue(new String("zuzanka"), 3);
        f.enqueue(new String("elenka"), 0);
        f.enqueue(new String("zofka"), 6);
        f.enqueue(new String("evka"), 4);
        System.out.println(f);
        while (!f.isEmpty())
            System.out.println(f.dequeue());
	}
}
