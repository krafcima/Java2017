
public class Gauss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sucet(2,6));
		System.out.println("Sucet cez vzorec:"+sucet2(2,6));
	}
	public static long sucet(long from, long to){
		long res = 0;
		for(long i = from; i <= to; i++){
			res += i;
		}
		return res;
	}

	public static long sucet2(long from, long to){
		long res = 0;
		res = ((from+to)*(to-from+1))/2;
		return res;
	}

}
