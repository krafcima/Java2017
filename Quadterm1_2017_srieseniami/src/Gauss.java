public class Gauss {
	private double[][] p;	// vnutorna reprezentacia musi zostat private
	public Gauss(double[][] pole) {   // konstruktora sa nechyajte
		this.p = pole.clone();
		for(int i = 0; i < pole.length; i++)
			this.p[i] = pole[i].clone();
	}
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer("{\n");
		for(int i = 0; i < p.length; i++) {
			res.append("\t{");
			for(int j = 0; j < p[i].length; j++) {
				res.append(p[i][j] + ((j+1 <p[i].length)?", ":""));
			}
			res.append((i+1 < p.length)?"},\n":"} \n}\n"); 
		}
		return res.toString(); 
	}
	public double[] dajRiadok(int r) {
		return p[r];
	}
	//----------------------------------- nad ciarou nemodifikujte, programujte pod ciarou
	/*
	 * vynasobi riadok pola cim
	 */
	public void vydel(int riadok, double cim) {
		if (cim != 0 && riadok >= 0 && riadok < p.length)
			for (int j = 0; j < p[riadok].length; j++) 
				p[riadok][j] /= cim;
	}
	/*
	 * vymeni riadok1 a riadok2
	 */
	public void vymen(int riadok1, int riadok2) {
		if (riadok1 >= 0 && riadok1 < p.length && riadok2 >= 0 && riadok2 < p.length && riadok1 != riadok2 && p[riadok1].length == p[riadok2].length)
			for (int j = 0; j < p[riadok1].length; j++) {
				double temp = p[riadok1][j];
				p[riadok1][j] = p[riadok2][j];
				p[riadok2][j] = temp;
			}
	}
	/*
	 * k riadku riadok1 pripocitaj x-nasobok riadku riadok2
	 */
	public void pripocitaj(int riadok1, double x, int riadok2) {
		if (riadok1 >= 0 && riadok1 < p.length && riadok2 >= 0 && riadok2 < p.length)
			for (int j = 0; j < p[riadok1].length; j++) 
				p[riadok1][j] += x*p[riadok2][j];
	}	
	/*
	 * Gaussova eliminacna metoda pre p = Pole2D(double[M][N]...) - M riadkov N stlpcov
	 * pre kazde r z intervalu [0..M-1]
	 * 	ak je p[r][r] == 0, najdi nejaky riadok j z intervalu [r+1..M-1], ze v r-tom stlpci je p[j][r] != 0
	 *    ak taky riadok j existuje, vymen riadky r a j,
	 *    ak taky riadok j neexistuje, vysledkom je false a skonci (znamena to tazky pripad)
	 * 	teraz urcite uz je p[r][r] != 0
	 * 	vydel riadok r cislom p[r][r]
	 * 	ku kazdemu riadku j != r pripocitaj -p[j][r] nasobok r-teho riadku
	 * ked skoncis cyklus, vrat true, eliminacia sa podarila  
	 */
	public boolean gauss() {
		for(int r = 0; r < p.length; r++) {
			// System.out.println(this); -- toto ked si odkomentujete, vidite Gaussovu metodu
			if (p[r][r] == 0)
				for(int j = r+1; j < p.length; j++)
					if (p[j][r] != 0) { 
						vymen(r, j);
						break;
					}
			if (p[r][r] == 0)  // asi sme take nenasli
				return false;
			vydel(r, p[r][r]);
			for(int j = 0; j < p.length; j++) 
				if (j != r) 
					pripocitaj(j, -p[j][r], r);
		}
		return true;
	}
	public static void main(String[] args) {
		Gauss p = new Gauss(new double[][]{
			{2, 4, -2, 6},
			{0, -3, 6, -3},
			{4, 1, -2, 2} });
		System.out.println(p.gauss());
		System.out.println(p);
	}
}
