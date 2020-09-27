package classes;

/**
 * @author Singer Jules
 * Cette classe consiste a representer le joueur2 (herite de joueur) 
 *
 */
@SuppressWarnings("serial")
public class Joueur2 extends Joueur {
	
	/**
	 * j2 : cette attribut est un Jeton static representant un rond, c'est le symbole du joueur2 lors de la partie 
	 */
	public final static Jeton j2 = new Jeton("O");

	/**
	 * Joueur2(String) : constructeur initialisant un Joueur2 avec un nom.
	 * @param n nom du joueur
	 */
	public Joueur2(String n) {
		super(n);
	}
	
	/**
	 * ajouter(int, Grille) : ajoute un Jeton "O" sur une colonne dans une grille
	 * @param c numero de la colonne dont on ajoute le Jeton
	 * @param g Grille dont on ajoute le Jeton
	 */
	public void ajouter(int c,Grille g) {
		g.ajouterUnJeton(c,j2);
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'un Joueur de type Joueur2
	 */
	public String toString() {
		String res = super.toString() + "(Joueur2)";  
		return res;
	}

	
	
	
}
