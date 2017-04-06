package H3;

public class Operacia extends Vyraz{

	String operacia;
	Vyraz lo,po;

	public Operacia(String op, Vyraz lo, Vyraz po){
		this.operacia = op;
		this.lo = lo;
		this.po = po;
	}

	@Override
	public double vyhodnot() {
		double vyslLavy = lo.vyhodnot();
		double vyslPravy = po.vyhodnot();
		switch(operacia) {
		  case "+":
			  return (vyslLavy + vyslPravy);
		  case "-":
			  return (vyslLavy - vyslPravy);
		  case "*":
			  return (vyslLavy * vyslPravy);
		  case "/":
			  return (vyslLavy / vyslPravy);
		  default:
			  throw new RuntimeException();
		}
	}


	@Override
	public String toString() {
		String a = lo.toString();
		String b = po.toString();

		return "(" + a + operacia + b + ")";
	}

}
