
public class Words {
	public static int[] pocetPismen(String s){
		
		int[] res= new int['z'-'a'+1];
		String ss= s.toLowerCase();
		for(int i=0; i<s.length();i++){
			if(Character.isLetter(ss.charAt(i))){
				res[ss.charAt(i)-'a']+=1;
			}
		}
		return res;
	}
	
	public static void main(String agrs[]){
		String s = "dfas gdjkldkHDFSKLJI";
		int[] res = pocetPismen(s);
		for(int i = 'a'; i <= 'z'; i++){
			System.out.println((char)i + ": "+ res[i - 'a']);
		}
	}
}
