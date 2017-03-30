import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import LISTTestScoring.LISTTestScoring;

public class TestBVSTree {
	private static LISTTestScoring scoring = null;

	@BeforeClass
	public static void initScoring() {
		scoring = new LISTTestScoring();
		scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
	}

	@Test
	public void testInsertFind() {
        BVSTree<Integer> s = new BVSTree<Integer>();
        Random r = new Random();
        for(int i=0; i<111; i++) {
          Integer q = r.nextInt(100);
          s.insert(q);
          assertEquals("v strome " + s + " som hladal prvok " + q + " a mal tam byt a nebol", true, s.find(q));
        }
        scoring.updateScore("lang:common_list_test_scoring_name",20);	
	}
	@Test
	public void testInsertDeleteFind() {
        BVSTree<Integer> s = new BVSTree<Integer>();
        Random r = new Random();
        for(int i=0; i<111; i++) {
          Integer q = r.nextInt(100);
          s.insert(q);
          s.delete(q);
          assertEquals("v strome " + s + " som hladal prvok " + q + " a NEmal tam byt a nebol", false, s.find(q));
        }
        scoring.updateScore("lang:common_list_test_scoring_name",20);	
	}
	@Test
	public void testInsertHeight() {
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        assertEquals("strom " + s + " mal mat vysku 0", 0, s.height());
		}
		{
        BVSTree<Integer> s = new BVSTree<Integer>();
        s.insert(4);
        s.insert(2);
        s.insert(6);
        s.insert(1);
        s.insert(3);
        s.insert(5);
        s.insert(7);
        assertEquals("strom " + s + " mal mat vysku 3", 3, s.height());
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(4);
	        s.insert(2);
	        s.insert(6);
	        s.insert(1);
	        s.insert(3);
	        s.insert(5);
	        s.insert(7);
	        s.insert(0);
	        assertEquals("strom " + s + " mal mat vysku 4", 4, s.height());
			}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(4);
	        s.insert(2);
	        s.insert(6);
	        s.insert(1);
	        s.insert(3);
	        s.insert(5);
	        s.insert(7);
	        s.insert(0);
	        s.insert(0);
	        s.insert(11);
	        assertEquals("strom " + s + " mal mat vysku 4", 4, s.height());
			}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(4);
	        s.insert(2);
	        s.insert(6);
	        s.insert(1);
	        s.insert(3);
	        s.insert(5);
	        s.insert(7);
	        s.insert(0);
	        s.insert(0);
	        s.insert(11);
	        s.delete(0);
	        s.delete(11);
	        assertEquals("strom " + s + " mal mat vysku 3", 3, s.height());
			}
        scoring.updateScore("lang:common_list_test_scoring_name",20);	
	}
	@Test
	public void testListSize() {
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        assertEquals("strom " + s + " mal mat toList null", null, s.toList());
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(4);
	        s.insert(2);
	        s.insert(6);
	        s.insert(1);
	        s.insert(3);
	        s.insert(5);
	        s.insert(7);
	        assertEquals("strom " + s + " mal toList dlzky 7", 7, s.toList().size());
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        Random r = new Random();
	        int count = 0;
	        for(int i=0; i<1111; i++) {
	          Integer q = r.nextInt(100);
	          if (s.find(q))
	        	  continue;
	          count++;
	          s.insert(q);
	        }
	        assertEquals("strom " + s + " mal toList dlzky "+count, count, s.toList().size());
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(-1);
	        Random r = new Random();
	        for(int i=0; i<11; i++) {
	          Integer q = r.nextInt(100);
	          s.insert(q);
	        }
	        System.out.println(s);
	        for (Integer n : s.toList()) {
	        	s.delete(n);
	        }
	        System.out.println(s);
	          assertEquals("strom " + s + " mal mat toList null", null, s.toList());
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        Random r = new Random();
	        for(int i=0; i<11; i++) {
	          Integer q = r.nextInt(100);
	          s.insert(q);
	        }
	        System.out.println(s);
	        for (Integer n : s.toList()) {
	        	s.delete(n);
	        }
	        System.out.println(s);
	        assertEquals("strom " + s + " mal mat toList null", null, s.toList());
		}
		
        scoring.updateScore("lang:common_list_test_scoring_name",20);	
	}
	
	@Test
	public void testArraySize() {
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        assertEquals("strom " + s + " mal mat toArray null", null, s.toArray(new Integer[]{}));
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(4);
	        s.insert(2);
	        s.insert(6);
	        s.insert(1);
	        s.insert(3);
	        s.insert(5);
	        s.insert(7);
	        assertEquals("strom " + s + " mal mat toArray dlzky 7", 7, s.toArray(new Integer[]{}).length);
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        Random r = new Random();
	        int count = 0;
	        for(int i=0; i<1111; i++) {
	          Integer q = r.nextInt(100);
	          if (s.find(q))
	        	  continue;
	          count++;
	          s.insert(q);
	        }
	        assertEquals("strom " + s + " mal mat toArray dlzky "+count, count, s.toArray(new Integer[]{}).length);
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        s.insert(-1);
	        Random r = new Random();
	        for(int i=0; i<11; i++) {
	          Integer q = r.nextInt(100);
	          s.insert(q);
	        }
	        System.out.println(s);
	        for (Integer n : s.toList()) {
	        	s.delete(n);
	        }
	        System.out.println(s);
	          assertEquals("strom " + s + " mal mat toArray null", null, s.toArray(new Integer[]{}));
		}
		{
	        BVSTree<Integer> s = new BVSTree<Integer>();
	        Random r = new Random();
	        for(int i=0; i<11; i++) {
	          Integer q = r.nextInt(100);
	          s.insert(q);
	        }
	        System.out.println(s);
	        for (Integer n : s.toList()) {
	        	s.delete(n);
	        }
	        System.out.println(s);
	        assertEquals("strom " + s + " al mat toArray null", null, s.toArray(new Integer[]{}));
		}
		
        scoring.updateScore("lang:common_list_test_scoring_name",20);	
	}
}
