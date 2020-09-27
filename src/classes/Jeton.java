package classes;

import java.io.Serializable;

/**
 * @author Singer Jules
 * Cette classe a pour but de representer un emplacement plein / une case pleine dans la grille
 * Elle implémente l'interface Emplacement
 *
 */
@SuppressWarnings("serial")
public class Jeton implements Emplacement, Serializable{
	/*
	 * piece : Valeur du Jeton(X ou O selon le joueur)
	 */
	private String piece;

	/**
	 * Jeton(String) : constructeur d'un Jeton 
	 * @param j valeur de l'emplacement  
	 */
	public Jeton(String j) {
		this.piece = j;
	}
	
	/**
	 * getEmplacement()
	 * @return l'attribut piece.
	 */
	public String getEmplacement() {
		return this.piece;
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'un Jeton
	 */
	public String toString() {
		String res = this.getEmplacement();
		return res;
	}
	
}
