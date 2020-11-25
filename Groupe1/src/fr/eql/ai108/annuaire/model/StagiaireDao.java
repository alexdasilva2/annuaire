package fr.eql.ai108.annuaire.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class StagiaireDao {
	
	private File file = new File("stagiaire.bin");
	
	
	//methode getAll : on doit avoir la structure de notre fichier binaire 
	//avant de pouvoir l'implémenter
	public List<Stagiaire> getAll() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "r");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void nouvelleMethode() {
		//pour la mise en forme : deux espaces entre chaque méthode
	}
}
