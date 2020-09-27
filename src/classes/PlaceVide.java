package classes;

import java.io.Serializable;

/**
 * @author Singer Jules
 * Cette classe a pour but de representer un emplacement vide / une case vide dans la grille
 * Elle implémente l'interface Emplacement
 *
 */
@SuppressWarnings("serial")
public class PlaceVide implements Emplacement, Serializable {
	
	/**
	 * vide : Valeur de l'emplacement (represente par un espace)
	 */
	private String vide;
	
	/**
	 * placeVide() : constructeur vide initialisant l'attribut vide à une chaine contenant un espace
	 */
	public PlaceVide() {
		this.vide = " ";
	}
	
	/**
	 * getEmplacement()
	 * @return l'attribut vide.
	 */
	public String getEmplacement() {
		return this.vide;
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'une placeVide
	 */
	public String toString() {
		String res = this.getEmplacement();
		return res;
	}
}