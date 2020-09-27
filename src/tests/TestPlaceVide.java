package tests;

import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import classes.*;
/**
 * @author Singer Jules
 * Classe ayant pour but de tester la classe PlaceVide
 */
public class TestPlaceVide {
	/**
	 * Test du constructeur
	 */
	public void test_Jeton_Constructeur(){
		// preparation des donnees
		PlaceVide p = new PlaceVide();
			
		//valeur de la place vide
		assertEquals("l'attribut vide devrait etre un espace"," ", p.getEmplacement());
	}
	
	/**
	 * Test de l'affichage d'une place vide
	 */
	public void test_jeton_toString() {
		// preparation des donnees
		PlaceVide p = new PlaceVide();
		//affichage du jeton
		assertEquals("Le resultat devrait etre un espace"," ", p.toString());
	}
	
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPlaceVide(), args);
	}
}
