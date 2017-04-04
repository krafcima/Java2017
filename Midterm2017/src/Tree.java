public class Tree  {
    Node root;
    
    public Tree(Node root) {
		this.root = root;
	}
    public String toString() {
    	return (root != null)?root.toString():"empty";
    }
    public Tree(int from, int to) {
    	root = Node.makeTree(from, to);
    }

	public static void main(String[] args) {
    	Tree t = new Tree(1,4);
    	System.out.println(t);
    }
}
