import java.util.ArrayList;
import java.util.Arrays;

public class Morse {
	static String[] letters = new String[255];
	static {
			letters['A'] = ".-";		
			letters['B'] = "-...";	
			letters['C'] = "-.-.";	
			letters['D'] = "-..";		
			letters['E'] = ".";		  
			letters['F'] = "..-.";	
			letters['G'] = "--.";		
			letters['H'] = "....";	
			letters['I'] = "..";		
			letters['J'] = ".---";	
			letters['K'] = "-.-";		
			letters['L'] = ".-..";	
			letters['M'] = "--";		
			letters['N'] = "-.";		
			letters['O'] = "---";		
			letters['P'] = ".--.";	
			letters['Q'] = "--.-";	
			letters['R'] = ".-.";		
			letters['S'] = "...";		
			letters['T'] = "-";		  
			letters['U'] = "..-";		
			letters['V'] = "...-";	
			letters['W'] = ".--";		
			letters['X'] = "-..-";	
			letters['Y'] = "-.--";	
			letters['Z'] = "--..";
	}      
	//------------------------------------------------------ dopisujte odtialto nizsie
	/**
	 * @param anglickaSprava - retazec pismen anglickej abecedy 'A'-'Z' a medzier
	 * @return - preklad do morseho kodu, jednotlive pismena 'A'-'Z' su oddelene jednou mezerou, vstupne medzery sa ignoruju
	 */
	public static String koduj(String anglickaSprava) {
		StringBuffer res = new StringBuffer();
		String medzera = "";
		for(int i = 0; i < anglickaSprava.length(); i++) {
			char ch = anglickaSprava.charAt(i);
			if (letters[ch] != null) {
				res.append(medzera+letters[ch]);
				medzera = " ";
			}
		}
		return res.toString();
	}
	/**
	 * dekoduje stream Morseho symbolov oddelenych aspon nejakymi medzerami
	 */
	public static String dekoduj(String sprava) {
		String[] words = sprava.trim().split(" ");
		StringBuffer res = new StringBuffer();
		for (String word : words) {
			word = word.trim();
			if (word.length() == 0)
				continue;
			boolean nasiel = false;
			for(char letter = 'A'; letter <= 'Z'; letter++) {
				if (word.equals(Morse.letters[letter])) {
					res.append(letter);
					nasiel = true;
					break;
				}
			}
			if (!nasiel) 
				return null;
		}
		return res.toString();
	}
	/**
	 * inverzny homomorfizmus - dekoduje stream Morseho symbolov neoddelenych medzerami, vsetky moznosti
	 */
	public static String[] dekodujVsetky(String sprava) {
		return decodeAllPosibs(sprava, new StringBuffer() ).toString().split(",");
	}
	private static StringBuffer decodeAllPosibs(String code, StringBuffer s) {
		if (code != null && code.length() > 0) {
			StringBuffer res = new StringBuffer();
			for (char letter = 'A'; letter <= 'Z'; letter++) 
				if (code.startsWith(Morse.letters[letter])) 
					res = res.append(decodeAllPosibs(code.substring(Morse.letters[letter].length()), new StringBuffer(s).append(letter)));
			return res;
		} else 
			return new StringBuffer(s).append(",");
	}
	//----------------------------------------- to iste riesenie pre vyznavacov ArrayListov
	public static ArrayList<String>decodeAll1(String code) {
		return decodeAllPosibs1(code, "");
	}
	private static ArrayList<String>decodeAllPosibs1(String code, String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (code != null && code.length() > 0) {
			for (char letter = 'A'; letter <= 'Z'; letter++) 
				if (code.startsWith(Morse.letters[letter])) 
					res.addAll(decodeAllPosibs1(code.substring(Morse.letters[letter].length()), s + letter));
			return res;
		} else { 
			res.add(s);
			return res;
		}
	}
}
