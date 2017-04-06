import java.util.ArrayList;
import java.util.Random;
public class BVSTree<E extends Comparable<E>>  implements BVSTreeInterface <E> {
    private BVSNode<E> root;

    public BVSTree () {
 	  root = null;
    }
    public BVSTree (E x) {
	  this();
	  insert(x);
    }
    public boolean find(E k) {
		return false; //doprogramuj
    }
    public void delete(E k) {
		return; //doprogramuj
    }
    public void insert(E x) {
	  if (root == null) root = new BVSNode<E>(x);
	  else root.insert (x);
    }
    public String toString(){
		return null; //doprogramuj
    }
    public E[] toArray(E[] dummy) {
		return null; //doprogramuj
    }
    public ArrayList<E> toList() {
		return null; //doprogramuj
    }
	public int height() {
		return 0; //doprogramuj
	}
}
