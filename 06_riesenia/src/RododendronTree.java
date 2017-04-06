import java.util.ArrayList;

public class RododendronTree <E extends Comparable<E>> {
  private E elem;
  private RododendronForest<E> sons;
  
  public RododendronTree(E elem) {
	  this(elem,null);
  }
  public RododendronTree(E elem, RododendronForest<E> sons) {
	 this.elem = elem;
	 this.sons = sons; 
  }
  public String toString() {
	 if (sons == null)
	     return elem.toString();
	 else
	     return "("+elem.toString()+":"+sons.toString()+")";
  }
  public boolean find(E key) {
	  if (elem.equals(key)) return true;
	  else if (sons != null) return sons.find(key);
	  else return false;
  }
  public int size() {
	  if (sons != null) return 1+sons.size();
	  else return 1;
  }
  public void insert(E parent, E el) {
    if (elem.equals(parent)) {
	  RododendronTree<E> t = new RododendronTree<E>(el); 
	  if (sons == null)
		sons = new RododendronForest(new ArrayList<RododendronForest<E>>());
  	  sons.addLast(t);
	} else {
		if (sons != null) 
		  sons.insert(parent,el);
	 }
  }
  public RododendronTree<E> remove(E el, RododendronTree<E> t) {
    if (t == null) 
      return t;
    else if ((t.elem).equals(el)) 
      return null;
    else {
      if (sons != null)	
        sons = sons.remove(el,sons);
      return t;
    }  
  }  
}
 