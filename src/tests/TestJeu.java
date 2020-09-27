package tests;

import libtest.*;

import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

import java.util.ArrayList;
import java.util.List;

import classes.*;
import exceptions.DoublonException;
import exceptions.InfinityException;
/**
 * @author Singer Jules
 *
 */

public class TestJeu {
	
	public void test_Jeu_constructeur() {
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur2("Alexandre");
		List<Joueur> lJ = new ArrayList<Joueur>(2);
		lJ.add(j1);
		lJ.add(j2);
		Colonne c = new Colonne();
		Grille g = new Grille(0);
		g.getColonnes().add(c);
		Jeu j = new Jeu(lJ,g);
		
		// verification attributs
		assertEquals("la taille de la liste de joueurs devrait etre 2",2, j.getJoueurs().size());
		assertEquals("la taille de la liste de la grille devrait etre 1",1, j.getGrille().getColonnes().size());
		assertEquals("le nombre de tours devrait etre 0",0, j.getNbTours());
		assertEquals("l'historique devrait etre vide",true,j.getHistorique().isEmpty());
	}
	
	public void test_Jeu_ajouterJoueur() throws DoublonException {
		// preparation des donnees
		Joueur j1 = new Joueur1("Louis");
		Joueur j2 = new Joueur2("Alexandre");
		List<Joueur> lJ = new ArrayList<Joueur>();
		
		Grille g = new Grille(0);
		Jeu j = new Jeu(lJ,g);
		j.ajouterJoueur(j1);
		j.ajouterJoueur(j2);
		
		// verification joueurs
		assertEquals("la taille de la liste de joueurs devrait etre 2",2, j.getJoueurs().size());
		assertEquals("le premier joueur devrait s'appeler Louis","Louis", j.getJoueurs().get(0).getNom());
		assertEquals("le deuxieme joueur devrait s'appeler Alexandre","Alexandre", j.getJoueurs().get(1).getNom());
	}
	
	public void test_Jeu_effacerTour() throws DoublonException, InfinityException {
		List<Joueur> lJ = new ArrayList<Joueur>();
	
		Colonne c = new Colonne();
		Grille g = new Grille(0);
		g.getColonnes().add(c);
		Jeu j = new Jeu(lJ,g);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		
		assertEquals("La colonne devrait contenir le jeton", "X ",j.getGrille().getColonnes().get(0).toString());
	
		j.incrementerTour(); // on increment manuellement le nbTour pour passer dans la condition de la methode effacer tour (normalement incrementer dans la methode jouer)
		j.ajouterHistorique(0);// pareil pour l'historique de jeu

		j.effacerTour();
		
		assertEquals("La colonne ne devrait plus contenir le jeton ajouté.", "  ",j.getGrille().getColonnes().get(0).toString());
	}

	
	
	// H = horizontale
	public void test_Jeu_detecterVictoire_H_true() {
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();
		Colonne c3 = new Colonne();
		Colonne c4 = new Colonne();
		Grille g = new Grille(4);
		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		g.getColonnes().add(c3);
		g.getColonnes().add(c4);
		Joueur j1 = new Joueur1("Joueur");
		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		Jeu j = new Jeu(lJoueurs,g);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(2, Joueur1.j1);
		j.getGrille().ajouterUnJeton(4, Joueur1.j1);
		j.getGrille().ajouterUnJeton(3, Joueur1.j1);
		
		boolean victoire = j.detecterVictoire();
		
		assertEquals("victoire devrait etre vrai", true, victoire);

	}
	
	// H = horizontale
	public void test_Jeu_detecterVictoire_H_false() {
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();
		Colonne c3 = new Colonne();
		Colonne c4 = new Colonne();
		Grille g = new Grille(4);
		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		g.getColonnes().add(c3);
		g.getColonnes().add(c4);
		Joueur j1 = new Joueur1("Joueur");
		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		Jeu j = new Jeu(lJoueurs,g);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(2, Joueur1.j1);
		j.getGrille().ajouterUnJeton(4, Joueur1.j1);
		j.getGrille().ajouterUnJeton(3, Joueur2.j2);
		
		boolean victoire = j.detecterVictoire();
		
		assertEquals("victoire devrait etre faux", false, victoire);

	}
	
