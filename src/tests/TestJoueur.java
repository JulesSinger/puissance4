package tests;
import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import classes.*;
/**
 * @author Singer Jules
 * Classe ayant pour but de tester la classe Joueur
 */
public class TestJoueur {
	
	/**
	 * Test du constructeur 
	 */
	public void test_Joueur_Constructeur(){
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur1("Alexandre");

		// verification attribut nom
		assertEquals("l'attribut nom devrait etre Louis","Louis", j1.getNom());
		assertEquals("l'attribut nom devrait etre Louis","Alexandre", j2.getNom());
	}
	
	/**
	 * Test de la methode ajouter, les jetons doivent bien etre ajoutés au bon endroit et dans le bon ordre
	 */
	public void test_Joueur_ajouter() {
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur2("Alexandre");
		
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();

		Grille g = new Grille(1);
		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		//ajout des jetons dans la colonne
		j1.ajouter(1,g);
		j2.ajouter(1,g);

		// verif nbre de jetons de la colonne et jetons dans la colonne 1
		assertEquals("le nbre de jeton de la colonne devrait etre 2",2, g.getColonnes().get(0).getNbJeton());
		assertEquals("la colonne devrait contenir les jetons ajoutés","XO ", g.getColonnes().get(0).toString());
	}
	
	/**
	 * test de la methode equals, elle doit renvoyer true car les deux pseudos sont les memes
	 */
	public void test_Joueur_equals_true() {
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur2("Louis");
		//nom des joueurs identiques
		assertEquals("Resultat devrait etre true",true, j1.equals(j2));

	}
	
	/**
	 * test de la methode equals, doit renvoyer false car les deux pseudos sont differents.
	 */
	public void test_Joueur_equals_false() {
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur2("Alexandre");
		//nom des joueurs non identiques
		assertEquals("Resultat devrait etre false",false, j1.equals(j2));
	}
	
	/**
	 * Test de l'affichage d'un joueur
	 */
	public void test_Joueur_toString() {
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur2("Alexandre");
		//affichage des joueurs
		assertEquals("Affichage incorrecte","Louis(Joueur1)", j1.toString());
		assertEquals("Affichage incorrecte","Alexandre(Joueur2)", j2.toString());
	}
	
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJoueur(), args);
	}
}
