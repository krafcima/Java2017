
public class Faktorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i<=20; i++){
			System.out.println("Faktorial " + i + "=" + factorial(i));
		}
	}
	
	public static long factorial(int n){
		if (n <= 1){
			return 1;
		}
		
		return n * factorial(n-1);
	}

}
