public class Binarne extends CeleCislo {
	private String zapis;
	@Override
	public String toString() {
		return "Binarne [zapis=" + zapis + "]";
	}
	public Binarne(String zapis) {
		this.zapis = zapis;
	}
	public Binarne(int n) {
		zapis = "0b" + Integer.toBinaryString(n);
	}
	//------------------------------------------------------ dopisujte odtialto nizsie
	public Integer doDesiatkovej() {
		return Integer.valueOf(zapis.substring(2), 2);
	}
}
