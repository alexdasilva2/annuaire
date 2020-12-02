package fr.eql.ai108.annuaire.model;



import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class CreationFichierBianaire {


	public static void main(String[] args) {


		//1-Creation de la liste des stagiaires a partir du fichier texte

		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		List<String> strStagiaires = new ArrayList<String>();
		stagiaires = StagiaireDao.stagiaireTrimFromTextFile();
		//System.out.println("Nombre de stagiaires : " + stagiaires.size());
		for (int i =0; i<stagiaires.size();i++){
			//System.out.println(stagiaires.get(i));
		}
		//Convertir stagiaireenString : 
		for (int i = 0; i<stagiaires.size(); i++) {
			String unStrStagiaire = StagiaireDao.stagiaireToString(stagiaires.get(i));
			strStagiaires.add(unStrStagiaire);
		}
		for (int i =0; i<strStagiaires.size() ; i++) {
			//System.out.println("liste sting"+strStagiaires.get(i));
		}

		//2-créer la list des noeuds selon la logique arbre binaire de recherche:

		List<Noeud>	listeNoeuds=new ArrayList<Noeud>();
		Noeud racine=new Noeud(strStagiaires.get(0), null, null);
		listeNoeuds.add(racine);
		for(int i=1;i<strStagiaires.size();i++) {
			Noeud noeud =new Noeud(strStagiaires.get(i), null, null);
			Noeud.ajouterNoeud(noeud, racine);
			listeNoeuds.add(noeud);
		}

		for (int i = 0; i<20; i++) {
			System.out.println("Stagiaire : " + listeNoeuds.get(i).getStagiaire() + ", son fils gauche : " +
					listeNoeuds.get(i).getfG().getStagiaire() + ", son fils droit : " + listeNoeuds.get(i).getfD().getStagiaire());
		}

	}



}
