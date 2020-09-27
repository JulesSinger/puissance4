package classes;
import java.io.*;
import java.util.*;

import exceptions.DoublonException;
import exceptions.InfinityException;
import exceptions.ReprendreJeuException;

/**
 * @author Singer Jules
 * Cette classe a pour but de representer un jeu / une partie de puissance 4
 */
@SuppressWarnings("serial")
public class Jeu implements Serializable{
	private List<Joueur> joueurs;
	
	private Grille grille;
	
	private int nbTours;
	
	private List<Integer> historique;
	
	/**
	 * @param lJoueur : liste de joueurs
	 * @param g : objet Grille
	 */
	public Jeu(List<Joueur> lJoueur,Grille g) {
		this.joueurs = lJoueur;
		this.grille = g;
		this.nbTours = 0;
		this.historique = new ArrayList<Integer>();
	}
	
	/**
	 * getJoueur() : recupere la liste des joueurs
	 * @return l'attribut joueurs
	 */
	public List<Joueur> getJoueurs(){
		return this.joueurs;
	}
	
	/**
	 * getGrille() : recupere la grille
	 * @return l'attribut grille
	 */
	public Grille getGrille(){
		return this.grille;
	}
	
	/**
	 * getNbTours() : recupere le nombre de tours joué
	 * @return l'attribut nbTours;
	 */
	public int getNbTours() {
		return this.nbTours;
	}
	
	/**
	 * incrementerTour() : incrementer le nbre de tour
	 * utiliser pour les tests unitaires
	 */
	public void incrementerTour() {
		this.nbTours++;
	}
	
	/**
	 * getHistorique() : recupere l'historique de la partie
	 * @return l'attribut historique;
	 */
	public List<Integer> getHistorique(){
		return this.historique;
	}
	
	/**
	 * ajouterHistorique(int) : ajoute l'entier ne parametre a l'historique
	 * utiliser pour les tests unitaires
	 */
	public void ajouterHistorique(int i) {
		this.historique.add(i);
	}
	
	
	/**
	 * ajouterJoueur(Joueur j) : ajoute un joueur au jeu
	 * @param j : joueur ajouté au jeu
	 * @throws DoublonException : lance cette exception si le joueur est un doublon(c-a-d l'autre joueur a le meme pseudonyme).
	 */
	public void ajouterJoueur(Joueur j) throws DoublonException {
		if (! (joueurs.contains(j))) {
            joueurs.add(j);
        } else {
        		throw new DoublonException(" Joueur : " + j.getNom() + " est deja dans la partie !");
        }
	}

	
	/**
	 * jouer() : cette methode fait jouer chaque joueur une fois en ajoutant des Jetons, en detectant la victoire, en demandant d'effacer des coups et affiche le jeu (grille+listes+remplissage....) pour chacun d'eux.
	 * @throws InfinityException : exception lancé lorsque le remplissage a pour valeur infinity
	 * 
	 */
	@SuppressWarnings("resource")
	public boolean jouer() throws InfinityException {
		boolean finJeu = false;
		Scanner sc = new Scanner(System.in);		
		
		for(int i = 0 ; i < this.joueurs.size(); i++) {
			int numCol=0;
			if(this.joueurs.get(i) instanceof RandomPlayer1 || this.joueurs.get(i) instanceof RandomPlayer2 ) {
				Random random = new Random();
				numCol = 1 + random.nextInt(this.getGrille().getLargeurGrille()); // entier aleatoire entre 1 et la largeur de la grille
			} else {
				while(numCol <= 0 || numCol > this.getGrille().getLargeurGrille()) {
					System.out.println(this.joueurs.get(i) + ", Sur quelle colonne voulez-vous jouer ? (entre 1 et " + this.grille.getLargeurGrille() + ")");
					 numCol = sc.nextInt();
				}
			}
			
			this.joueurs.get(i).ajouter(numCol,this.grille); // On ajoute un jeton du joueur i a la colonne numero numCol
			
			this.nbTours++; 		//on incremente le nbre de tours
			this.afficherJeu(); 	//on affiche le jeu
			this.historique.add(numCol-1); // on ajoute le numero de la colonne sur laquelle on a joué dans l'historique
			
			boolean victory = this.detecterVictoire();
			if(victory) {
				finJeu = true;
				System.out.println("PUISSANCE 4 !!! " + this.joueurs.get(i) + " a gagné la partie en " + this.getNbTours() + " tours.");
				break;
			}
			
			Scanner sc2 = new Scanner(System.in);
			// demande a chaque joueur s'il veut annuler des coups
			String back = "o";
			while(!(back.equals("n")) && !(back.equals("N"))) {
				System.out.println("Voulez-vous effacer un tour ? (O/N - o/n)");
				back = sc2.nextLine();
				 if(back.equals("O") || back.equals("o")) {
					System.out.println("Suppression du dernier élément posé...");
					 this.effacerTour();
				 } 
			}
			
		
		}
		return finJeu;		
	}
	
