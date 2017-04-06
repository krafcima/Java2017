import java.util.TreeSet;
import java.util.TreeMap;

public class Like {
	TreeMap<String, TreeMap<String, TreeSet<Integer>>> likes;

	public Like(String[] args) {
		likes = new TreeMap<String, TreeMap<String, TreeSet<Integer>>>();
		for (String arg : args) {
			String[] parts = arg.split("-");
			String kto = parts[0];
			String koho = parts[1];
			for (int i = 2; i < parts.length; i++) {
				String preco = parts[i];
				if (preco == null)
					continue;
				if (likes.get(kto) == null)
					likes.put(kto, new TreeMap<String, TreeSet<Integer>>());
				if (likes.get(kto).get(koho) == null)
					likes.get(kto).put(koho, new TreeSet<>());
				likes.get(kto).get(koho).add(Integer.parseInt(preco));
			}
		}
	}
	public void unfriended() {
		if (likes != null) {
			next:
			for(String kto : likes.keySet()) {
				for(String kto1 : likes.keySet()) {
				   if (likes.get(kto1).keySet().contains(kto))
					   continue next;
				}
				System.out.println(kto);
			}
		}
	}

	public TreeMap<String, TreeMap<String, TreeSet<Integer>>> liked() {
		TreeMap<String, TreeMap<String, TreeSet<Integer>>> liked = new TreeMap<String, TreeMap<String, TreeSet<Integer>>>();
		if (likes != null) {
			for(String kto : likes.keySet()) {
				if (likes.get(kto) != null) {
					for(String koho : likes.get(kto).keySet()) {
						if (likes.get(kto).get(koho) != null) {
							for (Integer preco : likes.get(kto).get(koho)) {
								if (liked.get(koho) == null)
									liked.put(koho, new TreeMap<String, TreeSet<Integer>>());
								if (liked.get(koho).get(kto) == null)
									liked.get(koho).put(kto, new TreeSet<>());
								liked.get(koho).get(kto).add(preco);
							}							
						}
					}
				}
			}
		}
		return liked;
	}

	// x-y-preco
	public static void main(String[] args) {
		Like t = new Like(args);
		System.out.println(t.likes);
		t.unfriended();
		System.out.println(t.liked());
	}
}

/*
Xaver-Matilda-1-3
Paula-Sara-2-3
Sara-Xaver-1-3
Xaver-Rexana-2
Rexana-Saxana-2-1
Bohumila-Xaver-2-2
Bohumila-Charlotte-2-1
Colette-Chalotte-2
Matilda-Bohumila-1
Paula-Rexana-1-3
Paula-Sara-1
*/