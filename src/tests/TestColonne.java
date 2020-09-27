package tests;
import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import java.util.ArrayList;
import java.util.List;

import classes.*;
/**
 * @author Singer Jules
 * Classe ayant pour but de tester la classe Colonne
 */
public class TestColonne {
	
	/**
	 * test du constructeur 
	 */
	public void test_Colonne_constructeur() {
		// preparation des donnees
		Colonne c = new Colonne();
		
		// verification attributs
		assertEquals("l'attribut nbJetons devrait etre 0",0, c.getNbJeton());
		assertEquals("l'attribut cases devrait avoir un espace vide"," ", c.toString());
	}
	
	/**
	 * Test de l'initalisation d'une colonne
	 */
	public void test_Colonne_init() {
		// preparation des donnees
		Colonne c = new Colonne();
		
		//initialisation d'une case vide
		c.init();
		
		//verif de la liste
		assertEquals("la liste de Jeton ne devrait pas etre vide",false, c.getCases().isEmpty());
	}
	
	/**
	 * Test de l'affichage de la colonne
	 */
	public void test_Colonne_toString() {
		// preparation des donnees
		Colonne c = new Colonne();
		Grille g = new Grille(1);
		g.getColonnes().add(c);
		g.ajouterUnJeton(1,Joueur1.j1);
		g.ajouterUnJeton(1,Joueur2.j2);

		// verif affichage de la colonne
		assertEquals("Affichage incorrecte","XO ", g.getColonnes().get(0).toString());
		
	}
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestColonne(), args);
	}
}
