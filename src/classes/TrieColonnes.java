package classes;
import java.util.Comparator;

/**
 * @author Singer Jules
 *	Cette classe permet de trier une liste d'objet Colonne a l'aide de l'interface Comparator
 */
public class TrieColonnes implements Comparator<Colonne>{

	/**
	 * compare(Colonne, Colonne) : compare deux colonnes par rapport a leurs nombre de jetons.
	 * @param c1 Colonne 1 
	 * @param c2 Colonne 2
	 * @return un entier positif si le nbre de jetons de c1 est superieur au nbre de jetons de c2, et un entier negatif sinon (quand c1 == c2 return entier negatif pour trier en fonction du numero de la colonne))
	 */
	public int compare(Colonne c1, Colonne c2) {
		int resCompare = Integer.compare(c1.getNbJeton(), c2.getNbJeton());		
		if(resCompare == 0) {
			resCompare = -1; // on simule que la 2eme colonne a plus de jeton pour mettre la 1ere colonne avant.
		}
		return resCompare; 
	}
}
