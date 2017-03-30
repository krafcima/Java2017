public class BVSNode<E extends Comparable<E>> {
	BVSNode<E> left;
	E key;
	BVSNode<E> right;

	BVSNode(E theKey) {
		key = theKey;
		left = right = null;
	}
	public void insert(E k) { // bolo na prednaske, tak pouzijem
		return; //doprogramuj
	}
	public boolean find(E k) {
		return false; //doprogramuj
	}
	// asi tu pribudnu aj dalsie metody, tak doprogramuj...
}
