public class Sestnastkove extends CeleCislo {
	private String zapis;
	@Override
	public String toString() {
		return "Sestnastkove [zapis=" + zapis + "]";
	}
	public Sestnastkove(String zapis) {
		this.zapis = zapis;
	}
	public Sestnastkove(int n) {
		zapis = "0x" +Integer.toHexString(n);
	}
	//------------------------------------------------------ dopisujte odtialto nizsie
	public Integer	doDesiatkovej() {
		return Integer.valueOf(zapis.substring(2), 16);
	}
}
