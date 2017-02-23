
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i < 50; i++){
			System.out.println("Fib("+ i + "):" + fib2(i));
		}

	}
	public static long fib(int n){
		if(n < 2){
			return 1;
		}
		return fib(n-2) + fib(n-1);
	}
	public static long fib2(int n){
		long a = 0;
		long b = 1;
		for(long i = 0; i < n; i++){
			long c = a + b;
			a = b;
			b = c;
		}
		return a;
		
	}
}
