package H3;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(DataPourVous.graph);
		System.out.println(g);
		//System.out.println(g.hasEdge(0,3));
		//System.out.println(g.hasEdge(0,5));
		//System.out.println(g.removeEdge(0,3));
		//System.out.println(g.removeEdge(0,5));
		//System.out.println(g);
		//System.out.println(g.getDegree(6));
		System.out.println(g.addEdge(0,3));
		System.out.println(g.addEdge(0,5));
		System.out.println(g);

	}

}
