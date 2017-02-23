
public class Cvicenie1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0;i<20;i++){
			System.out.println(i+" =\t "+ pocet_jednotiek(i));
		}
		System.out.println(nas_or(10,12));
		System.out.println(nas_or(6,4));


	}
	/**
	 * 
	 * @param n vstupne cisla
	 * @return pocet jednotiek v binarnom zapise
	 */
	public static long pocet_jednotiek(int n){
		int vysl=0;
		while (n!=0){
			if(n%2==1) vysl+=1;		
			n=n/2;
		}
		return vysl;
		
	}
	
	public static int nas_or(int a,int b){
		int vysl=0;
		int poma=0;
		int pomb=0;
		int pocet=0;
		while (a!=0 || b!=0){
			poma=a%2;
			pomb=b%2;
			if(poma+pomb>0) vysl+=1<<pocet;	
			a=a/2;
			b=b/2;
			pocet+=1;
		}
		return vysl;
		
	}

}
