package fr.eql.ai108.annuaire.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class StagiaireDao {

	private File file = new File("stagiaire.bin");


	//methode getAll : on doit avoir la structure de notre fichier binaire 
	//avant de pouvoir l'implémenter
	public List<Stagiaire> stagiaireFromBinaryFile() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stagiaires;
	}


	public void nouvelleMethode() {
		//pour la mise en forme : deux espaces entre chaque méthode
	}


	public static int[] compterChar(BufferedReader inputFile) {
		int[] taillesMax = {0,0,0,0,0};
		int tailleChamp = 0;
		int nbSautDeLigne =0;
		String ligne = "";

		try {
			ligne = inputFile.readLine();
			while (ligne != null) {
				if (ligne.compareTo("*") ==0) {
					nbSautDeLigne=0;
				} else {
					char[] tableau = ligne.toCharArray();
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
				inputFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return taillesMax;
	}
	
	
	public static List<Stagiaire> stagiaireFromTextFile (BufferedReader inputFile) {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		int nbSautDeLigne=0;
		String ligne ="";
		String nom="";
		String prenom ="";
		int departement =0;
		String promotion ="";
		int annee=0;
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
					departement =0;
					promotion="";
					annee=0;
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
						departement = Integer.parseInt(ligne);
						nbSautDeLigne++;
						break;
					case 3:
						promotion = ligne;
						nbSautDeLigne++;
						break;
					case 4:
						annee = Integer.parseInt(ligne);
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
		} finally {
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