	// V = Verticale
	public void test_Jeu_detecterVictoire_V_true() {
		Colonne c1 = new Colonne();
		Grille g = new Grille(1);
		g.getColonnes().add(c1);
	
		Joueur j1 = new Joueur1("Joueur");
		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		Jeu j = new Jeu(lJoueurs,g);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		
		boolean victoire = j.detecterVictoire();
		
		assertEquals("victoire devrait etre vrai", true, victoire);

	}
	
	// V = Verticale
	public void test_Jeu_detecterVictoire_V_false() {
		Colonne c1 = new Colonne();
		Grille g = new Grille(1);
		g.getColonnes().add(c1);
	
		Joueur j1 = new Joueur1("Joueur");
		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		Jeu j = new Jeu(lJoueurs,g);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1);
		j.getGrille().ajouterUnJeton(1, Joueur2.j2);
		
		boolean victoire = j.detecterVictoire();
		
		assertEquals("victoire devrait etre faux", false, victoire);

	}
	
	// Diag1 = de en bas a gauche a en haut a droite
	public void test_Jeu_detecterVictoire_Diag1_true() {
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();
		Colonne c3 = new Colonne();
		Colonne c4 = new Colonne();
		Grille g = new Grille(4);
		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		g.getColonnes().add(c3);
		g.getColonnes().add(c4);
		Joueur j1 = new Joueur1("Joueur1");
		Joueur j2 = new Joueur2("Joueur2");

		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		lJoueurs.add(j2);
		Jeu j = new Jeu(lJoueurs,g);
		// l'ordre d'ajout ne change rien on peut changer a volonté, c'est juste une question de clarté pour le test
		j.getGrille().ajouterUnJeton(1, Joueur1.j1); //1ere col : X
		
		j.getGrille().ajouterUnJeton(2, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(2, Joueur1.j1); //2eme col : OX
		
		j.getGrille().ajouterUnJeton(4, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(4, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(4, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(4, Joueur1.j1); //4eme col : OOOX
		
		j.getGrille().ajouterUnJeton(3, Joueur2.j2);
		j.getGrille().ajouterUnJeton(3, Joueur1.j1); 
		j.getGrille().ajouterUnJeton(3, Joueur1.j1); //3eme col : OXX
	
		
		boolean victoire = j.detecterVictoire();
		//verif colonnes
		assertEquals("1ere colonne devrait avoir X", "X    ", j.getGrille().getColonnes().get(0).toString());
		assertEquals("2eme colonne devrait avoir OX", "OX   ", j.getGrille().getColonnes().get(1).toString());
		assertEquals("3eme colonne devrait avoir OXX", "OXX  ", j.getGrille().getColonnes().get(2).toString());
		assertEquals("4eme colonne devrait avoir OOOX", "OOOX ", j.getGrille().getColonnes().get(3).toString());
		//verif victoire true
		assertEquals("victoire devrait etre vrai", true, victoire);
	}
	
	public void test_Jeu_detecterVictoire_Diag1_false() {
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();
		Colonne c3 = new Colonne();
		Colonne c4 = new Colonne();
		Grille g = new Grille(4);
		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		g.getColonnes().add(c3);
		g.getColonnes().add(c4);
		Joueur j1 = new Joueur1("Joueur1");
		Joueur j2 = new Joueur2("Joueur2");

		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		lJoueurs.add(j2);
		Jeu j = new Jeu(lJoueurs,g);
		// l'ordre d'ajout ne change rien on peut changer a volonté, c'est juste une question de clarté pour le test
		j.getGrille().ajouterUnJeton(1, Joueur1.j1); //1ere col : X
		
		j.getGrille().ajouterUnJeton(2, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(2, Joueur1.j1); //2eme col : OX
		
		j.getGrille().ajouterUnJeton(4, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(4, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(4, Joueur2.j2); 
		j.getGrille().ajouterUnJeton(4, Joueur1.j1); //4eme col : OOOX
		
		j.getGrille().ajouterUnJeton(3, Joueur2.j2);
		j.getGrille().ajouterUnJeton(3, Joueur1.j1); 
		j.getGrille().ajouterUnJeton(3, Joueur2.j2); //3eme col : OXO (coupe la diagonale de X donc pas de victoire)
	
		
		boolean victoire = j.detecterVictoire();

		//verif victoire true
		assertEquals("victoire devrait etre faux", false, victoire);
	}
	
	// Diag2 = de en bas a droite a en haut a gauche
	public void test_Jeu_detecterVictoire_Diag2_true() {
		Colonne c1 = new Colonne();
		Colonne c2 = new Colonne();
		Colonne c3 = new Colonne();
		Colonne c4 = new Colonne();
		Grille g = new Grille(4);
		g.getColonnes().add(c1);
		g.getColonnes().add(c2);
		g.getColonnes().add(c3);
		g.getColonnes().add(c4);
		Joueur j1 = new Joueur1("Joueur1");
		Joueur j2 = new Joueur2("Joueur2");

		List<Joueur> lJoueurs = new ArrayList<Joueur>();
		lJoueurs.add(j1);
		lJoueurs.add(j2);
		Jeu j = new Jeu(lJoueurs,g);
		// l'ordre d'ajout ne change rien on peut changer a volonté, c'est juste une question de clarté pour le test
		j.getGrille().ajouterUnJeton(1, Joueur2.j2); //1ere col : OOOX
		j.getGrille().ajouterUnJeton(1, Joueur2.j2);
		j.getGrille().ajouterUnJeton(1, Joueur2.j2);
		j.getGrille().ajouterUnJeton(1, Joueur1.j1); 

		j.getGrille().ajouterUnJeton(2, Joueur2.j2); //2eme col : OXX
		j.getGrille().ajouterUnJeton(2, Joueur1.j1);
		j.getGrille().ajouterUnJeton(2, Joueur1.j1);
		
		j.getGrille().ajouterUnJeton(4, Joueur1.j1); //4eme col : X
		
		j.getGrille().ajouterUnJeton(3, Joueur2.j2); //3eme col : OX
		j.getGrille().ajouterUnJeton(3, Joueur1.j1); 
		
		boolean victoire = j.detecterVictoire();
		//verif colonnes
		assertEquals("1ere colonne devrait avoir X", "OOOX ", j.getGrille().getColonnes().get(0).toString());
		assertEquals("2eme colonne devrait avoir OX", "OXX  ", j.getGrille().getColonnes().get(1).toString());
		assertEquals("3eme colonne devrait avoir OXX", "OX   ", j.getGrille().getColonnes().get(2).toString());
		assertEquals("4eme colonne devrait avoir OOOX", "X    ", j.getGrille().getColonnes().get(3).toString());
		//verif victoire true
		assertEquals("victoire devrait etre vrai", true, victoire);
	}
	
	// Diag2 = de en bas a droite a en haut a gauche
		public void test_Jeu_detecterVictoire_Diag2_false() {
			Colonne c1 = new Colonne();
			Colonne c2 = new Colonne();
			Colonne c3 = new Colonne();
			Colonne c4 = new Colonne();
			Grille g = new Grille(4);
			g.getColonnes().add(c1);
			g.getColonnes().add(c2);
			g.getColonnes().add(c3);
			g.getColonnes().add(c4);
			Joueur j1 = new Joueur1("Joueur1");
			Joueur j2 = new Joueur2("Joueur2");

			List<Joueur> lJoueurs = new ArrayList<Joueur>();
			lJoueurs.add(j1);
			lJoueurs.add(j2);
			Jeu j = new Jeu(lJoueurs,g);
			// l'ordre d'ajout ne change rien on peut changer a volonté, c'est juste une question de clarté pour le test
			j.getGrille().ajouterUnJeton(1, Joueur2.j2); //1ere col : OOOX
			j.getGrille().ajouterUnJeton(1, Joueur2.j2);
			j.getGrille().ajouterUnJeton(1, Joueur2.j2);
			j.getGrille().ajouterUnJeton(1, Joueur1.j1); 

			j.getGrille().ajouterUnJeton(2, Joueur2.j2); //2eme col : OXO
			j.getGrille().ajouterUnJeton(2, Joueur1.j1);
			j.getGrille().ajouterUnJeton(2, Joueur2.j2); // coupe la diagonale X
			
			j.getGrille().ajouterUnJeton(4, Joueur1.j1); //4eme col : X
			
			j.getGrille().ajouterUnJeton(3, Joueur2.j2); //3eme col : OX
			j.getGrille().ajouterUnJeton(3, Joueur1.j1); 
			
			boolean victoire = j.detecterVictoire();

			//verif victoire true
			assertEquals("victoire devrait etre faux", false, victoire);
		}
	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeu(), args);
	}
}
