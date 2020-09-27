package tests;

import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import classes.*;
/**
 * @author Singer Jules
 * Classe ayant pour but de tester les methodes de la classe Jeton
 */
public class TestJeton {
	
	/**
	 * Test du constructeur d'un jeton
	 */
	public void test_Jeton_Constructeur(){
		// preparation des donnees
		Jeton j = new Jeton("X");
		
		//valeur du jeton
		assertEquals("l'attribut piece devrait etre X","X", j.getEmplacement());
		
	}
	
	/**
	 * Test de l'affichage d'un jeton
	 */
	public void test_jeton_toString() {
		// preparation des donnees
		Jeton j = new Jeton("X");
		//affichage du jeton
		assertEquals("Le resultat devrait etre X","X", j.toString());
	}
	
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeton(), args);
	}

}




