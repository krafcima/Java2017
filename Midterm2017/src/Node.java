public class Node {
    Node left;		// ¾avý podstrom
    Integer key; 	// hodnota vrchola
    Node right;		// pravý podstrom
    
    public Node(Node left, Integer key, Node right) {
    	this.left=left; this.key=key; this.right = right;
    }
    public String toString() {
    	return "(" + 
    			((left!=null)?left.toString():".") +
    			"," +
    			key +
    			"," +
				((right!=null)?right.toString():".") +
    			")";
    }
    public String path(Integer k) {
    	return path(k, new StringBuffer());
    }
    private String path(Integer k, StringBuffer p) {
    	if (key.compareTo(k) < 0) { // key < k
    		if (right == null)
    			return null;
    		else 
    			return right.path(k, p.append("R"));
    	} if (key.compareTo(k) > 0) { // key > k
    		if (left == null)
    			return null;
    		else 
    			return left.path(k, p.append("L"));
    	} else // key == k
    		return p.toString();

    }
    
    public static Node makeTree(int from, int to) {
    	if (from > to) 
    		return null;
    	if (from == to) 
    		return new Node(null, from, null);
    	else
    		return new Node( makeTree(from, (from+to)/2-1), (from+to)/2, makeTree((from+to)/2+1, to));	
    }
}
