package H3;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Graph {
	
	TreeMap<Integer, ArrayList<Integer>> graf = new TreeMap<Integer, ArrayList<Integer>>();

	Graph(int[][] N){
		for (int i = 0; i < N.length; i++){
			ArrayList<Integer> sus = new ArrayList<Integer>();
			for (int j = 0; j < N[i].length; j++){
				sus.add(N[i][j]);
			}
			graf.put(i, sus);
		}
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<Integer, ArrayList<Integer>> dvojica : this.graf.entrySet()){
			sb.append(dvojica.getKey() + " : " + dvojica.getValue() + "\n");
		}
		return sb.toString();
	}
	
	public boolean hasEdge(int u, int v){
		return graf.get(u).contains(v);
	}
	
	public boolean removeEdge(int u, int v){
		if (!hasEdge(u, v)){
			return false;
		}
		graf.get(u).remove(new Integer(v));
		graf.get(v).remove(Integer.valueOf(u));
		return true;
	}
	
	public int getDegree(int v){
		return graf.get(v).size();
	}
	
	public boolean addEdge(int u, int v){
		if (hasEdge(u, v)){
			return true;
		}
		graf.get(u).add(v);
		graf.get(v).add(u);
		return false;
	}
}
