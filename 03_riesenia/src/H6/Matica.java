import java.util.Arrays;

public class Matica {
	double[][] pole;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] m = {{1.0,1.1,1.2},{2.0,2.1,2.2},{3.0,3.1,3.2}};
		double[][] n = {{4.0,4.1,4.2},{5.0,5.1,5.2},{6.0,6.1,6.2}};
		System.out.println(new Matica(m));
		Matica mat = new Matica(m);
		Matica mat2 = new Matica(n);
		System.out.println(mat.plus(mat2));
		double[][] m1 = {{1.0,4.0,-2.0},{3.0,0.0,-1.0}};
		double[][] m2 = {{-2.0,5.0},{1.0,-1.0},{0.0,3.0}};
		System.out.println(new Matica(m1).krat(new Matica(m2)));
		
		System.out.println(new Matica(m1).transponuj());

	}

	public Matica(double[][] m){
		pole = m;
	}

	public Matica(int r, int s){
		pole = new double[r][s];
	}

	 public Matica(int size){
		pole = new double[size][size];

		for (int i = 0; i < pole.length; i++) {
			pole[i][i] = 1;
		}
	 }

	 public String toString(){

		return Arrays.deepToString(pole);
	 }
	 public double hodnota(int r, int s){
		 return pole[r][s];
	 }
	 public Matica plus(Matica m){
		 if (m != null){
			 if(pole.length == m.pole.length && pole[0].length == m.pole[0].length){
				 Matica matica = new Matica(m.pole.length,m.pole[0].length);
				 for(int i = 0; i < m.pole.length; i++){
					 for (int j = 0; j < m.pole[i].length; j++){
						 matica.pole[i][j] = m.pole[i][j] + pole[i][j];
					 }
				 }
				 return matica;
			 }
		 }
		 return null;



	 }

	 public Matica krat(Matica m){
		 if (m != null){
			 if (m.pole.length == pole[0].length){
				 Matica matica = new Matica(pole.length,m.pole[0].length);
				 for (int i = 0; i < matica.pole.length; i++){
					 for (int j = 0; j < matica.pole[0].length; j++){
						 for (int k = 0; k < pole[0].length; k++){
							 matica.pole[i][j] += pole[i][k]*m.pole[k][j];
						 }
					 }
				 }
				 return matica;
			 }
		 }
		 return null;
	 }

	 public boolean rovnake(Matica m) {
		 return Arrays.deepEquals(pole, m.pole);
		 /*
		 if(m != null) {

			 if(m.pole.length == pole.length && m.pole[0].length == pole[0].length) {
				 for (int i = 0; i < pole.length; i++) {
					for (int j = 0; j < pole.length; j++) {
						if(m.pole[i][j] != pole[i][j]) {
							return false;
						}
					}
				}
			 } else {
			 return false;
			 }
		 } else {
		 return false;
		 }
		 return true;
		 */
	 }
	 public Matica transponuj(){
		 Matica matica = new Matica(pole[0].length,pole.length);
		 for(int i=0;i<matica.pole.length;i++){
			 for(int j=0;j<matica.pole[0].length;j++){
				 matica.pole[i][j]=pole[j][i];
			 }
		 }
		 return matica;
	 }

}
