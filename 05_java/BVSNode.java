import java.util.*;

public class BVSNode<E extends Comparable<E>> {
	BVSNode<E> left;
    E key; 
    BVSNode<E> right;
    
    BVSNode(E theKey) {
        key = theKey;
        left = right = null;
    }
     public BVSNode<E> insert (E k) {
 	  if (k.compareTo(key) < 0)
 	    if (left == null)
  	      left = new BVSNode<E>(k);
   	    else
  		  left = left.insert(k);
  	  else
  	    if (right == null)
  	      right = new BVSNode<E>(k);
  	    else 
  		  right = right.insert(k);
  	  return this;
    }
    public void print () {
    	System.out.println ("<" + key + ":" + "> - <" + (left == null ? "x" : "" + left.key) + ">, <" + (right == null ? "x" : "" + right.key) + ">");
    	if (left != null) left.print ();
    	if (right != null) right.print ();
        }
    public String toString(){
    	return "";  // cvicenie 6
    }
    public Object[] toArray() {
    	Object[] p = new Object[10]; 
    	p[0] = key; 
    	p[1] = (left != null)?left.key:key; // ...
    	p[2] = (right != null)?right.key:key;
    	return p;
    }
    @SuppressWarnings("unchecked")
	public E[] toMArray() {
        E[] p =  (E[])new Comparable[10]; 
    	p[0] = key;  
    	p[1] = (left != null)?left.key:key; // ...
    	p[2] = (right != null)?right.key:key;
    	return p;
    }
    public E[] toMArray2(E[] x) {
    	List<E> l = new ArrayList<E>();
    	l.add(key);
    	l.add((left != null)?left.key:key);
    	l.add((right != null)?right.key:key);
    	// ...
        return l.toArray(x); 
    }
    ArrayList<E> toList() {
    	ArrayList<E> al = new ArrayList<E>();
    	al.add(key);
    	return al;
    }
    boolean find(E key) {
      return false; // cvicenie 6	
    }
    void delete(E key) {
    	// cvicenie 6
    }
}
