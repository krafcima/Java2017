
public class Main {

	public static void main(String[] args) {
	/*	Matica m1 = new Matica(new double[][]{{1,2,3},{2,3,4},{4,5,6}});
		Matica m2 = new Matica(new double[][]{{1,1,1},{1,1,1},{1,1,1}});
		System.out.println(m1);
		System.out.println(m2);
		Matica m3 = m1.plus(m2);
		System.out.println("m3 = \n" + m3);
		System.out.println("m1 = \n" + m1);
		System.out.println("m2 = \n" + m2);*/
		
		Polynom p1 = new Sucet(new Sucin(new Premenna("x"), new Premenna("x")), new Konstanta(1) ).simplify();
		System.out.println(p1 + "..." + p1.valueAt(new String[]{"x"}, new double[]{5})); // 26
		Polynom p2 = p1.derive("x").simplify(); // 2*x
		System.out.println(p2 + "..." +p2.valueAt(new String[]{"x"}, new double[]{3})); // 6
	}

}
