package fr.eql.ai108.annuaire.model;


public class Noeud3 {
	Stagiaire stagiaire;
	Noeud3 fG;
	Noeud3 fD;
	Long index;
	Long indexFG;
	Long indexFD;
	
	public Noeud3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Noeud3(Stagiaire stagiaire, Noeud3 fG, Noeud3 fD) {
		super();
		this.stagiaire = stagiaire;
		this.fG = fG;
		this.fD = fD;
	}
	public Noeud3(Stagiaire stagiaire, Noeud3 fG, Noeud3 fD, Long index, Long indexFG, Long indexFD) {
		super();
		this.stagiaire = stagiaire;
		this.fG = fG;
		this.fD = fD;
		this.index = index;
		this.indexFD = indexFD;
		this.indexFG = indexFG;
	}
	
	public Stagiaire getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}
	public Noeud3 getfG() {
		return fG;
	}
	public void setfG(Noeud3 fG) {
		this.fG = fG;
	}
	public Noeud3 getfD() {
		return fD;
	}
	public void setfD(Noeud3 fD) {
		this.fD = fD;
	}
	public Long getIndex() {
		return index;
	}
	public void setIndex(Long index) {
		this.index = index;
	}
	public Long getIndexFG() {
		return indexFG;
	}
	public void setIndexFG(Long indexFG) {
		this.indexFG = indexFG;
	}
	public Long getIndexFD() {
		return indexFD;
	}
	public void setIndexFD(Long indexFD) {
		this.indexFD = indexFD;
	}
	
	
	//methode ajouter noeud:
	public static void ajouterNoeud3(Noeud3 noeud,Noeud3 racine) 

	{
		if (racine==null)
		{
			System.out.println("La racine est vide");
			return;
		}

		if (((racine.getStagiaire().getNom().compareTo(noeud.getStagiaire().getNom())>0)&& (racine.getfG()==null)))
		{

			racine.setfG(noeud);
		}

		if (racine.getStagiaire().getNom().compareTo(noeud.getStagiaire().getNom())>0
				&& (racine.getfG()!=null))
		{
			ajouterNoeud3(noeud, racine.getfG());
		}

		if (((racine.getStagiaire().getNom().compareTo(noeud.getStagiaire().getNom()) < 0)	&& (racine.getfD()==null)))
		{

			racine.setfD(noeud);
		}

		if (racine.getStagiaire().getNom().compareTo(noeud.getStagiaire().getNom())<0
				&& (racine.getfD()!=null))
		{
			ajouterNoeud3(noeud, racine.getfD());
		}


	}
}
	
	
	
	
	
	
