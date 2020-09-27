package classes;
import java.io.Serializable;

/**
 * @author Singer Jules
 * Cette classe abstraite a pour but de representer un joueur representer par son nom
 *
 */
@SuppressWarnings("serial")
public abstract class Joueur implements Serializable {
	/*
	 *  nom : nom du joueur
	 */
	private String nom;
	
	/**
	 * Joueur(String) : constructeur initialisant un Joueur avec un nom.
	 * @param n nom du joueur
	 */
	public Joueur(String n) {
		this.nom = n;
	}

	/**
	 * ajouter(int c, Grille g) : permet d'ajouter un objet Jeton dans une colonne a une grille. 
	 * Cette methode est abstraite et sera defini dans les classes l'implémentant.
	 * @param c numero de la colonne ou l'on ajoute
	 * @param g grille ou l'on ajoute
	 */
	public abstract void ajouter(int c, Grille g) ;

	/**
	 * getNom() : permet de recuperer le nom du joueur 
 	 * @return le nom du joueur 
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * @param j : joueur comparé avec l'objet courant
	 * @return true si les attributs des joueurs sont identiques (leurs pseudonyme)
	 */
	public boolean equals(Joueur j) {
		return this.nom == j.nom;
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'un joueur 
	 */
	public String toString() {
		return this.getNom();
	}
}
