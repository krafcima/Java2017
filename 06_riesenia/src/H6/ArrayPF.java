package H6;

public class ArrayPF<E> implements FrontInterface<E> {
	int first;
	int last;
	int[] priorities;
	E[] values;
	int size;

	public ArrayPF(int size) {
		priorities = new int[size];
		values = (E[])new Object[size];
		first = 0;
		last = 0;
		this.size = size;
	}

	@Override
	public void enqueue(E elem, int prio) {
		int temp = Math.floorMod(first - 1, size);
		int i = first;
		int i_1 = Math.floorMod(first - 1, size);
		while (prio > priorities[i] && i != last) {
			values[i_1] = values[i];
			priorities[i_1] = priorities[i];
			i_1 = i;
			i = Math.floorMod(i + 1, size);
		}
		values[i_1] = elem;
		priorities[i_1] = prio;
		first = temp;
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		E temp = values[first];
		values[first] = null;
		priorities[first] = 0;
		first = Math.floorMod(first + 1, size);
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == last;
	}

	public static void main(String[] args) {
        ArrayPF<String> f = new ArrayPF<String>(100);
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
