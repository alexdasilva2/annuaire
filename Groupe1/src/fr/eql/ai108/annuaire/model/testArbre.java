package fr.eql.ai108.annuaire.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class testArbre {


	public static void main(String[] args) {




		Stagiaire stagiaire1=new Stagiaire("LEPANTE", "Willy","95", "Ai78", "2010");
		Stagiaire stagiaire2=new Stagiaire("LEPANTE", "Patrice","94", "ATOD7", "2009");
		Stagiaire stagiaire3=new Stagiaire("CHICHEPORT", "Stephane","95", "ATOD8", "2009");
		Stagiaire stagiaire4=new Stagiaire("SLIVCA", "Diana","95", "Ai84", "2012");
		Stagiaire stagiaire5=new Stagiaire("AMANDINE", "Anna","75", "Ai112", "2020");

		List<Stagiaire> stagiaires=new ArrayList<Stagiaire>();
		Collections.addAll(stagiaires, stagiaire1,stagiaire2,stagiaire3,stagiaire4,stagiaire5);


		Noeud racine=new Noeud(stagiaires.get(0),null, null);
		Arbre ab=new Arbre(racine);

		for(int i=0;i<stagiaires.size();i++)
		{
			Noeud noeud=new Noeud(stagiaires.get(i), null, null);
			ab.add(noeud, racine);
		}



		System.out.println("le fils gauche de ma racine "+racine.getFilsG().getStagiaire().getNom()+ " le fils droit de ma racine "
				+racine.getFilsD().getStagiaire().getNom());


		ab.rechercher(stagiaire2, racine);

		//tester la methode comparer stagiaires 

		// comparerStagiaire(stagiaire1, stagiaire2);
		//if ((comparerStagiaire(stagiaire1, stagiaire2))== true)
		//{
		//	System.out.println(stagiaire1+"est plus grand que "+stagiaire2);
		//}
		//else 
		//{
			//System.out.println(stagiaire1+"est plus petit que "+stagiaire2); 
		//}

	//}



	}
}







