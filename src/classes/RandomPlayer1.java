package classes;

/**
 * @author Singer Jules
 * Cette classe consiste a representer un ordinateur
 *
 */
@SuppressWarnings("serial")
public class RandomPlayer1 extends Joueur{

	/**
	 * o1 : cette attribut est un Jeton static representant un H, c'est le symbole du RandomPlayer1 lors de la partie 
	 */
	public final static Jeton o1 = new Jeton("H");
	
	/**
	 * Joueur1(String) : constructeur initialisant un RandomPlayer1 avec un nom.
	 */
	public RandomPlayer1() {
		super("RandomPlayer1");
	}
	
	/**
	 * ajouter(int, Grille) : ajoute un Jeton "H" sur une colonne dans une grille
	 * @param c numero de la colonne dont on ajoute le Jeton
	 * @param g Grille dont on ajoute le Jeton
	 */
	public void ajouter(int c,Grille g) {
		g.ajouterUnJeton(c,o1);
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'un Joueur de type RandomPlayer1
	 */
	public String toString() {
		
		return super.toString();  
	}
}
