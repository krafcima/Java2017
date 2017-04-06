package dispecer;

import java.util.*;

public class GameBoard {
   Car[] cars;   
   final int SIZEX = 6, SIZEY = 6;
   
   public GameBoard() {
	  cars = new Car[6];
	  cars[0]= new HorizontalCar(this, 2, 1, 2);
	  cars[1]= new VerticalCar(this, 2, 3, 3);
	  cars[2]= new HorizontalCar(this, 3, 1, 2);
	  cars[3]= new VerticalCar(this, 3, 5, 3);
	  cars[4]= new VerticalCar(this, 4, 1, 2);
	  cars[5]= new HorizontalCar(this, 5, 2, 2);
   }
   public int inside(int x, int y) {
	   for(int i=0; i<cars.length; i++)
		   if (cars[i].inside(x,y))
			   return i;
	   return -1;
   }
   public String toString() {
	   String s = "";
	   for(int i=0; i<SIZEX; i++, s += "\n")
		   for(int a, j=0; j<SIZEY; j++)
			 if ((a=inside(i,j)) < 0)
			    s += '.';
			 else
			    s += a+1;
	   return s;
   }
  public boolean isFinal() {
	  return cars[0].x1 == 2 && cars[0].y1 == 4;
  }
  public boolean findSolution(HashSet<String> visited) {
	 //System.out.println("visited="+visited+visited.size());
	 if (isFinal())
		 return true;
		 else if (!visited.contains(toString())) {
 	     visited.add(toString());
 		 for(Car auto:cars) {
		   if (auto.left())
			   if (findSolution(visited))
				   return true;
			   else
				   auto.right();
		   if (auto.right()) 
			   if (findSolution(visited))
				   return true;
			   else
				   auto.left();
		   if (auto.up()) 
			   if (findSolution(visited))
				   return true;
			   else
				   auto.down();
		   if (auto.down()) 
			   if (findSolution(visited))
				   return true;
			   else
				   auto.up();
 		 }
	 }
 	return false;
  }
  public static void main(String[] args) {
	  GameBoard gb = new GameBoard();
	  System.out.println(gb);
	  if (gb.findSolution(new HashSet<String>()))
			 System.out.println("possible");
	  else
			 System.out.println("impossible");
  }
}
	