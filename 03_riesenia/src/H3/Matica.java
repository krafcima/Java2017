import java.util.Arrays;

public class Matica {
	private double[][] matica; 

	Matica(double[][] m){
		matica= new double[m.length][m[0].length];
		for (int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
				matica[i][j]=m[i][j];
			}
		}
	}

	@Override
	public String toString() {
		String vysl = "";
		
		for (int i=0; i<matica.length; i++){
			for(int j=0; j<matica[i].length; j++){
				vysl+=matica[i][j];
				vysl+=" ";
			}
			vysl+="\n";
		}
		return vysl;
	}
	
	public Matica plus(Matica m){
		if (m == null) return null;
		if ((m.matica.length != this.matica.length) || (m.matica[0].length != this.matica[0].length)){
			return null;
		}
		double [][] vysl = new double[m.matica.length][m.matica[0].length];
		for (int i=0; i<matica.length; i++){
			for(int j=0; j<matica[i].length; j++){
				vysl[i][j] = this.matica[i][j] + m.matica[i][j];
			}
		}
		return new Matica(vysl);
	}
	

}
