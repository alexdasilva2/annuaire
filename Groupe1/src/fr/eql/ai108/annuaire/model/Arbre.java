package fr.eql.ai108.annuaire.model;

public class Arbre {

	private Noeud racine;


	public Arbre(Noeud racine) {

		this.setRacine(racine);
	}


	public void add(Noeud noeud, Noeud racine)
	{
		
		if (racine==null)
		{
			System.out.println("la racine est null");
			return;
		}

		if ((noeud.getStagiaire().getNom().compareTo(racine.getStagiaire().getNom())>0)&&(racine.getFilsD()==null))
		{	
			
			Noeud filsD=new Noeud(noeud.getStagiaire(), noeud.getFilsG(), noeud.getFilsD());
			racine.setFilsD(filsD);
			
		}

		if ((noeud.getStagiaire().getNom().compareTo(racine.getStagiaire().getNom())>0)&&(racine.getFilsD()!=null)) 
		{
			
			add(noeud,racine.getFilsD());
		}

		if ((noeud.getStagiaire().getNom().compareTo(racine.getStagiaire().getNom())<0)&&(racine.getFilsG()==null))
		{	
			
			Noeud filsG=new Noeud(noeud.getStagiaire(), noeud.getFilsG(), noeud.getFilsD());
			
			racine.setFilsG(filsG);
		}
		

		if ((noeud.getStagiaire().getNom().compareTo(racine.getStagiaire().getNom())<0)&&(racine.getFilsG()!=null))
		{
			
			add(noeud,racine.getFilsG());
		}
	}




	public void rechercher(Stagiaire stagiaire,Noeud racine) {
		
		
		if (racine==null)
		{
			System.out.println("impossible de trouver la valeur");
			return;
		}
		
		if (racine.getStagiaire().getNom()==stagiaire.getNom())
		{
			System.out.println("nous avons trouvé notre stagiaire");
		}
		if (stagiaire.getNom().compareTo(racine.getStagiaire().getNom())>0)
		{
			rechercher( stagiaire ,racine.getFilsD());
		}
		if (stagiaire.getNom().compareTo(racine.getStagiaire().getNom())<0)
		{
			rechercher( stagiaire ,racine.getFilsG());
		}
		
	}
	
	



	public Noeud getRacine() {
		return racine;
	}






	public void setRacine(Noeud racine) {
		this.racine = racine;
	}
}
