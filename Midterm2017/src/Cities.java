import java.util.TreeMap;
import java.util.TreeSet;

// java Cities BA-ZA-KE BA-NR-BB-KE PO-SK-BJ NR-ZA

public class Cities {
	static TreeMap<String, TreeSet<String>> cudo = new TreeMap<String, TreeSet<String>>();

	public static void main(String[] args) {
		for (String arg : args) {
			String[] edges = arg.split("-");
			String vertex = null;
			for (String v : edges) { // sem pride graf…
				if (vertex != null) {
					TreeSet<String> set = cudo.get(vertex);
					if (set == null)
						set = new TreeSet<String>();
					set.add(v);
					cudo.put(vertex, set);
				}
				vertex = v;
			}
		}
		System.out.println(cudo);
	}
}
