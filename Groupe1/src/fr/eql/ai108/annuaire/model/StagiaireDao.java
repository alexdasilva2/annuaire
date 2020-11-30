package fr.eql.ai108.annuaire.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class StagiaireDao {
	
	
	public static int[] compterChar() { 
		//fromTextFile originel stagiaires.txt
		//méthode qui compte le nombre de caractères de chaque champ
		//prend en compte le trim (supprime les espaces en trop)
		//méthode qui renvoie un tableau d'int, avec les taillesMax de chaque champ
		FileReader in = null;
		BufferedReader inputFile = null;
		int[] taillesMax = {0,0,0,0,0};
		int tailleChamp = 0;
		int nbSautDeLigne =0;
		String ligne = "";
		try {
			in = new FileReader("stagiaires.txt");
			inputFile = new BufferedReader(in);
			ligne = inputFile.readLine();
			while (ligne != null) { //tant qu'il reste une ligne dans le fichier
				if (ligne.compareTo("*") ==0) {
					nbSautDeLigne=0; //si c'est une étoile, implémente "saut de ligne" : passe au stagiaire suivant
				} else {
					char[] tableau = ligne.trim().toCharArray(); //enleve les espaces en trop
					// et convertie la ligne en tableau de caractère
					switch (nbSautDeLigne) {
					//pour chaque ligne, tu compte le nombre de caractère
					//si c'est supérieur à tailleMax[numeroLigne] tu remplaces, sinon tu fais rien
					case 0 :
						for (int i = 0; i< tableau.length; i++) {
							tailleChamp++;
							if (tailleChamp > taillesMax[0]) {
								taillesMax[0] = tailleChamp;
							}
						}
						tailleChamp=0;
						nbSautDeLigne++;
						break;
					case 1:
						for (int i = 0; i< tableau.length; i++) {
							tailleChamp++;
							if (tailleChamp > taillesMax[1]) {
								taillesMax[1] = tailleChamp;
							}
						}
						tailleChamp=0;
						nbSautDeLigne++;
						break;
					case 2:
						for (int i = 0; i< tableau.length; i++) {
							tailleChamp++;
							if (tailleChamp > taillesMax[2]) {
								taillesMax[2] = tailleChamp;
							}
						}
						tailleChamp=0;
						nbSautDeLigne++;
						break;
					case 3:
						for (int i = 0; i< tableau.length; i++) {
							tailleChamp++;
							if (tailleChamp > taillesMax[3]) {
								taillesMax[3] = tailleChamp;
							}
						}
						tailleChamp=0;
						nbSautDeLigne++;
						break;
					case 4:
						for (int i = 0; i< tableau.length; i++) {
							tailleChamp++;
							if (tailleChamp > taillesMax[4]) {
								taillesMax[4] = tailleChamp;
							}
						}
						tailleChamp=0;
						nbSautDeLigne++;
						break;
					default:
						break;
					}
				}
				ligne = inputFile.readLine();
			}
		} catch (IOException e) {
			System.out.println("IO exception");
			e.printStackTrace();
		} finally {
			try {
				in.close();
				inputFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return taillesMax;
	}

	
	public static  String stagiaireToString (Stagiaire stagiaire) {
		//méthode qui permet de récupérer une String unique avec toutes les infos d'un stagiaire
		String leStagiaire = "";
		leStagiaire = stagiaire.getNom()+stagiaire.getPrenom()+stagiaire.getDepartement()+stagiaire.getPromotion()+stagiaire.getAnnee();
		return leStagiaire;
	}
	
	
	public static List<Stagiaire> stagiaireTrimFromTextFile () { 
		//Méthode à utiliser pour récupérer les champs stagiaires de bonne taille depuis le fichier stagiaires.txt 
		//renvoie une liste de Stagiaire, au bon format (taille champ + taille ligne)
		FileReader in = null;
		BufferedReader inputFile = null;
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		int nbSautDeLigne=0;
		String ligne ="";
		String nom="";
		String prenom ="";
		String departement ="";
		String promotion ="";
		String annee="";
		int[] taillesMax = compterChar(); //on compte la tailleMax de chaque champ pour savoir combien d'espaces écrire
		try {
			in = new FileReader("stagiaires.txt");
			inputFile = new BufferedReader(in);
			ligne = inputFile.readLine().trim();
			while(ligne != null) {
				if (ligne.compareTo("*") ==0) {
					//a chaque nouveau stagiaire : j'instancie un nouveau stagiaire,
					//jé récupère les infos de chaque champs, j'ajoute le stagiaire à la liste
					Stagiaire stagiaire = new Stagiaire();
					stagiaire.setNom(nom);
					stagiaire.setPrenom(prenom);
					stagiaire.setDepartement(departement);
					stagiaire.setPromotion(promotion);
					stagiaire.setAnnee(annee);
					stagiaires.add(stagiaire);
					//et je re-initialise les valeurs saut de ligne, et les champs
					nbSautDeLigne=0;
					nom="";
					prenom ="";
					departement ="";
					promotion="";
					annee="";
				} else {
					switch (nbSautDeLigne) {
					//comme pour la méthode compterChar, à chaque ligne, je récupère une String avec le champ
					//je concatène chaque charactère pour former le nom
					case 0:
						for (int i =0; i<ligne.toCharArray().length; i++) {
							nom = nom + ligne.toCharArray()[i];
						}
						nom = nom.trim(); //je trim pour enlever les espaces supplémentaires
						//puis je concatène autant d'espaces que necessaire pour arriver à la tailleMax de chaque champ
						for (int i =0; i<(taillesMax[0] - ligne.trim().toCharArray().length); i++) {
							nom = nom + " ";
						}
						nbSautDeLigne++;
						break;
					case 1:
						for (int i = 0; i<ligne.toCharArray().length; i++) {
							prenom = prenom + ligne.toCharArray()[i];
						}
						prenom = prenom.trim();
						for (int i = 0; i<taillesMax[1] - ligne.trim().toCharArray().length; i++) {
							prenom = prenom + " ";
						}
						nbSautDeLigne++;
						break;
					case 2:
						for (int i = 0; i<ligne.toCharArray().length; i++) {
							departement = departement + ligne.toCharArray()[i];
						}
						departement = departement.trim();
						for (int i = 0; i<taillesMax[2] - ligne.trim().toCharArray().length; i++) {
							departement = departement + " ";
						}
						nbSautDeLigne++;
						break;
					case 3:
						for (int i = 0; i<ligne.toCharArray().length; i++) {
							promotion = promotion + ligne.toCharArray()[i];
						}
						promotion = promotion.trim();
						for (int i = 0; i<taillesMax[3] - ligne.trim().toCharArray().length; i++) {
							promotion = promotion +  " ";
						}
						nbSautDeLigne++;
						break;
					case 4:
						for (int i = 0; i<ligne.toCharArray().length; i++) {
							annee = annee + ligne.toCharArray()[i];
						}
						annee = annee.trim();
						for (int i = 0; i<taillesMax[4] - ligne.trim().toCharArray().length; i++) {
							annee = annee + " ";
						}
						nbSautDeLigne++;
						break;
					default:
						break;
					}
				}
				ligne = inputFile.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				inputFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stagiaires;
	}
	
	
	public static List<Stagiaire> stagiaireFromRaf(RandomAccessFile raf) { //en cours de dev
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		int[] taillesMax = compterChar(); //normalement pour être propre faire une méthode compter char depuis le binary
		int tailleLigne = 0;
		for (int i=0; i< taillesMax.length; i++) {
			tailleLigne = tailleLigne + taillesMax[i];
		}
		tailleLigne = tailleLigne + 16; //la String stagiaire + 16 (taille de deux longs pour les positions des fils)
		try {
			for (int i = 0; i < (int)raf.length(); i++) {
				raf.seek(i*tailleLigne);
				raf.getFilePointer();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stagiaires;
	}
	
	//ancienne méthode : ne pas l'utiliser, elle part d'un fichier binaire avec une structure qui n'est pas bonne
	public static List<Stagiaire> stagiaireFromBinaryFile(RandomAccessFile raf) {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		int nbEtoiles=0;
		String indexFils="";
		String nom="";
		String prenom ="";
		String strDepartement="";
		String promotion ="";
		String strAnnee="";
		String departement ="";
		String annee = "";
		try {
			for (int i = 0; i<raf.length(); i++) {
				raf.seek(i*1);
				raf.getFilePointer();
				char carac = (char) raf.readByte();
				//probleme : je pense qu'il n'a pas converti les int en byte dans le fichier. mais si c'est bien des bytes, ça ira
				if (carac == '*') {
					nbEtoiles++;
				} else if (carac != '*') {
					switch (nbEtoiles) {
					case 0:	
						indexFils = indexFils + carac;
						break;
					case 1:
						nom = nom + carac;
						break;
					case 2:
						prenom = prenom + carac;
					case 3:
						departement = departement + carac;
					case 4:
						promotion = promotion + carac;
					case 5:
						annee = annee + carac;
						break;
					case 6 : 
						Stagiaire stagiaire = new Stagiaire();
						stagiaire.setNom(nom);
						stagiaire.setPrenom(prenom);
						stagiaire.setDepartement(departement);
						stagiaire.setPromotion(promotion);
						stagiaire.setAnnee(annee);
						stagiaires.add(stagiaire);
						nbEtoiles=0;
						nom="";
						prenom ="";
						departement = "";
						strDepartement="";
						promotion ="";
						strAnnee="";
						annee="";
					default:
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stagiaires;
	}
	
	
	public static List<Stagiaire> stagiaireFromTextFile (BufferedReader inputFile) {
		//méthode à ne pas utiliser non plus, elle revnoie des stagiaires fromTextFile mais non trim
		//trop d'espaces pour certains champs
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		int nbSautDeLigne=0;
		String ligne ="";
		String nom="";
		String prenom ="";
		String departement ="";
		String promotion ="";
		String annee ="";
		try {
			ligne = inputFile.readLine();
			while(ligne != null) {
				if (ligne.compareTo("*") ==0) {
					Stagiaire stagiaire = new Stagiaire();
					stagiaire.setNom(nom);
					stagiaire.setPrenom(prenom);
					stagiaire.setDepartement(departement);
					stagiaire.setPromotion(promotion);
					stagiaire.setAnnee(annee);
					stagiaires.add(stagiaire);
					nbSautDeLigne=0;
					nom="";
					prenom ="";
					departement ="";
					promotion="";
					annee="";
				} else {
					switch (nbSautDeLigne) {
					case 0:
						nom = ligne;
						nbSautDeLigne++;
						break;
					case 1:
						prenom = ligne;
						nbSautDeLigne++;
						break;
					case 2:
						departement = ligne;
						nbSautDeLigne++;
						break;
					case 3:
						promotion = ligne;
						nbSautDeLigne++;
						break;
					case 4:
						annee = ligne;
						nbSautDeLigne++;
						break;
					default:
						break;
					}
				}
				ligne = inputFile.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				inputFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stagiaires;
	}


 

	 
	
}

