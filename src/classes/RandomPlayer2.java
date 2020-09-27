package classes;

/**
 * @author Singer Jules
 * Cette classe consiste a representer un ordinateur
 *
 */
@SuppressWarnings("serial")
public class RandomPlayer2 extends Joueur{

	/**
	 * o2 : cette attribut est un Jeton static representant un V, c'est le symbole du RandomPlayer2 lors de la partie 
	 */
	public final static Jeton o2 = new Jeton("V");
	
	/**
	 * Joueur1(String) : constructeur initialisant un RandomPlayer2 avec un nom.
	 */
	public RandomPlayer2() {
		super("RandomPlayer2");
	}
	
	/**
	 * ajouter(int, Grille) : ajoute un Jeton "V" sur une colonne dans une grille
	 * @param c numero de la colonne dont on ajoute le Jeton
	 * @param g Grille dont on ajoute le Jeton
	 */
	public void ajouter(int c,Grille g) {
		g.ajouterUnJeton(c,o2);
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'un Joueur de type RandomPlayer2
	 */
	public String toString() {
		
		return super.toString();  
	}
}
