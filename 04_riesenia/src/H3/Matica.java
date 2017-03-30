package H3;
import java.util.Arrays;

public class Matica {
	double[][] matica;

	public Matica(double[][] m){
		this.matica = new double[m.length][];
		for(int i = 0; i < m.length; i++){
			this.matica[i] = new double[m[i].length];
			this.matica[i] = Arrays.copyOf(m[i], m[i].length);
		}

	}

	public Matica(int r, int s){
		this.matica = new double[r][s];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < s; j++){
				matica[i][j] = 0;
			}
		}
	}

	public Matica(int size){
		this.matica = new double[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(i == j){
					matica[i][j] = 1;
				}
				else{
					matica[i][j] = 0;
				}

			}
		}
	}
	public String toString(){
		String vysl = "";
		for(int i = 0; i < matica.length; i++){
			for (int j = 0; j < matica[i].length; j++){
				vysl += matica[i][j] + " ";
			}
			vysl += "\n";
		}
		return vysl;
	}
	public double hodnota(int r, int s){
		return matica[r][s];
	}

	public Matica plus(Matica m) {
		Matica n = new Matica(m.matica.length,m.matica[0].length);
		if (this.matica.length!=m.matica.length && this.matica[0].length!=m.matica[0].length ) {
			return null;
		}
		for (int i=0;i<this.matica.length;i++) {
			for (int j=0;j<this.matica[i].length;j++) {
				n.matica[i][j] = this.matica[i][j] + m.matica[i][j];
			}
		}
		return n;
	}

	public Matica krat(Matica m) {
		Matica n = new Matica(this.matica.length,m.matica[0].length);
		if (this.matica[0].length!=m.matica.length) {
			return null;
		}
		for (int i=0;i<this.matica.length;i++) {
			for (int j=0;j<m.matica[0].length;j++) {
				n.matica[i][j] = 0;
				for (int k=0;k<this.matica.length;k++) {
					n.matica[i][j] += this.matica[i][k]*m.matica[k][j];
				}
			}
		}
		return n;
	}

	public boolean rovnake(Matica m) {
		if ( (matica.length != m.matica.length) ||
			 (matica[0].length != m.matica[0].length) ) {
			return false;
		}
		for (int row = 0; row < matica.length; row++) {
			for (int col = 0; col < matica[0].length; col++) {
				if (matica[row][col] != m.matica[row][col]) {
					return false;
				}
			}
		}
		return true;
	}

	public Matica transponuj() {
		Matica resMatrix = new Matica(matica[0].length, matica.length);

		for (int row = 0; row < matica.length; row++) {
			for (int col = 0; col < matica[0].length; col++) {
				resMatrix.matica[col][row] = matica[row][col];
			}
		}
		return resMatrix;
	}

/*	
	public double determinant() {
		// here ya go. :)
	}
*/

	public static void main(String[] args) {
		double[][] A = new double[][]{
			{1, 2, 5},
			{3, 4, 6}
		};

		Matica M = new Matica(A);
		Matica N = new Matica(3);

		System.out.println(M.krat(N).toString());


		System.out.println("original:\n" + M.toString());
		System.out.println("transposed:\n" + M.transponuj());
	}
}
