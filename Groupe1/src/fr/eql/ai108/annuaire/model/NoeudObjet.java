package fr.eql.ai108.annuaire.model;

public class Noeud {
	
	private Stagiaire stagiaire;
	private Noeud filsG;
	private Noeud filsD;
	
	
	public Noeud(Stagiaire stagiaire, Noeud filsG, Noeud filsD) {
		
		this.stagiaire = stagiaire;
		this.filsG = filsG;
		this.filsD = filsD;
	}




	public Stagiaire getStagiaire() {
		return stagiaire;
	}


	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}


	public Noeud getFilsG() {
		return filsG;
	}


	public void setFilsG(Noeud filsG) {
		this.filsG = filsG;
	}


	public Noeud getFilsD() {
		return filsD;
	}


	public void setFilsD(Noeud filsD) {
		this.filsD = filsD;
	}


	
	

}
