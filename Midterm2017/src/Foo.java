public class Foo {

	public static int foo(int a, int b) {
		if (a == 0)
			return b;
		else {
			int c = a % 2;
			return 2 * foo(a / 2, b) + c;
		}
	}
	
	public static int myfoo(int a, int b) {
		String res = ((b>0)?Integer.toBinaryString(b):"")	
					+ 
					((a>0)?Integer.toBinaryString(a):"");
		return (res.length() == 0) ? 0:Integer.parseInt(res, 2);
	}

	public static int goo(int a, int b) {
		if ((a | b) == 0)
			return 0;
		else if (a == 0)
			return goo(b, a);
		else
			return (goo(a >> 1, b) << 1) + (a&1);
	}

	public static void main(String[] args) {
		System.out.println(foo(5, 6));
		System.out.println(foo(6, 5));
		System.out.println(foo(7, 7));
		System.out.println(foo(7, 31));
		for (int a = 0; a < 1000; a++)
			for (int b = 0; b < 1000; b++) {
				if (foo(a,b) != goo(a, b))
					System.out.println(foo(a,b) == goo(a, b));
				if (foo(a,b) != myfoo(a,b))
					System.out.println(a + ", "+ b);
			}
	}
}
