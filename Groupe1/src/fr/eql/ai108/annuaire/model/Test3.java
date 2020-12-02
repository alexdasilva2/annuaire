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


		// Test -ecrire dans le fichier:
		//stagiaires = arrayList des stagiaires(trim) récupérés dans le .txt
		//strStagiaires = arrayList de String Stagiaires récupérés à partir de stagiaires
		System.out.println(stagiaires.get(3));
		
		Long curseur = 0L;
		Long grandeLigne = 73L;
		Noeud3 racine=new Noeud3(stagiaires.get(0), null, null);
		racine.setIndex(0L);
		
		try {
			raf=new RandomAccessFile("testEcriture3.txt", "rw");

			//Ecriture du fichier:
			List<Noeud3> listeNoeuds = new ArrayList<Noeud3>();
			listeNoeuds.add(racine);

			for (int i =1; i<stagiaires.size(); i++) {
				Noeud3 noeud = new Noeud3();
				noeud.setStagiaire(stagiaires.get(i));
				Noeud3.ajouterNoeud3(noeud, racine);
				//ecrireFichier(racine, noeud);
				listeNoeuds.add(noeud);
			}
			StagiaireDao.ecrireFichier(listeNoeuds);
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
	public static void ecrireString (RandomAccessFile raf, Long curseur, String uneString) {
		try {
			raf.seek(curseur);
			raf.getFilePointer();
			raf.writeBytes(uneString);
			raf.seek(raf.length());
			raf.getFilePointer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ecrireLong (RandomAccessFile raf, Long curseur, Long unLong) {
		try {
			raf.seek(curseur);
			raf.getFilePointer();
			raf.writeLong(unLong);
			raf.seek(raf.length());
			raf.getFilePointer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ecrireStagiaire(RandomAccessFile raf, Long curseur, Stagiaire stagiaire) {
		try {
			curseur = raf.length();
			//long unLong = -2L;
			ecrireString(raf, curseur, stagiaire.getNom());
			curseur = raf.length();
			ecrireString(raf, curseur, stagiaire.getPrenom());
			curseur = raf.length();
			ecrireString(raf, curseur, stagiaire.getDepartement());
			curseur = raf.length();
			ecrireString(raf, curseur, stagiaire.getPromotion());
			curseur = raf.length();
			ecrireString(raf, curseur, stagiaire.getAnnee());
			curseur=raf.length();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void ecrireFichier (Noeud3 racine, Noeud3 noeud) {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("testEcriture3.txt", "rw");
			Long curseur = raf.length();

			//si ce noeud est le fils de la racine 
			if (racine.getfG() != null && noeud.getStagiaire() == racine.getfG().getStagiaire()) {
				noeud.setIndex(curseur);
				ecrireStagiaire(raf, curseur, noeud.getStagiaire());
				//je place le curseur à l'index de la racine + 57L (là ou j'écris indexFG)
				curseur = racine.getIndex()+57L;
				//j'écris l'index du noeud
				ecrireLong(raf, curseur, noeud.getIndex());
			} 
			//pareil si c'est le fils droit :
			else if (racine.getfD() != null && noeud.getStagiaire() == racine.getfD().getStagiaire()) {
				noeud.setIndex(curseur);
				ecrireStagiaire(raf, curseur, noeud.getStagiaire());
				curseur = racine.getIndex()+57L + 8L;
				ecrireLong(raf, curseur, noeud.getIndex());
			}
			//sinon, je réappelle la méthode en remplaçant racine par son fils gauche ou droit : 
			else if (racine.getfG() != null && noeud.getStagiaire().getNom().compareTo(racine.getfG().getStagiaire().getNom()) < 0) {
				ecrireFichier(racine.getfG(), noeud);
			} else if (racine.getfD() != null && noeud.getStagiaire().getNom().compareTo(racine.getfD().getStagiaire().getNom()) > 0) {
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

