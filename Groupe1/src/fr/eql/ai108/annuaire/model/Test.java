package fr.eql.ai108.annuaire.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {		
		int[] taillesMax = StagiaireDao.compterChar();
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		stagiaires = StagiaireDao.stagiaireTrimFromTextFile();
		
		System.out.println(stagiaires.size());
		for (int i =0; i<10 ; i++) {
			System.out.println(stagiaires.get(i));
		}
		
	}

}
