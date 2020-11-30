package fr.eql.ai108.annuaire.model;

import java.io.FileReader;
import java.io.IOException;

public class TestGit {

	public static void main(String[] args) {
		System.out.println("coucou");
		System.out.println("re coucou");
		System.out.println("re re coucou");
		FileReader in = null;
		try {
			in = new FileReader("stagiaires.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
