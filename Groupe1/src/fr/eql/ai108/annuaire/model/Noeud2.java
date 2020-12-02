package fr.eql.ai108.annuaire.model;


public class Noeud2 {
	String stagiaire;
	Noeud2 fG;
	Noeud2 fD;
	Long index;
	Long indexFG;
	Long indexFD;
	
	public Noeud2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Noeud2(String stagiaire, Noeud2 fG, Noeud2 fD) {
		super();
		this.stagiaire = stagiaire;
		this.fG = fG;
		this.fD = fD;
	}
	public Noeud2(String stagiaire, Noeud2 fG, Noeud2 fD, Long index, Long indexFG, Long indexFD) {
		super();
		this.stagiaire = stagiaire;
		this.fG = fG;
		this.fD = fD;
		this.index = index;
		this.indexFD = indexFD;
		this.indexFG = indexFG;
	}
	
	public String getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(String stagiaire) {
		this.stagiaire = stagiaire;
	}
	public Noeud2 getfG() {
		return fG;
	}
	public void setfG(Noeud2 fG) {
		this.fG = fG;
	}
	public Noeud2 getfD() {
		return fD;
	}
	public void setfD(Noeud2 fD) {
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
	public static void ajouterNoeud2(Noeud2 noeud,Noeud2 racine) 

	{
		if (racine==null)
		{
			System.out.println("La racine est vide");
			return;
		}

		if (((racine.getStagiaire().compareTo(noeud.getStagiaire())>0)&& (racine.getfG()==null)))
		{

			racine.setfG(noeud);
		}

		if (racine.getStagiaire().compareTo(noeud.getStagiaire())>0
				&& (racine.getfG()!=null))
		{
			ajouterNoeud2(noeud, racine.getfG());
		}

		if (((racine.getStagiaire().compareTo(noeud.getStagiaire())<0)	&& (racine.getfD()==null)))
		{

			racine.setfD(noeud);
		}

		if (racine.getStagiaire().compareTo(noeud.getStagiaire())<0
				&& (racine.getfD()!=null))
		{
			ajouterNoeud2(noeud, racine.getfD());
		}


	}
}
	
	
	
	
	
	
