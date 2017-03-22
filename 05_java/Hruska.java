public class Hruska implements Cloneable {
    @Override
	protected Object clone()  {
    	try {
    	 Hruska clone=(Hruska)super.clone();
   	     return clone;
    	} catch (Exception e) {
    		return null;
    	}
   	 }
}