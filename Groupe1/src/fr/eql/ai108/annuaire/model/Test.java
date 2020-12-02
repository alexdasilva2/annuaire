package fr.eql.ai108.annuaire.model;
import java.io.FileNotFoundException;
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

		System.out.println("test méthode stagiaireFromRaf :");
		List<Stagiaire> stagiairesFromRaf = new ArrayList<Stagiaire>();
		stagiairesFromRaf = StagiaireDao.stagiaireFromRaf();
		//		for (int i = 0; i<20; i++) {
		//			System.out.println(stagiairesFromRaf.get(i));
		//		}



		//test méthode Noeuds : 
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("TestAjouter", "rw");
			Noeud2 racine = new Noeud2();
			racine.setStagiaire(strStagiaires.get(0));
			List<Noeud2> noeuds2 = new ArrayList<Noeud2>();
			noeuds2.add(racine);
			for(int i=1;i<strStagiaires.size();i++) {
				Noeud2 noeud = new Noeud2();
				noeud.setStagiaire(strStagiaires.get(i));
				Noeud2.ajouterNoeud2(noeud, racine);
				noeuds2.add(noeud);
			}
			System.out.println("taille de la liste noeuds2 : " + noeuds2.size());
			System.out.println("noeuds2.get(0) : " + noeuds2.get(0).getStagiaire());
			System.out.println("noeuds2.get(1) : " + noeuds2.get(1).getStagiaire());
			//jusque là c'est bon. 
			
			List<String> lesNoeuds = new ArrayList<String>();
			String noeudEtFils = "";
			for (int i = 0; i<noeuds2.size(); i++) {
				if (noeuds2.get(i).getStagiaire() != null
					&& noeuds2.get(i).getfD().getStagiaire() != null 
					&& noeuds2.get(i).getfG().getStagiaire() != null) {
					noeudEtFils = noeuds2.get(i).getStagiaire()
							+ noeuds2.get(i).getfG().getStagiaire() +
							noeuds2.get(i).getfD().getStagiaire();
					lesNoeuds.add(noeudEtFils);	
				} else if (noeuds2.get(i).getStagiaire() == null) {
					System.out.println("le getStagiaire est null");
				} else if (noeuds2.get(i).getfG().getStagiaire() == null) {
					System.out.println("le fils gauche est nul");
				} else if (noeuds2.get(i).getfD().getStagiaire()==null) {
					System.out.println("le fils droit est nul");
				}
			}
			for (int i =0; i<lesNoeuds.size(); i++) {
				System.out.println(lesNoeuds.get(i));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//		for (int i =0; i<lesNoeuds.size(); i++) {
		//			raf.seek(i*(lesNoeuds.get(i).length()));
		//			raf.getFilePointer();
		//			raf.writeBytes(lesNoeuds.get(i));	
		//		}



		// Test -ecrire dans le fichier:
		Long pointeur = 0L;
		Noeud2 racine=new Noeud2(strStagiaires.get(0), null, null);
		racine.setIndex(0L);
		try {
			raf=new RandomAccessFile("testEcriture.txt", "rw");

			//initialise en écrivant le premier stagiaire racine : 
			raf.seek(pointeur);
			raf.getFilePointer();
			raf.writeBytes(racine.getStagiaire());
			pointeur = pointeur + (long)tailleLigne;
			raf.seek(pointeur);
			raf.getFilePointer();
			raf.writeLong(-2L); // -2 : valeur "nulle" pour les index qd il n'y a pas de fils
			pointeur = pointeur + 8L ;
			raf.seek(pointeur);
			raf.getFilePointer();
			raf.writeLong(-2L);

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


	//méthodes : 
	public static void ecrireFichier (Noeud2 racine, Noeud2 noeud) {
		RandomAccessFile raf = null;
		Noeud2.ajouterNoeud2(noeud, racine); //je créer l'arborescence en mémoire
		try {
			raf = new RandomAccessFile("testEcriture.txt", "rw");
			int tailleLigne = 57;
			Long position = raf.length();

			if (noeud.getStagiaire() == racine.getfG().getStagiaire()) {
				//si le noeud correspond au fils gauche de la racine : 
				//j'écrire après la racine, un Long correspond à l'index du noeud
				racine.setIndexFG(noeud.getIndex());
				raf.seek(racine.getIndex()+(long)tailleLigne);
				raf.getFilePointer();
				raf.writeLong(position);

				//puis j'écris le noeud à la fin du fichier :
				noeud.setIndex(raf.length());
				raf.seek(noeud.index);
				raf.getFilePointer();
				raf.writeBytes(noeud.getStagiaire());
				raf.seek(noeud.index+(long)tailleLigne);
				raf.getFilePointer();
				raf.writeLong(-2L);
				raf.seek(noeud.index+(long) tailleLigne + 8L);
				raf.getFilePointer();
				raf.writeLong(-2L);
			} else if (noeud.getStagiaire() == racine.getfD().getStagiaire()) {
				//pareil pour le fils droit
				racine.setIndexFD(noeud.getIndex());
				raf.seek(racine.getIndex()+(long)tailleLigne + 8L);
				raf.getFilePointer();
				raf.writeLong(position);

				noeud.setIndex(raf.length());
				raf.seek(noeud.index);
				raf.getFilePointer();
				raf.writeBytes(noeud.getStagiaire());
				raf.seek(noeud.index+(long)tailleLigne);
				raf.getFilePointer();
				raf.writeLong(-2L);
				raf.seek(noeud.index+(long) tailleLigne + 8L);
				raf.getFilePointer();
				raf.writeLong(-2L);
			}
			if (noeud.getStagiaire().compareTo(racine.getfG().getStagiaire()) < 0) {
				//si le noeud est strictement inférieur au fils gauche de la racine : 
				//je place le pointeur sur l'index du fils gauche
				raf.seek(racine.getIndexFG());
				raf.getFilePointer();
				//et par recursivité je réinvoque la méthode
				ecrireFichier(racine.getfG(), noeud);
			} 
			else if (noeud.getStagiaire().compareTo(racine.getfD().getStagiaire()) >0) {
				//pareil pour le fils droit
				raf.seek(racine.getIndexFD());
				raf.getFilePointer();
				ecrireFichier(racine.getfD(), noeud);
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
	}

}

