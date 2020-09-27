package classes;

/**
 * @author Singer Jules
 * Cette classe consiste a representer le joueur1 (herite de joueur) 
 *
 */
@SuppressWarnings("serial")
public class Joueur1 extends Joueur {
	
	/**
	 * j1 : cette attribut est un Jeton static representant une croix, c'est le symbole du joueur1 lors de la partie 
	 */
	public final static Jeton j1 = new Jeton("X");
	
	/**
	 * Joueur1(String) : constructeur initialisant un Joueur1 avec un nom.
	 * @param n nom du joueur
	 */
	public Joueur1(String n) {
		super(n);
	}
	
	/**
	 * ajouter(int, Grille) : ajoute un Jeton "X" sur une colonne dans une grille
	 * @param c numero de la colonne dont on ajoute le Jeton
	 * @param g Grille dont on ajoute le Jeton
	 */
	public void ajouter(int c,Grille g) {
		g.ajouterUnJeton(c,j1);
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'un Joueur de type Joueur1
	 */
	public String toString() {
		String res = super.toString() + "(Joueur1)";  
		return res;
	}
	
}
