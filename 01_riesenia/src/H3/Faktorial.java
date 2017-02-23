
public class Faktorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 20; i++){
			System.out.println(i + " = \t" + factorial(i) + ", \t" + faktorial(i));
			
		}
		
		for (int i = 1; i <= 20;i++){
			System.out.println(i + "= \t" + fib(i));
		}

	}

	
	public static long factorial(int n){
		
		if (n == 0){
			return 1;
		} else {
			return n*factorial(n-1);
		}
		
		
	}
	
	public static long faktorial(int n){
		long vysl = 1;
		
		for (int i = 1; i <= n; i++){
			vysl *= i;
		}
		
		return vysl;
	}
	
	public static long fib(int n){
		long a = 0;
		long b = 1;
		for (int i = 0; i < n; i++){
			long pom = a;
			a += b;
			b = pom;			
		}
		return a;
	}
}
