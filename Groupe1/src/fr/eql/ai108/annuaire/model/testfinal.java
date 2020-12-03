package fr.eql.ai108.annuaire.model;

import java.util.ArrayList;
import java.util.List;

public class testfinal {

	public static void main(String[] args) {
		List<Stagiaire> listeTriee = new ArrayList<Stagiaire>();
		listeTriee = StagiaireDao.trierRaf();
		for(int i=0; i<10; i++) {
			System.out.println(listeTriee.get(i));
		}
		
	}

}