	/*
	 * initialiserJoueurs() : Permet d'attributs a la liste de joueurs les joueurs de la partie(randomPlayer ou joueur Reel)
	 */
	public void initialiserJoueurs() {
		List<Joueur> lJ = new ArrayList<Joueur>(2);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);		
		System.out.println("Combien de Joueurs réels voulez-vous (0/1/2) ?");
		int rep = sc.nextInt();
		if(rep == 0) {
			Joueur r1 = new RandomPlayer1();
			Joueur r2 = new RandomPlayer2();
			lJ.add(r1);
			lJ.add(r2);
		} else if( rep == 1) {
			System.out.println("Veuillez entrer votre pseudonyme : ");
			String nom = sc.next();
			Joueur j1 = new Joueur1(nom);
			Joueur r1 = new RandomPlayer1();
			lJ.add(j1);
			lJ.add(r1);

		} else {
			System.out.println("Joueur 1, veuillez entrer votre pseudonyme : ");
			String nom1 = sc.next();
			Joueur j1 = new Joueur1(nom1);
			System.out.println("Joueur 2, veuillez entrer votre pseudonyme : ");
			String nom2 = sc.next();
			Joueur j2 = new Joueur2(nom2);
			lJ.add(j1);
			lJ.add(j2);
		}
		this.joueurs = lJ;
	}
	
	/**
	 * effacerTour() : permet de revenir en arriere dans le jeu
	 */
	public void effacerTour() {
		if(this.nbTours !=0) {
			int index = this.historique.get(this.historique.size()-1);
			Colonne lastColonnePlayed = this.grille.getColonnes().get(index); //on prend la derniere colonne sur laquelle on a joué (grace a l'historique)
			lastColonnePlayed.getCases().set(lastColonnePlayed.getNbJeton()-1,new PlaceVide()); // on remplace le dernier jeton joué sur cette colonne par une case vide
			lastColonnePlayed.enleverJeton(); // on décrémente le nombre de jetons de la colonne

			this.historique.remove(this.historique.size()-1); // on supprime alors le dernier entier dans l'historique puisqu'on est revenu un tour avant
			this.nbTours--; // on decremente le nombre de tours
			this.grille.afficherGrille();
		} else {
			System.out.println("Il n'y a aucun jeton sur la grille, que voulez-vous supprimer ?!");		
		}
	}
	
	/**
	 * saveGame(String) : sauvegarde le jeu dans un fichier
	 * @param destFile : fichier dans lequel on sauvegarde le jeu
	 * @throws FileNotFoundException : exception levée lorsque le fichier n'est pas trouvé
	 * @throws IOException : exception levé lors d'un problème avec le fichier
	 */
	public void saveGame(String destFile) throws FileNotFoundException, IOException {
		ObjectOutputStream fich = new ObjectOutputStream( new FileOutputStream (destFile));
		
		fich.writeObject(this);
		fich.close();
		System.out.println("Jeu Sauvegardé");
	}
	
	/**
	 * reprendreJeu(String) : reprend le jeu sauvegardé 
	 * @param srcFile : fichier dont on va recuperer le jeu(anciennement sauvegardé)
	 * @throws ReprendreJeuException : exception levé lorsqu'une erreur est apparu lors de la reprise du jeu
	 * @throws InfinityException : exception lancé lorsque le remplissage a pour valeur infinity
	 */
	public void reprendreJeu(String srcFile) throws ReprendreJeuException, InfinityException{
		try {
			ObjectInputStream fich = new ObjectInputStream( new FileInputStream(srcFile));
			Jeu j =  (Jeu) fich.readObject();
			this.joueurs = j.joueurs;
			this.grille = j.grille;
			this.nbTours = j.nbTours;
			this.historique = j.historique;
			this.afficherJeu();
			fich.close();
			
		} catch(FileNotFoundException f) {
			System.out.println("Le fichier n'a pas été trouvé");
			throw new ReprendreJeuException("fichier introuvable");
		} catch(ClassNotFoundException c) {
			System.err.println("La classe n'a pas été trouvée.");
			throw new ReprendreJeuException("classe Introuvable");
		} catch(IOException i) {
			System.err.println("Erreur trouvée dans l'utilisation du fichier source");
			throw new ReprendreJeuException("Erreur utilisation fichier source");
		}
		System.out.println("Reprise du Jeu sauvegardé");
	}
	
	/**
	 * demanderEtatJeu(String) : demande au joueur(a chaque tour) s'il veut sauvegarder, reprendre, ou jouer.
	 * @param fichier : fichier sauvegardé ou repris pour jouer.
	 * @return boolean : return true si l'utilisateur a choisi de sauvegardé le jeu, quitte alors la partie.
	 *
	 * @throws IOException : exception levé lors d'un problème avec le fichier.
	 * @throws FileNotFoundException : exception levée lorsque le fichier n'est pas trouvé.
	 * @throws ClassNotFoundException : exception levée lorsqu'une classe liée a la methode n'a pas pu etre utilisé.
	 * @throws ReprendreJeuException : exception levé lorsqu'une erreur est apparu lors de la reprise du jeu.
	 * @throws InfinityException : exception lancé lorsque le remplissage a pour valeur infinity.
	 */
	public boolean demanderEtatJeu(String fichier) throws FileNotFoundException, IOException, ClassNotFoundException, ReprendreJeuException, InfinityException {
		boolean reponseValide = false;
		boolean endGame = false;
		@SuppressWarnings("resource")
		Scanner sc2 = new Scanner(System.in);
		while(!reponseValide) {
			System.out.println("Sauvegarder / reprendre ou jouer ? (S/R/J - s/r/j)");
			String rep = sc2.nextLine();
			if(rep.equals("S") || rep.equals("s")) {
				this.saveGame(fichier);
				endGame = true;
				reponseValide = true;
			} else if (rep.equals("R") || rep.equals("r")) {
				this.reprendreJeu(fichier);
				reponseValide = true;
			} else if(rep.equals("J") || rep.equals("j")) {
				reponseValide = true;
			} else {
				System.out.println("Entrez une réponse valide.");
			}
		}
		
		return endGame;
	}
	
	
	/**
	 * detecterVictoire() : regarde si le dernier jeton de la colonne joué est en situation de victoire quelque soit la direction
	 * @return true si le dernier jeton joué est en situation de victoire
	 */
	public boolean detecterVictoire() {
		boolean victoire = false;
		List<Colonne> lCol = this.grille.getColonnes(); // simplifie l'ecriture pour toute la methode
		
		
			for(int i=0; i<this.grille.getLargeurGrille(); i++) {
				for(int j=0; j<lCol.get(i).getNbJeton();j++) {
					
					int pionAlignes = 1;
					int indexColJoue = i; // l'index de la colonne
					String jetonJoue = lCol.get(indexColJoue).getCases().get(j).toString(); // valeur du jeton courant

					// Horizontale
					if(indexColJoue <= this.grille.getLargeurGrille()-4) { 
						int indexSuivantes = indexColJoue + 1; //index des colonnes suivants celle jouée
						boolean situationVictoire = true; 
						
						while(situationVictoire) {
							if(lCol.get(indexSuivantes).getCases().get(j).toString().equals(jetonJoue)) { // si le jeton de la colonne precedente est egal au jeton joue
								pionAlignes++;
								indexSuivantes++;

							} else {
								situationVictoire = false;
								pionAlignes=1;
							}
							
							if(pionAlignes == 4) {
								victoire = true;
								situationVictoire = false; // arret de la boucle while
							}
						}
					}
					
					//verticale : minimum 4 jetons sur la colonne
					if(lCol.get(indexColJoue).getNbJeton() >= 4) {

						int indexSuivants = j+1;
						boolean situationVictoire = true; 
						
						while(situationVictoire) {
							if(lCol.get(indexColJoue).getCases().get(indexSuivants).toString().equals(jetonJoue)) { // si le dernier jeton joué est egal au jeton en dessous de lui
								pionAlignes++;
								indexSuivants++;

							} else {
								situationVictoire = false; 
								pionAlignes=1;
							}
							
							if(pionAlignes == 4) {
								victoire = true;
								situationVictoire = false; // arret de la boucle while
							}
						}
					}
					
					//diagonale1 (de en bas a gauche a en haut a droite)--> condition : 3 places vers la droite et une hauteur max avec au moins 3 jetons de plus
					if(indexColJoue <= this.grille.getLargeurGrille()-4 && j<=this.grille.getHauteurMax()-4  ) {

						int indexSuivantes = indexColJoue + 1; //index des colonnes suivants celle jouée
						int hauteurDiag = j+1;
						boolean situationVictoire = true; 
						
						while(situationVictoire) {
							if(lCol.get(indexSuivantes).getCases().get(hauteurDiag).toString().equals(jetonJoue)) { // si le jeton de la colonne precedente est egal au jeton joue
								pionAlignes++;
								hauteurDiag++;
								indexSuivantes++;

							}else {
								situationVictoire = false;
								pionAlignes=1;
							}
							
							if(pionAlignes == 4) {
								victoire = true; 
								situationVictoire = false; // arret de la boucle while
							}
						}
					}
					
					//diagonale2 (de en bas a droite a en haut a gauche) --> condition : 3 places vers la gauche, et nbre de jetons en diagonale pour les colonnes 
					if(indexColJoue > 2 && j<=this.grille.getHauteurMax()-4) { 

						int indexSuivantes = indexColJoue - 1; //index des colonnes suivants celle jouée
						int hauteurDiag = j +1;
						boolean situationVictoire = true; 
								
						while(situationVictoire) {
							if(lCol.get(indexSuivantes).getCases().get(hauteurDiag).toString().equals(jetonJoue)) { // si le jeton de la colonne precedente est egal au jeton joue
								pionAlignes++;
								hauteurDiag++;
								indexSuivantes--;

							}else {
								situationVictoire = false;
								pionAlignes = 1;
							}
									
							if(pionAlignes == 4) {
								victoire = true; 
								situationVictoire = false; // arret de la boucle while
							}
						}
					}
				}
			}
		return victoire;
	}
	
	/**
	 * afficherJeu() : affiche le jeu (le nombre de tours, la grille, la liste de colonne triée, le remplissage moyen)
	 * @throws InfinityException : exception lancé lorsque le remplissage a pour valeur infinity.
	 */
	public void afficherJeu() throws InfinityException {
		
		System.out.println("----------Tour N°"+ this.nbTours + "-----------\n");
		System.out.println("Grille");
		
		this.grille.afficherGrille();
		System.out.println("");
		
		this.grille.afficherTrieColonnes();
		
		System.out.print("Remplissage moyen : ");
		this.grille.moyenneRemplissage();
		System.out.println("------------------------------");

	}	

}