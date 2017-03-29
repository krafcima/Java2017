import java.util.*;

public class HashSetDemo {
  public static void main(String[] args) {
    Set<String> s = new HashSet<String>();
    for (String a : args)
      if (!s.add(a))
        System.out.println("opakuje sa: " + a);
    System.out.println(s.size() + " rozne: " + s);
    Object[] poleObj = s.toArray();
    for(Object o:poleObj) System.out.print(o);
    
    String[] poleStr = s.toArray(new String[0]);
    for(String str:poleStr) System.out.print(str);
    } 
}


