import java.util.Random;

public class Pole2D {

	public static void main(String[] args) {
		/*System.out.println(pocet(null));
		System.out.println(pocet(new String[][]{null}));
		System.out.println(pocet(new String[][]{null,null,null}));
		System.out.println(pocet(new String[][]{null,new String[]{null,"jano","yesno"}}));

		for(int i = 0; i < 100; i++) {
			nahodnyRetazec();
		}
		nahodnePole1D();*/

		while(pocet(nahodnePole2D()) == 0 ){
			System.out.println(".");

		}
	}
	public static int pocet(String[][] a){
		int pocitadlo=0;
		if(a==null){
			return 0;
		}
		for(int i=0;i<a.length;i++){
			if(a[i]==null){
				continue;
			}
			for(int j =0;j<a[i].length;j++){
				if(a[i][j]!=null){
					String slovo = a[i][j].toLowerCase();
					if(slovo.contains("dsfgsdfgsgs") || slovo.contains("dadasafsasfaf")){
						pocitadlo++;
					}
				}
			}
		}
		return pocitadlo;
	}

	public static String nahodnyRetazec() {
		Random rnd = new Random();
		int lenght = rnd.nextInt(25);
		StringBuffer s = new StringBuffer();
		for(int i = 0; i < lenght; i++) {
			int nah = rnd.nextInt((int)'z' - (int) 'a' + 1) + (int) 'a';
			s.append((char) nah);
		}
		//System.out.println(s.toString());
		return s.toString();
	}

	public static String[] nahodnePole1D(){
		Random rnd = new Random();
		int length = rnd.nextInt(100);
		String[] pole = new String[length];
		for(int i = 0; i < pole.length; i++){
			pole[i] = nahodnyRetazec();
		}
		return pole;

	}

	public static String[][] nahodnePole2D(){
		Random rnd = new Random();
		int length = rnd.nextInt(100);
		String[][] pole = new String[length][];
		for(int i = 0; i < pole.length; i++){
			pole[i] = nahodnePole1D();
		}
		return pole;

	}
}
