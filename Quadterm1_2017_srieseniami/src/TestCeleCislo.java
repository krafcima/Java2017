import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import LISTTestScoring.LISTTestScoring;

public class TestCeleCislo {
	private static LISTTestScoring scoring = null;

	@BeforeClass
	public static void initScoring() {
		scoring = new LISTTestScoring();
		scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
	}

	@Test
	public void testDoDesiatkovej() {
		assertEquals("new Binarne(\"0b1100\").doDesiatkovej()", 12, (int)(new Binarne("0b1100").doDesiatkovej()));
		assertEquals("new Sestnastkove(\"0xFF\").doDesiatkovej()", 255, (int)(new Sestnastkove("0xFF").doDesiatkovej()));
		assertEquals("new Osmickove(\"077\").doDesiatkovej()", 63, (int)(new Osmickove("077").doDesiatkovej()));
		assertEquals("new Desiatkove(\"77\").doDesiatkovej()", 77, (int)(new Desiatkove("77").doDesiatkovej()));
		assertEquals("new Desiatkove(\"-1\").doDesiatkovej()", -1, (int)(new Desiatkove("-1").doDesiatkovej()));
		assertEquals("new NaN().doDesiatkovej()", null, new NaN().doDesiatkovej());
		//-----------		
		scoring.updateScore("lang:common_list_test_scoring_name", 100/5);
	}

	@Test
	public void testGetCislo() {
		assertEquals("getCislo(\"0b1100\").doDesiatkovej()", 12, (int)(CeleCislo.getCislo("0b1100").doDesiatkovej()));
		assertEquals("getCislo(\"0xFF\").doDesiatkovej()", 255, (int)(CeleCislo.getCislo("0xFF").doDesiatkovej()));
		assertEquals("getCislo(\"077\").doDesiatkovej()", 63, (int)(CeleCislo.getCislo("077").doDesiatkovej()));
		assertEquals("getCislo(\"77\").doDesiatkovej()", 77, (int)(CeleCislo.getCislo("77").doDesiatkovej()));
		assertEquals("getCislo(\"-1\").doDesiatkovej()", -1, (int)(CeleCislo.getCislo("-1").doDesiatkovej()));
		//-----------		
		scoring.updateScore("lang:common_list_test_scoring_name", 100/5);
	}
	
	@Test
	public void testSucet() {
		assertEquals("test1 ", 265, (int)(new Binarne("0b1010").sucet(new Sestnastkove("0xFF")).doDesiatkovej())); 
		assertTrue("test1a ", new Binarne("0b1010").sucet(new Sestnastkove("0xFF")) instanceof Binarne); 

		assertEquals("test2 ", 265, (int)(new Sestnastkove("0xFF").sucet(new Binarne("0b1010")).doDesiatkovej())); 
		assertTrue("test2a ", new Sestnastkove("0xFF").sucet(new Binarne("0b1010")) instanceof Sestnastkove);
		
		assertEquals("test3 ", 318, (int)(new Sestnastkove("0xFF").sucet(new Osmickove("077")).doDesiatkovej())); 
		assertTrue("test3a ", new Sestnastkove("0xFF").sucet(new Osmickove("077")) instanceof Sestnastkove); 
		//-----------		
		scoring.updateScore("lang:common_list_test_scoring_name", 200/5);
	}

	@Test
	public void testSucetPola() {
		{
			CeleCislo[] mojeCisla = new CeleCislo[]{
	                new Binarne("0b1010"),           // 0000 1010
	                new Sestnastkove("0xFF"),        // 1111 1111
	                new Osmickove("077"),            // 0011 1111
	                new Desiatkove("1024")       // 100 0000 0000
	         };                                  // 101 0100 1000
			assertEquals("test1 ", 0b10101001000, (int)(CeleCislo.sucet(mojeCisla).doDesiatkovej())); 
			assertTrue("test1a ", CeleCislo.sucet(mojeCisla) instanceof Binarne);
		}
		{
			CeleCislo[] mojeCisla = new CeleCislo[]{
	                new Sestnastkove("0xFF"),        // 1111 1111
	                new Binarne("0b1010"),           // 0000 1010
	                new Osmickove("077"),            // 0011 1111
	                new Desiatkove("1024")       // 100 0000 0000
	         };                                  // 101 0100 1000
			assertEquals("test1 ", 0b10101001000, (int)(CeleCislo.sucet(mojeCisla).doDesiatkovej())); 
			assertTrue("test1a ", CeleCislo.sucet(mojeCisla) instanceof Sestnastkove);
		}
		{
			CeleCislo[] mojeCisla = new CeleCislo[]{
	                new Osmickove("077"),            // 0011 1111
	                new Binarne("0b1010"),           // 0000 1010
	                new Sestnastkove("0xFF"),        // 1111 1111
	                new Desiatkove("1024")       // 100 0000 0000
	         };                                  // 101 0100 1000
			assertEquals("test1 ", 0b10101001000, (int)(CeleCislo.sucet(mojeCisla).doDesiatkovej())); 
			assertTrue("test1a ", CeleCislo.sucet(mojeCisla) instanceof Osmickove);
		}
		{
			CeleCislo[] mojeCisla = new CeleCislo[]{
	                new Desiatkove("1024"),       // 100 0000 0000
	                new Binarne("0b1010"),           // 0000 1010
	                new Sestnastkove("0xFF"),        // 1111 1111
	                new Osmickove("077")            // 0011 1111
	         };                                  // 101 0100 1000
			assertEquals("test1 ", 0b10101001000, (int)(CeleCislo.sucet(mojeCisla).doDesiatkovej())); 
			assertTrue("test1a ", CeleCislo.sucet(mojeCisla) instanceof Desiatkove);
		}
		{
			CeleCislo[] mojeCisla = new CeleCislo[]{
	                new Desiatkove("1024"),       // 100 0000 0000
	                new Binarne("0b1010"),           // 0000 1010
	                new NaN(),
	                new Sestnastkove("0xFF"),        // 1111 1111
	                new Osmickove("077")            // 0011 1111
	         };                                  // 101 0100 1000
			assertEquals("test1 ", null, (CeleCislo.sucet(mojeCisla).doDesiatkovej())); 
			assertTrue("test1a ", CeleCislo.sucet(mojeCisla) instanceof NaN);
		}
		//-----------		
		scoring.updateScore("lang:common_list_test_scoring_name", 100/5);
	}
}
