package H6;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Susedia {

	public static void main(String[] args) {
		//pocet_vsetkych();
		//najviac_susedov();
		kontinenty();

	}

	public static TreeSet<String> pocet_vsetkych(){
		TreeSet<String> krajiny = new TreeSet<String>();

		for (String[] dvojica: DataPreVas.susedia){
			krajiny.add(dvojica[0]);
			krajiny.add(dvojica[1]);
		}
		return krajiny;
	}

	public static void najviac_susedov(){
		HashMap<String, HashSet<String>> susedia = new HashMap<String, HashSet<String>>();

		for (String[] dvojica: DataPreVas.susediaCelejGalaxie){
			String krajina1 = dvojica[0];
			String krajina2 = dvojica[1];
			pridaj_hranu(susedia, krajina1, krajina2);
			pridaj_hranu(susedia, krajina2, krajina1);
		}
		int max = -1;
		String maxstr = "";
		for (String krajina: susedia.keySet()){
			if (susedia.get(krajina).size() > max){
				max = susedia.get(krajina).size();
				maxstr = krajina;
			}
		}
		System.out.println(susedia.size());
		System.out.println(maxstr + " " + max);
	}

	private static void pridaj_hranu(HashMap<String, HashSet<String>> susedia, String krajina1, String krajina2) {
		HashSet<String> m;
		if (!susedia.containsKey(krajina1)){
			m = new HashSet<String>();
		}
		else{
			m = susedia.get(krajina1);
		}
		m.add(krajina2);
		susedia.put(krajina1, m);
	}

	public static void kontinenty(){
		ArrayList<HashSet<String>> pole = new ArrayList<HashSet<String>>();
		TreeSet<String> krajiny = pocet_vsetkych();
		for (String krajina: krajiny){
			HashSet<String> m = new HashSet<String>();
			m.add(krajina);
			pole.add(m);
		}

		for (String[] dvojica: DataPreVas.susedia ){
			String krajina1 = dvojica[0];
			String krajina2 = dvojica[1];

			int c1 = 0;
			int c2 = 0;

			for(int i = 0; i < pole.size(); i++){
				if (pole.get(i).contains(krajina1)){
					c1 = i;
				}
				if (pole.get(i).contains(krajina2)){
					c2 = i;
				}
			}
			if (c1 != c2){
				pole.get(c1).addAll(pole.get(c2));
				pole.remove(c2);
			}


		}
		System.out.print(pole);

	}

}
