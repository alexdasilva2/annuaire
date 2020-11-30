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

	private File file = new File("stagiaire.bin");

	public static void writeBinFile(Arbre arbre) {

		try {
			RandomAccessFile raf = new RandomAccessFile("Arbre.bin", "rw");


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	//methode stagiaireFromBinaryFile : on doit avoir la structure de notre fichier binaire 
	//avant de pouvoir l'implémenter
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
						stagiaire.setNomPromo(promotion);
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


	public void nouvelleMethode() {
		//pour la mise en forme : deux espaces entre chaque méthode
	}


	public static List<Stagiaire> stagiaireFromTextFile (BufferedReader inputFile) {
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
					stagiaire.setNomPromo(promotion);
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


	public static int[] compterChar() {
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
			while (ligne != null) {
				if (ligne.compareTo("*") ==0) {
					nbSautDeLigne=0;		
				} else {
					char[] tableau = ligne.trim().toCharArray();
					switch (nbSautDeLigne) {
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
		String leStagiaire = "";
		leStagiaire = stagiaire.getNom()+stagiaire.getPrenom()+stagiaire.getDepartement()+stagiaire.getNomPromo()+stagiaire.getAnnee();
		return leStagiaire;
	}
	
	
	public static List<Stagiaire> stagiaireTrimFromTextFile () {
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
		int[] taillesMax = compterChar();
		try {
			in = new FileReader("stagiaires.txt");
			inputFile = new BufferedReader(in);
			ligne = inputFile.readLine().trim();
			while(ligne != null) {
				if (ligne.compareTo("*") ==0) {
					Stagiaire stagiaire = new Stagiaire();
					stagiaire.setNom(nom);
					stagiaire.setPrenom(prenom);
					stagiaire.setDepartement(departement);
					stagiaire.setNomPromo(promotion);
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
						for (int i =0; i<ligne.toCharArray().length; i++) {
							nom = nom + ligne.toCharArray()[i];
						}
						nom = nom.trim();
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


	
}
