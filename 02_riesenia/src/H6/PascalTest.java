import static org.junit.Assert.*;

import org.junit.Test;

public class PascalTest {

	@Test
	public void test() {
		int[][] t = Pascal.triangle(5);
		assertTrue("asi to vratilo null", (t !=null));
	}

	@Test
	public void testPrvehoRiadklu() {
		int[][] t = Pascal.triangle(5);
		assertEquals("asi vrchol nie je 1", 1, t[0][0]);
	}
	
	@Test
	public void testNaRiadky() {
		for (int i = 0; i < 20; i++) {
			int[][] t = Pascal.triangle(i);
			assertEquals("Test na i =" + i, i, t.length);
			for (int j = 0; j < t.length; j++) {
				assertEquals("Test na j" + j, j+1, t[j].length);
			}
		}	
	}
	
	@Test
	public void testNaJednotky() {
		for (int i = 0; i < 20; i++) {
			int[][] t = Pascal.triangle(i);
			for (int j = 0; j < t.length; j++) {
				assertEquals("Test Jednotky na zaciatku", 1, t[j][0]);
				assertEquals("Test Jednotky na konci", 1, t[j][j]);
			}
		}
	}

}
