
public class StromVyrazu {

	StromVyrazu lavy;
	StromVyrazu pravy;
	boolean jeHodnota;
	char operacia;
	double cislo;
	
	StromVyrazu(String s){
		int i = 1;
		boolean prvy = true;
		
		if ((s==null)||(s.equals(""))){return;}
		if ((s.charAt(0)=='(')&&(s.charAt(s.length()-1)==')'))
			{
				s = s.substring(1, s.length()-1);
			}
		if (s.length() > 1)
		  if ((s.charAt(0)=='-')&&
			  (s.charAt(1)=='(')&&
			  (s.charAt(s.length()-1)==')'))
		{
			s = '0'+s;
		}
		//if (s.charAt(0)=='-') {s = '0'+s;}
		for (int j = 0; j < 2; j++)
		{
		  int otvorene = 0;
		  while (i<s.length())
		  {
			boolean rozbit = false;
			if (s.charAt(i)=='('){otvorene++;}
			if (s.charAt(i)==')'){otvorene--;}
			if (prvy)
			{
				if ((otvorene==0)&&
			     ((s.charAt(i)=='+')||(s.charAt(i)=='-')))
				rozbit = true;
			} else
			{
				if ((otvorene==0)&&
					     ((s.charAt(i)=='*')||(s.charAt(i)=='/')))
				 rozbit = true;
			}	
			if (rozbit){
				 operacia = s.charAt(i);
				 jeHodnota = false;
				 lavy = new StromVyrazu(s.substring(0, i));
				 pravy = new StromVyrazu(s.substring(i+1));
				 return;
				}
			i++;
		  } 
		  prvy = false;
		  i = 1;
		}
		jeHodnota = true;
		cislo = Double.parseDouble(s);
	}
	
	
	public double hodnotaVyrazu(){
		if (!jeHodnota){
			switch (operacia){
			case '+': return (lavy.hodnotaVyrazu()+pravy.hodnotaVyrazu());
			case '-': return (lavy.hodnotaVyrazu()-pravy.hodnotaVyrazu());
			case '*': return (lavy.hodnotaVyrazu()*pravy.hodnotaVyrazu());
			case '/': return (lavy.hodnotaVyrazu()/pravy.hodnotaVyrazu());
			}
		}
			else
			{
				return cislo;
			}
		return 0;
	}
	
	public static void main(String[] args) 
	{
	   StromVyrazu strom = new StromVyrazu("2+(-(-3-5))");
	   System.out.println(strom.hodnotaVyrazu());
	}

}
