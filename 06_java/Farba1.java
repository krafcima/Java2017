public enum Farba1 { 
	Gula("gula"), 			// volanie kon�truktora
	Zalud("zelen"),
	Srdce("srdce"), 
	Zelen("zelen");
	
	private String meno;		// lok�lna premenn�
	
	Farba1 (String s) {		// kon�truktor
		meno = s;
	}
	public String toString() {	// reprezent�cia objektu ako re�azec
		return meno;
	}
};


