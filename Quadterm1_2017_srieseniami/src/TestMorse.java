import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import LISTTestScoring.LISTTestScoring;

public class TestMorse {
	private static LISTTestScoring scoring = null;

	@BeforeClass
	public static void initScoring() {
		scoring = new LISTTestScoring();
		scoring.setScore("lang:common_list_test_scoring_name", 0, 100);  
	}

	@Test	
	public void testKoduj() {
		assertEquals("koduj(\"SOS\")", "... --- ...", Morse.koduj("SOS"));
		assertEquals("koduj(\"S O S\")", "... --- ...", Morse.koduj("S O S"));
		assertEquals("koduj(\"S O S SOS SO S\")", "... --- ... ... --- ... ... --- ...", Morse.koduj("S O S SOS SO    S"));
		assertEquals("koduj(\"MAYDAY\")", "-- .- -.-- -.. .- -.--", Morse.koduj("MAYDAY"));
		assertEquals("koduj(\" CQDCQDS OSDEMGYMGYREQUIRIME DIATASISTA NCPOSITION \")", "-.-. --.- -.. -.-. --.- -.. ... --- ... -.. . -- --. -.-- -- --. -.-- .-. . --.- ..- .. .-. .. -- . -.. .. .- - .- ... .. ... - .- -. -.-. .--. --- ... .. - .. --- -.", Morse.koduj(" CQDCQDS OSDEMGYMGYREQUIRIME DIATASISTA NCPOSITION "));		
		assertEquals("koduj(\"SOSSOSCQDCQD TITANIC\")", "... --- ... ... --- ... -.-. --.- -.. -.-. --.- -.. - .. - .- -. .. -.-.", Morse.koduj("SOSSOSCQDCQD TITANIC"));		
		assertEquals("koduj(\"TO BE OR NOT TO BE THAT IS THE QUESTION\")", "- --- -... . --- .-. -. --- - - --- -... . - .... .- - .. ... - .... . --.- ..- . ... - .. --- -.", Morse.koduj("TO BE OR NOT TO BE THAT IS THE QUESTION"));
		scoring.updateScore("lang:common_list_test_scoring_name", 100/6);
	}
	
	@Test	
	public void test_Dekoduj() {
		assertEquals("dekoduj(\"... --- ...\")", "SOS", Morse.dekoduj("... --- ...").trim().toUpperCase());
		assertEquals("dekoduj(\"-- .- -.-- -.. .- -.--\")", "MAYDAY", Morse.dekoduj("-- .- -.-- -.. .- -.--").trim().toUpperCase());
		assertEquals("dekoduj(\".--- .- ...- .-\")", "JAVA", Morse.dekoduj("  .---   .-  ...-    .-   ").trim().toUpperCase());
		assertEquals("dekoduj(\"  ----\")", null, Morse.dekoduj("  ----"));
		assertEquals("dekoduj(\"  ----\")", null, Morse.dekoduj("...  ---. "));
		assertEquals("dekoduj(\"MORSECODE\")","MORSECODE", Morse.dekoduj("-- --- .-. ... .   -.-. --- -.. .").trim().toUpperCase());
		assertEquals("dekoduj(\"CQDCQDSOSDEMGYMGYREQUIRIMEDIATASISTANCPOSITION\")","CQDCQDSOSDEMGYMGYREQUIRIMEDIATASISTANCPOSITION", Morse.dekoduj("-.-. --.- -..   -.-. --.- -..   ... --- ...   -.. .   -- --. -.--   -- --. -.--   .-. . --.- ..- .. .-.   .. -- . -.. .. .- -   .- ... .. ... - .- -. -.-.   .--. --- ... .. - .. --- -.").trim().toUpperCase());
		assertEquals("dekoduj(\"SOSSOSCQDCQDTITANIC\")","SOSSOSCQDCQDTITANIC", Morse.dekoduj("... --- ...   ... --- ...   -.-. --.- -..   -.-. --.- -..   - .. - .- -. .. -.-.").trim().toUpperCase());
		assertEquals("dekoduj(\"TOBEORNOTTOBETHATISTHEQUESTION\")", "TOBEORNOTTOBETHATISTHEQUESTION", Morse.dekoduj("- --- -... . --- .-. -. --- - - --- -... . - .... .- - .. ... - .... . --.- ..- . ... - .. --- -.").trim().toUpperCase());
		scoring.updateScore("lang:common_list_test_scoring_name", 200/6);
	}
	
	@Test(timeout=10000)	
	public void test_DekodujVsetky() {
		assertEquals("dekodujVsetky(\"..\").length()", 2, Morse.dekodujVsetky("..").length);
		assertEquals("dekodujVsetky(\".-\").length()", 2, Morse.dekodujVsetky(".-").length);
		assertEquals("dekodujVsetky(\".-.\").length()", 4, Morse.dekodujVsetky(".-.").length);
		assertEquals("dekodujVsetky(\".--\").length()", 4, Morse.dekodujVsetky(".--").length);
		assertEquals("dekodujVsetky(\"...\").length()", 4, Morse.dekodujVsetky("...").length);
		assertEquals("dekodujVsetky(\"....\").length()", 8, Morse.dekodujVsetky("....").length);
		assertEquals("dekodujVsetky(\".....\").length()", 15, Morse.dekodujVsetky(".....").length);
		assertEquals("dekodujVsetky(\"...---...\").length()", 192, Morse.dekodujVsetky("...---...").length);
		assertTrue("dekodujVsetky(\"...---...\") contains SOS", Arrays.asList(Morse.dekodujVsetky("...---...")).contains("SOS"));
		assertFalse("dekodujVsetky(\"...---...\") not contains DPH", Arrays.asList(Morse.dekodujVsetky("...---...")).contains("DPH"));
		assertEquals("dekodujVsetky(\"--.--.---...--.--\").length()", 36536, Morse.dekodujVsetky("--.--.---...--.--").length);
		assertTrue("dekodujVsetky(\"--.--.---...--.--\") contains MAYDAY", Arrays.asList(Morse.dekodujVsetky("--.--.---...--.--")).contains("MAYDAY"));
		scoring.updateScore("lang:common_list_test_scoring_name", 300/6);
	}
}
