import java.util.ArrayList;
/**
 * rododendron
 * @author PB
 */
public class RododendronForest <E extends Comparable<E>> {
	  private ArrayList<RododendronTree<E>> broths;
	  
	  public RododendronForest(ArrayList<RododendronTree<E>> broths) {
		  this.broths = broths;
	  }
	  public String toString(){
		  String s = "";
		  char ch = '[';
		   for(RododendronTree<E> e:broths) {
			  s += ch + e.toString();
			  ch = ',';
		  }
		  s += "]";
		  return s;
	  }
	  public boolean find(E key) {
		  for(RododendronTree<E> e:broths) {
			  if (e.find(key)) return true;
		  }
		  return false;
	  }
	  public int size() {
		  int s = 0;
		  for(RododendronTree<E> e:broths) {
			  s += e.size();
		  }
		  return s;
	  }
	  public void insert(E parent, E el) {
		for(RododendronTree<E> e:broths)
		  e.insert(parent,el);
	  }
	  public void addLast(RododendronTree<E> t) {
		if (broths == null)
		  broths = new ArrayList<RododendronTree<E>>();
		broths.add(t);
	  }
	  public RododendronForest<E> remove(E el, RododendronForest<E> f) {
		if (f == null)
		  return f;
		else { 
		  ArrayList<RododendronTree<E>> newBroths = new ArrayList<RododendronTree<E>>(); 	
		  for(RododendronTree<E> e:broths) {
		    RododendronTree<E> t = e.remove(el,e);
		    if (t != null)
		      newBroths.add(t);	
		  }
		  return new RododendronForest(newBroths);
		}
	  }
	  public static void main(String[] args) {
		  RododendronTree<String> t1 = new RododendronTree<String>("system");
	  	  RododendronTree<String> t2 = new RododendronTree<String>("system32");
		  RododendronTree<String> t3 = new RododendronTree<String>("config");
		  ArrayList<RododendronTree<String>> al1 = new ArrayList<RododendronTree<String>>();
		  al1.add(t1);
		  al1.add(t2);
		  al1.add(t3);
		  RododendronTree<String> t123 = new RododendronTree<String>("WINNT", new RododendronForest<String>(al1));
		  RododendronTree<String> u1 = new RododendronTree<String>("Universal crack");
		  RododendronTree<String> u2 = new RododendronTree<String>("java");
		  ArrayList<RododendronTree<String>> al2 = new ArrayList<RododendronTree<String>>();
		  al2.add(u1);
		  al2.add(u2);
		  RododendronTree<String> u12 = new RododendronTree<String>("Program Files", new RododendronForest<String>(al2));

		  ArrayList<RododendronTree<String>> al3 = new ArrayList<RododendronTree<String>>();
		  al3.add(t123);
		  al3.add(u12);
		  
		  RododendronForest<String> disk = new RododendronForest<String>(al3);
		  System.out.println(disk);
		  System.out.println(disk.find("java"));
		  System.out.println(disk.find("kava"));
		  System.out.println(disk.size());
		  disk.insert("java","pascal");
		  disk.insert("java","c++");
		  System.out.println(disk);
		  disk = disk.remove("config",disk);
		  System.out.println(disk);
		  disk = disk.remove("java",disk);
		  System.out.println(disk);
		  disk = disk.remove("WINNT",disk);
		  System.out.println(disk);
		  disk = disk.remove("Universal crack",disk);
		  System.out.println(disk);
		  disk = disk.remove("Program Files",disk);
		  System.out.println(disk);
	  }
	}
