package classes;

/**
 * @author Singer Jules
 *
 * Cette interfaçe consiste a représenter une case / un emplacement dans la grille du jeu
 */
public interface Emplacement  {
	
	/**
	 * @return la valeur de l'emplacement.
	 */
	public String getEmplacement();
	
	/**
	 * @return l'affichage formaté d'un emplacement
	 */
	public String toString();
}
