package main;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import classes.Grille;
import classes.Jeu;
import classes.Joueur;
import exceptions.DoublonException;
import exceptions.InfinityException;
import exceptions.ReprendreJeuException;
/**
 * @author Singer Jules
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws ReprendreJeuException 
	 * @throws InfinityException 
	 * @throws DoublonException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ReprendreJeuException, InfinityException, DoublonException {	
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		// La grille
		System.out.println("Quelle largeur de grille voulez-vous pour votre partie de Puissance 4 ? ");
		int largeur = sc.nextInt();
		Grille grille = new Grille(largeur);
		List<Joueur> lJ = new ArrayList<Joueur>();
		// Le jeu
		Jeu j = new Jeu(lJ,grille);		
		j.initialiserJoueurs();
		
		System.out.println("QUE LA PARTIE COMMENCE !");
		System.out.println();	

		boolean finJeu = false;
		
		while(!(finJeu)) {
			finJeu = j.demanderEtatJeu("JeuPuissance4.out");
			if(finJeu) {
				break;
			}
			finJeu = j.jouer();
			if(finJeu) {
				break;
			}
		}
		
		
		}		
	
	
}