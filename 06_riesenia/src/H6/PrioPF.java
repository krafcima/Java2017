package H6;
import java.util.PriorityQueue;

public class PrioPF<E> implements FrontInterface<E>{

	public static void main(String[] args) {
		PrioPF<String> f = new PrioPF<String>();
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

	PriorityQueue<Elem<E>> queue;
	public PrioPF(){
		queue = new PriorityQueue<Elem<E>>();
	}
	@Override
	public void enqueue(E elem, int prio) {
		Elem<E> tmp = new Elem<E>(prio,elem,null);
		queue.add(tmp);

	}

	@Override
	public E dequeue() {
		if(isEmpty()){
			return null;
		}
		Elem<E> a = queue.peek();
		queue.remove(a);
		return a.getElement();
	}

	@Override
	public boolean isEmpty() {
		return queue.size()==0;
	}

}
