package fr.eql.ai108.annuaire.model;

public class Stagiaire {

	private String nom;
	private String prenom;
	private int departement;
	private String nomPromo;
	private int annee;

 public boolean comparerStagiaire(Stagiaire sg1, Stagiaire sg2) {
		

		{
			if (sg1.getNom().compareTo(sg2.getNom())>0 )
			{
				return true;
			}
			if (sg1.getNom().compareTo(sg2.getNom())<0)
			{
				return false;	

			}
			if (sg1.getNom().equals(sg2.getNom()))
			{
				if (sg1.getPrenom().compareTo(sg2.getPrenom())>0 )
				{
					return true;
				}
				if (sg1.getPrenom().compareTo(sg2.getPrenom())<0)
				{
					return true;	

				}
			}
			
		}
 
		return false;
		
}
	public Stagiaire() {
		super();
	}


	public Stagiaire(String nom, String prenom, int departement, String nomPromo, int annee) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.departement = departement;
		this.nomPromo = nomPromo;
		this.annee = annee;
	}


	@Override
	public String toString() {
		return "Stagiaire [nom=" + nom + ", prenom=" + prenom + ", departement=" + departement + ", nomPromo="
				+ nomPromo + ", annee=" + annee + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + departement;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((nomPromo == null) ? 0 : nomPromo.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		if (annee != other.annee)
			return false;
		if (departement != other.departement)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (nomPromo == null) {
			if (other.nomPromo != null)
				return false;
		} else if (!nomPromo.equals(other.nomPromo))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getDepartement() {
		return departement;
	}


	public void setDepartement(int departement) {
		this.departement = departement;
	}


	public String getNomPromo() {
		return nomPromo;
	}


	public void setNomPromo(String nomPromo) {
		this.nomPromo = nomPromo;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}

 

	}

