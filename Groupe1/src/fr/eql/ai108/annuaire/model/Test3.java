package fr.eql.ai108.annuaire.model;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class Test3 {

	public static void main(String[] args) {
		RandomAccessFile raf = null;

		//test méthode compter char : compte les tailles max (trim)
		int[] taillesMax = StagiaireDao.compterChar();
		int tailleLigne = 0;
		System.out.print("Tailles max : ");
		for (int i = 0; i<taillesMax.length; i++) {
			System.out.print(taillesMax[i] + "//");
			tailleLigne = tailleLigne + taillesMax[i];
		}
		System.out.println();
		System.out.println("taille d'une string Stagiaire : " + tailleLigne);

		//test méthode stagiaireTrimFromTextFile et stagiaireToString : 
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		List<String> strStagiaires = new ArrayList<String>();
		stagiaires = StagiaireDao.stagiaireTrimFromTextFile();
		System.out.println("Nombre de stagiaires : " + stagiaires.size());
		//		for (int i =0; i<100;i++) {
		//			System.out.println(stagiaires.get(i));
		//		}

		//test pour la méthode stagiaireToString : 
		for (int i = 0; i<stagiaires.size(); i++) {
			String unStrStagiaire = StagiaireDao.stagiaireToString(stagiaires.get(i));
			strStagiaires.add(unStrStagiaire);
		}
		System.out.println("Nombre de stagiaires (str Version): " + strStagiaires.size());
		//		for (int i =0; i<100; i++) {
		//			System.out.println(strStagiaires.get(i));
		//		}


		// Test -recherche par nom : 

		Long curseur = 0L;
		Long indexRecherche=0L;

		try {
			raf=new RandomAccessFile("annuaireArbreBinaire.txt", "rw");
			System.out.println("taille du fichier binaire :" + raf.length());
			indexRecherche = StagiaireDao.chercherNom(raf, "FERNANDEZ", curseur);
			System.out.println("trouvé à la position : " + indexRecherche);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


}

