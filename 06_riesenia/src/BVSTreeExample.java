import java.util.Random;

	public class BVSTreeExample {
	    public static void main (String args[]) {
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        Random r = new Random();
	        for(int i=0; i<11; i++) {
	          Integer q = r.nextInt(100);
	          s.insert(q);
	          System.out.print(s.find(q) + ", ");
	        }
	        System.out.println();
	        System.out.println(s);
	        System.out.println(s.height());
	        
	        System.out.print("toArray:");
	        for(Integer elem : s.toArray(new Integer[]{}))
	        	  System.out.print(elem + ",");  
	        System.out.println();
	          
	        System.out.print("toList:");
	        for(Integer elem : s.toList())
	          	  System.out.print(elem + ",");
	        System.out.println();
	          
	        System.out.print("delete: ");
	        for(int i=0; i<55; i++) {
	              Integer q = r.nextInt(100);
	              System.out.print(q + ", ");
	              s.delete(q);
	        }
	        System.out.print("\ntoList po delete:");
	        for(Integer elem : s.toList())
	          	  System.out.print(elem + ",");  
	        System.out.println();
	        System.out.println(s);
	     }
}
