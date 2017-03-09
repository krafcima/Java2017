
public class Pascal {
	public static int[][] triangle(int N){
		int [][] T = new int [N][];
		for( int i = 0; i < N; i++){
			T[i] = new int[i+1];
			for(int j = 0; j <= i; j++){
				if(i == 0 || j==0 || i == j)
					T[i][j] = 1;
				else
					T[i][j] = T[i-1][j-1]+T[i-1][j];
			}
		}
		return T;
	}
	public static void main(String[] args) {
		triangle(10);

	}

}
