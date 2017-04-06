import java.util.ArrayList;
interface BVSTreeInterface <E extends Comparable<E>> {

	/**
	 *	find, insert, delete - klasicke operacie na binarnom vyhladavacom strome, prvky v strome sa neopakuju 
	 */
	public boolean find(E k);
    public void insert(E k);
    public void delete(E k);
    /*
     * vyska stromu
     */
    public int height();
    /*
     * akakolvek jednoznacna reprezentacia stromu (vami citatelna)
     */
    public String toString();
    /*
     * konverzia stromu do klasickeho pola, na poradi prvkov nezalezi
     */
    public E[] toArray(E[] dummy);
    /*
     * konverzia prvkov stromu do zoznamu, na poradi prvkov nezalezi
     */
    public ArrayList<E> toList();	
}
