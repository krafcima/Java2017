import static org.junit.Assert.*;

import org.junit.Test;

public class PascalTest {

	@Test
	public void testTriangle() {
		int[][] i = Pascal.triangle(-1);
		int[][] n ={};
		assertEquals(i, n);				
	}
	
	

	@Test
	public void testTriangle3() {
		int[][] i = Pascal.triangle(100000);
		int n = i.length;		
		assertEquals(n, 100000);		
	}

	@Test
	public void testTriangle4() {
		int[][] i = Pascal.triangle(0);
		int n[][] = {{}};
		assertEquals(i, n);		
	}
	@Test
	public void testTriangle5() {
		int[][] i = Pascal.triangle(0);
		int n = i.length;		
		assertEquals(n, 0);		
	}

	
	


}
