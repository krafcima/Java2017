public class Desiatkove extends CeleCislo {
	private String zapis;
	@Override
	public String toString() {
		return "Desiatkove [zapis=" + zapis + "]";
	}
	public Desiatkove(String zapis) {
		this.zapis = zapis;
	}
	public Desiatkove(int n) {
		zapis = Integer.toString(n);
	}
	//------------------------------------------------------ dopisujte odtialto nizsie
	public Integer	doDesiatkovej() {
		return Integer.valueOf(zapis);
	}
}
