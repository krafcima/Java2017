package H6;
import java.util.HashMap;
import java.util.TreeSet;

public class Spoluziaci {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet <String> spol = new TreeSet<String>();
		for (String a:DataForYou.spoluziaci){
			spol.add(a);
		}
		//System.out.println(spol);
		//System.out.println(spol.size());
		HashMap <String, Integer> m = new HashMap<String, Integer>();
		for (String a:DataForYou.spoluziaci){
			Integer cis = m.get(a);
			if (cis == null){
				m.put(a, 1);
			}
			else {
				m.put(a, cis+1);
			}
		}
		Integer maximum = -1;
		String maxstr = "";
		for (String j:m.keySet()){
			if (m.get(j) > maximum){
				maximum = m.get(j);
				maxstr = j;
			}
		}
		System.out.println(maxstr);
		System.out.println(maximum);
		System.out.println(m);
		
		
		TreeSet<StringWithLength> mnozina = new TreeSet<StringWithLength>();
		for (String a:DataForYou.spoluziaci){
			mnozina.add(new StringWithLength(a));
		}
		System.out.print(mnozina);
	}

}

class StringWithLength implements Comparable <StringWithLength>{
	String name = "";
	
	public StringWithLength(String nName){
		name = nName;
	}
	
	public String toString(){
		return name;
	}

	@Override
	public int compareTo(StringWithLength x) {
		int dlzka1 = this.name.length();
		int dlzka2 = x.name.length();
		int porovnanie = new Integer(dlzka1).compareTo(new Integer(dlzka2));
		if (porovnanie != 0) return porovnanie;
		return this.name.compareTo(x.name);
	}
	
}
