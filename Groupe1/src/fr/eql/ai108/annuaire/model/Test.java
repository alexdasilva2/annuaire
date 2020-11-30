package fr.eql.ai108.annuaire.model;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class Test {

	public static void main(String[] args) {

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
		for (int i = 0; i<stagiaires.size(); i++) {
			String unStrStagiaire = StagiaireDao.stagiaireToString(stagiaires.get(i));
			strStagiaires.add(unStrStagiaire);
		}
		
		//test boucle pour écriture stagiaire + une position (ici au hasard, 73 et max-value pour tous, ne signifie rien : )

		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("TestRAF.txt", "rw");
			Long position = 0L;	

			for (int i = 0; i < 30; i++) {
					raf.seek(position);
					raf.getFilePointer();
					raf.writeBytes(strStagiaires.get(i));
					position = position + strStagiaires.get(i).length();
					raf.seek(position);
					raf.getFilePointer();
					raf.writeLong(73L);
					position = position + 8L;
					raf.seek(position);
					raf.getFilePointer();
					raf.writeLong(Long.MAX_VALUE);
					position = position + 8L;
				}		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

			for (int i =0; i<20;i++) {
				System.out.println(stagiaires.get(i));
				}
			for (int i =0; i<20 ; i++) {
				System.out.println(strStagiaires.get(i));
	}

	}


}
