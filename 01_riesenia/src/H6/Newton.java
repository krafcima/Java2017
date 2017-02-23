
public class Newton {
	public static void main(String[] args){
		for (int i = -100; i <= 100; i++){
			System.out.println(newton(i, 10));
		}

	}
	public static double newton(double x, int n){
		for (int i = 0; i <= n; i++){
			x = 1/x + x/2;
		}
		return x;

	}

}
