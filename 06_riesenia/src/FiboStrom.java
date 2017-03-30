/**
 * Fibonacciho strom
 * @author PB
 */
public class FiboStrom {
	
		FiboStrom left, right;
		Long value;
		public FiboStrom() {
			left = right = null;
			value = null;
		}
		public FiboStrom(long value) {
			left = right = null;
			this.value = value;
		}
		public FiboStrom(FiboStrom left, FiboStrom right) {
			this.left = left; this.right = right;
			value = left.value+right.value;
		}
		public String toString() {
			return "("+((left!=null)?left:"")+
			((value!=null)?value:"")+ 
			((right!=null)?right:"")+")";
		}
		static FiboStrom generujStrom(int n) {
			return
				(n < 3)?new FiboStrom(1):
						new FiboStrom(generujStrom(n-1), generujStrom(n-2));
			}
		
	public static void main(String[] args) {
		System.out.println(generujStrom(6));
	}
}
