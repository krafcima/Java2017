package H3;
public class ArrayPF<E> implements FrontInterface<E> {

	public static void main(String[] args) {
		ArrayPF<String> f = new ArrayPF<String>(100);
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
	
	int tail = -1;
	E[] storage;
	int[] priorities;

	@SuppressWarnings("unchecked")
	public ArrayPF(int cap){
		storage = (E[]) new Object[cap];
		priorities = new int[cap];
	}

	@Override
	public void enqueue(E elem, int prio) {
		if(tail < storage.length - 1){
			tail++;
			storage[tail] = elem;
			priorities[tail] = prio;
			return;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	@Override
	public E dequeue() {
		if(tail == -1){
			return null;
		}
		int max = priorities[0], maxIndex = 0;
		for(int i = 1; i <= tail; i++){
			if(priorities[i] > max){
				max = priorities[i];
				maxIndex = i;
			}
		}
		E ret = storage[maxIndex];

		for(int i = maxIndex; i < tail; i++){
			storage[i] = storage[i + 1];
			priorities[i] = priorities[i + 1];
		}
		tail--;
		return ret;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

}
