package tests;
import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import classes.*;
/**
 * @author Singer Jules
* Classe ayant pour but de tester la classe RandomPlayers
*/
public class TestRandomPlayers {
	
		/**
		 * Test du constructeur d'un joueur random
		 */
		public void test_RandomPlayer_Constructeur(){
			// preparation des donnees
			Joueur j1 = new RandomPlayer1();
			Joueur j2 = new RandomPlayer2();

			// verification attribut nom
			assertEquals("l'attribut nom devrait etre RandomPlayer1","RandomPlayer1", j1.getNom());
			assertEquals("l'attribut nom devrait etre RandomPlayer2","RandomPlayer2", j2.getNom());
		}
		
		/**
		 * test de l'ajout de jetons 
		 */
		public void test_RandomPlayer_ajouter() {
			// preparation des donnees
			Joueur j1 = new RandomPlayer1();
			Joueur j2 = new RandomPlayer2();
			
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
			assertEquals("la colonne devrait contenir les jetons ajoutés","HV ", g.getColonnes().get(0).toString());
		}
		
		/**
		 * Test de l'affichage des joueurs randoms
		 */
		public void test_RandomPlayer_toString() {
			// preparation des donnees
			Joueur j1 = new RandomPlayer1();
			Joueur j2 = new RandomPlayer2();
			//affichage des joueurs
			assertEquals("Affichage incorrecte","RandomPlayer1", j1.toString());
			assertEquals("Affichage incorrecte","RandomPlayer2", j2.toString());
		}
		
		/**
		 * methode de lancement des tests
		 *
		 * @param args
		 */
		public static void main(String[] args) {
			lancer(new TestRandomPlayers(), args);
		}
	}

