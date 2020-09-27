package classes;
import java.io.Serializable;
import java.util.*;

/**
 * @author Singer Jules
 * Cette classe consiste a representer une Colonne de la grille
 */
@SuppressWarnings("serial")
public class Colonne implements Serializable {
	/*
	 * cases : represente la liste d'emplacements, Jeton et PlaceVide, de la colonne. (=ce que contient la colonne)
	 */
	private List<Emplacement> cases;
	
	/*
	 * nbJetons : represente le nombre de jeton qu'une colonne possede
	 */
	private int nbJetons;
	
	/**
	 * Colonne() : Constructeur vide qui initialise les attributs d'un objet Colonne
	 */
	public Colonne() {
		this.cases = new ArrayList<Emplacement>();
		this.nbJetons = 0;
		this.init();
	}

	/**
	 * getCases() : permet de recuperer la liste des elements de la colonne (les emplacements)
	 * @return l'attribut cases
	 */
	public List<Emplacement> getCases() {
		return cases;
	}
	
	
	/**
	 * getNbJetons() : permet de le nombre d'objet de la classe Jeton de la colonne (et non plus les emplacements)
	 * @return l'attribut nbJetons
	 */
	public int getNbJeton() {
		return this.nbJetons;
	}
		
	/**
	 * ajouterJeton(Jeton) : ajoute un jeton a la colonne associée. Met aussi a jour l'attribut nbJetons en l'incrémentant
	 * @param j Jeton ajouté
	 */
	public void ajouterJeton(Jeton j) {
		boolean ajoute = false;
		int i = 0;
		while(!ajoute) {
			if(this.cases.get(i) instanceof PlaceVide) {
				this.cases.set(i,j);
				ajoute =true;
			}
			i++;
		}
		this.nbJetons++;
	}
	
	public void enleverJeton() {
		this.nbJetons--;
	}
	
	/**
	 * init() : initialise la liste d'emplacement (l'attribut cases) avec des objets PlaceVide.
	 */
	public void init() {
		this.cases.add(new PlaceVide());
	}
	
	/**
	 * toString()
	 * @return l'affichage formaté d'une colonne
	 */
	public String toString() {
		String res = "";
		for(int i = 0; i< this.cases.size(); i++) {
			 res += this.cases.get(i).toString(); 
		}
		
		return res;
	}	
}
