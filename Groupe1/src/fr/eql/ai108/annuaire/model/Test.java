package fr.eql.ai108.annuaire.model;
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
		for (int i =0; i<30 ; i++) {
			System.out.println(strStagiaires.get(i));
		}
		
	}

}
