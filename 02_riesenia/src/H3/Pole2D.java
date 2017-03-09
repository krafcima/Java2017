
public class Pole2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[][]= {{"yes"},{""},{"n"},{"NO", null}};
		System.out.println(pocet(a));

	}
	public static int pocet(String[][] a){
		int p = 0;
		if(a != null){
		for(int i=0;i<a.length;i++){
			if(a[i] == null){
				continue;
			}
			for(int j=0;j<a[i].length;j++){
				if(a[i][j] != null){
					if(a[i][j].toLowerCase().contains("yes") ||
						a[i][j].toLowerCase().contains("no")){
						p++;
				}}
			}
		}}
		return p;
	}

}
