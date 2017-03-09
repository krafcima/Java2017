
public class Pascal {

	public static int[][] triangle(int N){
		int pole[][] = new int[N][];
		for(int i = 0; i < N; i++){
			pole[i] = new int[i+1];
			for(int j = 0; j <= i; j++){
				if(j==0){
					pole[i][j] = 1;
				}
				else if(j < i){
					pole[i][j] = pole[i-1][j-1] + pole[i-1][j];
				}
				else{
					pole[i][j] = 1;
				}
			}
		}
		return pole;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[][] = triangle(10);
		for(int i = 0; i < p.length; i++){
			for(int j = 0; j < i+1; j++){
				System.out.print(p[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
