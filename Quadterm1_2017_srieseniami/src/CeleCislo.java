abstract class CeleCislo {
	abstract Integer doDesiatkovej();	// toto doprogramujte v podtriedach
	
	/*
	 * pre 0x... vytvori Sestnastkove, 0b... vytvori Binarne, 0... vytvori Osmickove, inak Desiatkove cislo
	 */
	public static CeleCislo getCislo(String s) {
		if (s == null)
			return null;
		else if (s.startsWith("0x"))
			return (CeleCislo)new Sestnastkove(s);
		else if (s.startsWith("0b"))
			return (CeleCislo)new Binarne(s);
		else if (s.startsWith("0"))
			return (CeleCislo)new Osmickove(s);
		else
			return (CeleCislo)new Desiatkove(s);
	}
	/*
	 * this += x, pricom this a x mozu byt v roznych reprezentaciach, vysledok je v reprezentacii this
	 * ak this alebo x jej NaN, vrati NaN
	 */
	public CeleCislo sucet(CeleCislo x) {
		Integer a = doDesiatkovej();
		Integer b = x.doDesiatkovej();
		if (a == null || b == null)
			return new NaN();
		Integer vysledokVDesiatkoevej = a+b;
		if (this instanceof Binarne)
			return new Binarne(vysledokVDesiatkoevej);
		else if (this instanceof Osmickove)
			return new Osmickove(vysledokVDesiatkoevej);
		else if (this instanceof Sestnastkove)
			return new Sestnastkove(vysledokVDesiatkoevej);
		else if (this instanceof Desiatkove)
			return new Desiatkove(vysledokVDesiatkoevej);
		else // asi nemoze nastat
			return null;
	}
	/*
	 * postupne scita prvky polaCisel = {x1,...,xn} tak, ze vrati x1.sucet(x2).sucet(x3). ... .sucet(xn)
	 * ak je pole prazdne, alebo nulovej dlzky, vrati null
	 */
	public static CeleCislo sucet(CeleCislo[] poleCisel) {
		if (poleCisel == null || poleCisel.length == 0)
			return null;
		else {
			CeleCislo prve = poleCisel[0];
			for(int i = 1; i < poleCisel.length; i++) 
				prve = prve.sucet(poleCisel[i]);
			return prve;
		}
	}
	public static void main(String[] args) {
		CeleCislo[] mojeCisla = new CeleCislo[]{
				new Binarne("0b1010"),			// 0000 1010
				new Sestnastkove("0xFF"),		// 1111 1111
				new Osmickove("077"),			// 0011 1111
				new Desiatkove("1024")      // 100 0000 0000
		};									// -------------
		for(CeleCislo c : mojeCisla)        // 101 0100 1000
			System.out.println(c + ", \tdoDesiatkovej(" + c.doDesiatkovej() + ")");
		System.out.println("a ich sucet je " + sucet(mojeCisla));
		
		System.out.println("druhy pokus " + sucet(
				new CeleCislo[]{
						new Binarne("0b10000000000"),
						new Desiatkove("-1024")}));
		
		System.out.println("treti pokus " + sucet(
				new CeleCislo[]{
						new Binarne("0b10000000000"),
						new NaN(),
						new Desiatkove("-1024")}));
	}
}
