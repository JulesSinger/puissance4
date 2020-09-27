package classes;
import java.io.Serializable;
import java.util.*;

import exceptions.InfinityException;

/**
 * @author Singer Jules
 * Cette classe a pour but de representer la grille du jeu.
 */
@SuppressWarnings("serial")
public class Grille implements Serializable{
	
	/**
	 * colonnes : liste d'objet Colonne.
	 */
	private List<Colonne> colonnes;
	
	/*
	 * largeurGrille : largeur de la grille.
	 */
	private int largeurGrille;
	
	/**
	 * Grille(int) : construit l colonnes dans la liste de colonne.
	 * @param l : largeur de la grille (=nombre de colonnes).
	 */
	public Grille(int l) {
		this.largeurGrille = l;
		this.colonnes = new ArrayList<Colonne>();
		
		for(int i = 0; i < l; i++) {
			this.colonnes.add(new Colonne());
		}
	
	}
	
	/**
	 * getLargeurGrille() : recupere la largeur de la grille.
	 * @return l'attribut largeurGrille.
	 */
	public int getLargeurGrille() {
		return this.largeurGrille;
	}
	
	/**
	 * getColonnes() : recupere la liste d'objet Colonne.
	 * @return l'attribut colonnes
	 */
	public List<Colonne> getColonnes() {
		return this.colonnes;
	}
	
	/**
	 * getColonnes() : recupere la liste d'objet Colonne.
	 * @param c : numero de la colonne ou l'on ajoute le jeton
	 * @param j : jeton ajouté
	 */
	public void ajouterUnJeton(int c,Jeton j) {
		Colonne col = this.colonnes.get(c-1);
		if(col.getNbJeton()==this.getHauteurMax()) {
			for(int i=0; i<this.colonnes.size(); i++) {
				this.colonnes.get(i).init();
			}
		}
		col.ajouterJeton(j);
	}
	
	/**
	 * trierColonnes() : donne une liste identique a celle de la grille mais triee par ordre decroissant de nombre de jetons et d'emplacement.
	 * @return une liste d'objet Colonne triée.
	 */
	public List<Colonne> trierColonnes() {
		
		List<Colonne> tmpColonnes = new ArrayList<Colonne>(colonnes);
		Collections.sort(tmpColonnes, new TrieColonnes());
		Collections.reverse(tmpColonnes);
		
		return tmpColonnes;

	}
	
	/**
	 * getHauteurMax() : donne la hauteur de la colonne la plus haute.
	 * @return l'entier correspondant a la hauteur maximale des colonnes.
	 */
	public int getHauteurMax() {
		List<Colonne> tmpColonnes = new ArrayList<Colonne>(this.colonnes);
		Collections.sort(tmpColonnes, new TrieColonnes());
		Collections.reverse(tmpColonnes);
		return tmpColonnes.get(0).getNbJeton();
	}
	
	
	/**
	 * afficherGrille() : affiche la grille
 	 */
	public void afficherGrille() {
		int k = 0;		
		int indexCases = this.getHauteurMax()-1;
		
		
		while(k <= indexCases) {
			
			for(int i=0; i<this.largeurGrille;i++) {
				
				System.out.print("+-");
			}
			System.out.print("+");
			System.out.println("");
			
			for(int i=0; i<this.largeurGrille;i++) {
				
				System.out.print("|" + this.getColonnes().get(i).getCases().get(indexCases));
			}
			System.out.print("|");			
			System.out.println("");
			indexCases--;
		}
	}
	
	/**
	 * moyenneRemplissage() : affiche le remplissage moyen de la grille.
	 * @throws InfinityException : Exception levé lorsque remplissage a pour valeur Infinity.
 	 */
	public void moyenneRemplissage() throws InfinityException  {
		double casesPleine=0.;
		for(int i = 0; i<this.largeurGrille;i++) { 
			
			for(int j=0; j< this.getHauteurMax();j++) {
				
				if(this.getColonnes().get(i).getCases().get(j) instanceof Jeton) {
					casesPleine++;
				}
			}
		}
		if(casesPleine ==0.0) {
			throw new InfinityException("valeur obtenue infini.");
		} else {
			double remplissage = this.largeurGrille/casesPleine;
			System.out.println(((int)(remplissage*100))/100.); // arrondi a deux chiffres après la virgule
		}	
	}	
	
	/**
	 * afficherTrieColonnes() : affiche les colonnes et leurs nombres de jetons triée par ordre décroissant.
	 */
	public void afficherTrieColonnes() {
		System.out.print("Colonnes triées par remplissage : ");
		
		List<Colonne> listePasTriee = this.getColonnes(); // liste non triée temporaire

		List<Colonne> listeTriee = this.trierColonnes(); // liste triée temporaire
		
		List<Integer> elementsAffiches = new ArrayList<Integer>(this.largeurGrille); // Liste contenant les indice de la liste qui ont deja ete affichés
		
		int indiceLTriee = 0; // indice de la liste triée
		
		boolean finBoucle = false;
		while(!(finBoucle)) {
			int indiceLPasTriee = 0; // indice de la liste non triée

			
			while(!(listePasTriee.get(indiceLPasTriee) == listeTriee.get(indiceLTriee)) ) {
				indiceLPasTriee++;
			}
			
			System.out.print(indiceLPasTriee + "(" + listeTriee.get(indiceLTriee).getNbJeton() + ") ");
			elementsAffiches.add(indiceLPasTriee);
			indiceLTriee++;
			if(elementsAffiches.size() == this.largeurGrille) {
				finBoucle = true;
			}
			
		}
		System.out.println("");
	}

}
