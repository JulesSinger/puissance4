package classes;

/**
 * @author Singer Jules
 *
 * Cette interfa�e consiste a repr�senter une case / un emplacement dans la grille du jeu
 */
public interface Emplacement  {
	
	/**
	 * @return la valeur de l'emplacement.
	 */
	public String getEmplacement();
	
	/**
	 * @return l'affichage format� d'un emplacement
	 */
	public String toString();
}
