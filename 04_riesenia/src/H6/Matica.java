package H6;
import java.util.Arrays;

public class Matica {

	private double[][] _matica;

	public Matica(int size) {
		if (size > 0) {
			_matica = new double[size][size];
			for (int i = 0; i < _matica.length; i++) {
				_matica[i][i] = 1.0;
			}
		}
	}

	public Matica(int r, int s) {
		if (r > 0 && s > 0) {
			_matica = new double[r][s];
		}
	}

	public double hodnota(int r, int s) {
		if(_matica.length<=r || r<0){
			throw new RuntimeException("Bad index");
		}
		if(_matica[r].length<=s || s<0){
			throw new RuntimeException("Bad index");
		}
		return _matica[r][s];
	}

	public Matica plus(Matica m) {
		if (_matica.length != m._matica.length) {
			return null;
		}

		if (_matica.length == 0 || _matica[0].length != m._matica[0].length) {
			return null;
		}

		Matica m2 = new Matica(_matica.length, _matica[0].length);

		for (int i = 0; i < _matica.length; i++) {
			for (int j = 0; j < _matica[0].length; j++) {
				m2._matica[i][j] = _matica[i][j] + m._matica[i][j];
			}
		}

		return m2;
	}

	public Matica krat(Matica m){
		if(_matica[0].length != m._matica.length)	return null;
		Matica newm = new Matica(_matica.length,m._matica[0].length);
		for(int i = 0; i < _matica.length; i++){
			for(int j = 0; j < m._matica[0].length; j++){
				for(int k = 0; k < m._matica.length; k++){
					newm._matica[i][j] += _matica[i][k] * m._matica[k][j];
				}
			}
		}
		return newm;
	}

	public Matica transponuj(){
		Matica newm = new Matica(_matica[0].length,_matica.length);

		for(int i = 0; i < _matica.length; i++){
			for(int j = 0; j < _matica[0].length; j++){
				newm._matica[j][i] = _matica[i][j];
			}
		}
		return newm;
	}

	public double determinant(){
		if(_matica[0].length != _matica.length){
			throw new RuntimeException("Nie je stvorec");
		}
		if(_matica.length == 2){
			// NEDOROBENE
		}
		else {
			// NEDOROBENE
		}

		return 00000;
	}

	private Matica copy(int r, int s){
		Matica newm = new Matica(_matica.length-1,_matica[0].length-1);
		for(int i = 0; i < newm._matica.length; i++){
			for(int j = 0; j < newm._matica[0].length; j++){
				if(r > i && s > j){
					newm._matica[i][j] = _matica[i][j];
				}
				// NEDOROBENE
				return null;
			}
		}
		return null;// NEDOROBENE
	}

	public Matica(double[][] matica) {
		if (matica == null) {
			return;
		}
		_matica = new double[matica.length][];
		for (int i = 0; i < matica.length; i++) {
			_matica[i] = new double[matica[i].length];
			System.arraycopy(matica[i], 0, _matica[i], 0, matica[i].length);
		}
	}

	public String toString() {
		String res = new String("");
		for (double[] riadok: _matica) {
			res += Arrays.toString(riadok) + "\n";
		}
		return res;
	}

	public static void main(String[] args) {
		double[][] mat = {{1.0, 2.0},
						  {3.0, 4.0}};
		double[][] mat1 = {{3.0, -1.0, 0.0},
				  			{2.0, 4.0, 4.0}};
		double[][] mat2 = {{0.0, 1.0},
				  			{2.0, -3.0},
							{-4.0, -5.0}};
		System.out.println(new Matica(mat));
		//System.out.println(new Matica(5));
		//System.out.println(new Matica(5).hodnota(1, 1));
		//System.out.println(new Matica(5).hodnota(5, 5));
		Matica m1 = new Matica(mat1);
		Matica m2 = new Matica(mat2);
		System.out.println(m1.krat(m2));

		System.out.println(m1.krat(m2).transponuj());
		System.out.println(m1.transponuj());
	}

}

