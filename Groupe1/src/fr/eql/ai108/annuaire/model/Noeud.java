package fr.eql.ai108.annuaire.model;


public class Noeud {
	String stagiaire;
	Noeud fG;
	Noeud fD;
	public Noeud() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Noeud(String stagiaire, Noeud fG, Noeud fD) {
		super();
		this.stagiaire = stagiaire;
		this.fG = fG;
		this.fD = fD;
	}
	public String getStagiaire() {
		return stagiaire;
	}
	public void setStagiaire(String stagiaire) {
		this.stagiaire = stagiaire;
	}
	public Noeud getfG() {
		return fG;
	}
	public void setfG(Noeud fG) {
		this.fG = fG;
	}
	public Noeud getfD() {
		return fD;
	}
	public void setfD(Noeud fD) {
		this.fD = fD;
	}
	
	
	//methode creer un noeud
	
		
		
	
	//methode ajouter noeud:
	public static void ajouterNoeud(Noeud noeud,Noeud racine) 

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
			ajouterNoeud(noeud, racine.getfG());
		}

		if (((racine.getStagiaire().compareTo(noeud.getStagiaire())<0)	&& (racine.getfD()==null)))
		{

			racine.setfD(noeud);
		}

		if (racine.getStagiaire().compareTo(noeud.getStagiaire())<0
				&& (racine.getfD()!=null))
		{
			ajouterNoeud(noeud, racine.getfD());
		}


	}		
	
}
	
	
	
	
	
	
