public class Osmickove extends CeleCislo {
	private String zapis;
	@Override
	public String toString() {
		return "Osmickove [zapis=" + zapis + "]";
	}
	public Osmickove(String zapis) {
		this.zapis = zapis;
	}
	public Osmickove(int n) {
		zapis = "0" + Integer.toOctalString(n);
	}
	//------------------------------------------------------ dopisujte odtialto nizsie
	public Integer doDesiatkovej() {
		return Integer.valueOf(zapis.substring(1),8);
	}
}
