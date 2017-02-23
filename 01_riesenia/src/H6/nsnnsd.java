
public class nsnnsd {

	public static int nsd(int a, int b){
		int pom;

		while(b != 0){
			pom = b;
			b = a%b;
			a = pom;
		}
		return a;

	}

	public static int nsn(int a, int b){
		return (a*b)/nsd(a,b);

	}

	public static void main(String[] args) {
		System.out.println(nsd(50, 26));
		System.out.println(nsn(50, 26));
	}
}

