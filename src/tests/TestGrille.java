package tests;
import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import java.util.ArrayList;
import java.util.List;

import classes.*;
/**
 * @author Singer Jules
 * Classe ayant pour but de tester la classe Grille
 */
public class TestGrille {
	
	/**
	 * test du constructeur
	 */
	public void test_Grille_constructeur() {
		// preparation des donnees
		Grille g = new Grille(3);
		
		// verification attributs
		assertEquals("l'attribut largeurGrille devrait etre 3",3, g.getLargeurGrille());
		assertEquals("la taille de l'attribut colonnes devrait etre 3",3, g.getColonnes().size());
	}
	
	/**
	 * test de l'ajout de jetons dans le bon ordre 
	 */
	public void test_Grille_ajouterUnJeton() {
		//preparation des données
		Colonne c = new Colonne();
		Grille g = new Grille(0);
		g.getColonnes().add(c);
		//ajout de deux jetons
		g.ajouterUnJeton(1,Joueur1.j1); // ajout d'un X
		g.ajouterUnJeton(1,Joueur2.j2); // ajout d'un O
		// on verifie que la methode a bien ajoute a la colonne les jetons
		assertEquals("La colonne devrait avoir XO comme jetons","XO ",g.getColonnes().get(0).toString());
	}
	
	/**
	 * Test du trie des colonnes par le nombres de jetons contenus dans chacune d'elles
	 */
	public void test_Grille_trierColonnes_NbJetonsDifferents() {
		// preparation des donnees
		Grille g = new Grille(0);
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();
		Colonne c3 = new Colonne();

		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		g.getColonnes().add(c3);

		//1er colonne a 2 jetons
		g.ajouterUnJeton(1, Joueur1.j1); // X
		g.ajouterUnJeton(1, Joueur2.j2); // O	
		
		//2eme colonne a 1 jetons
		g.ajouterUnJeton(2, Joueur1.j1); // X
		
		//3eme colonne a 3 jetons
		g.ajouterUnJeton(3, Joueur1.j1); // X
		g.ajouterUnJeton(3, Joueur2.j2); // O	
		g.ajouterUnJeton(3, Joueur1.j1); // X
	
		List<Colonne> gTriee = g.trierColonnes();
		//verifs taille liste triée
		assertEquals("Le nombre de colonne devrait etre 3",3,gTriee.size());
		// verifs position des colonnes bien triées
		assertEquals("la 1ere colonne de la lTriée devrait avoir 3 elements",3,gTriee.get(0).getNbJeton());
		assertEquals("la 2eme colonne de la lTriée devrait avoir 2 elements",2,gTriee.get(1).getNbJeton());
		assertEquals("la 3eme colonne de la lTriée devrait avoir 1 elements",1,gTriee.get(2).getNbJeton());
	}
	
	/**
	 * Test de la recuperation de la hauteur max de la colonne(la valeur de la colonne contenant le plus grand nombre de jetons)
	 */
	public void test_Grille_getHauteurMax() {
		// preparation des donnees
				Grille g = new Grille(0);
				Colonne c1 = new Colonne();
				Colonne c2 = new Colonne();
				Colonne c3 = new Colonne();
				g.getColonnes().add(c1);
				g.getColonnes().add(c2);
				g.getColonnes().add(c3);

				//1er colonne a 2 jetons
				g.ajouterUnJeton(1, Joueur1.j1); // X
				g.ajouterUnJeton(1, Joueur2.j2); // O	
				
				//2eme colonne a 1 jetons
				g.ajouterUnJeton(2, Joueur1.j1); // X
				
				//3eme colonne a 3 jetons
				g.ajouterUnJeton(3, Joueur1.j1); // X
				g.ajouterUnJeton(3, Joueur2.j2); // O	
				g.ajouterUnJeton(3, Joueur1.j1); // X
		
				//verif hauteurMax
				assertEquals("La hauteur max devrait etre 3",3,g.getHauteurMax());
	}
	

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestGrille(), args);
	}
}
