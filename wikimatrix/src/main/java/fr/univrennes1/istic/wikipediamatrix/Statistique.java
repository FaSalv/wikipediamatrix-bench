package fr.univrennes1.istic.wikipediamatrix;

public class Statistique {

	int nbrPageExtraites; 
	int nbr404Error; 
	int nbrTableau; 
	int nbrTableauMauvaiseColonnes;
	
	public int getNbr404Error() {
		return nbr404Error;
	}
	public void setNbr404Error(int nbr404Error) {
		this.nbr404Error = nbr404Error;
	}
	public int getNbrTableau() {
		return nbrTableau;
	}
	public void setNbrTableau(int nbrTableau) {
		this.nbrTableau = nbrTableau;
	}
	public int getNbrTableauMauvaiseColonnes() {
		return nbrTableauMauvaiseColonnes;
	}
	public void setNbrTableauMauvaiseColonnes(int nbrTableauMauvaiseColonnes) {
		this.nbrTableauMauvaiseColonnes = nbrTableauMauvaiseColonnes;
	}
	public int getNbrPageExtraites() {
		return nbrPageExtraites;
	}
	public void setNbrPageExtraites(int nbrPageExtraites) {
		this.nbrPageExtraites = nbrPageExtraites;
	}
	public Statistique() {
		super();
		this.nbr404Error = 0;
		this.nbrTableau = 0;
		this.nbrTableauMauvaiseColonnes = 0;
	}
	
	public void printStatistique() {
		System.out.println("Statistiques : \n ");
		System.out.println("Nombre de page traitées : " + this.getNbrPageExtraites());
		System.out.println("Nombre d'erreur 404 : " + this.getNbr404Error());
		System.out.println("Nombre de tableau extraits : " + this.getNbrTableau());
		System.out.println("Nombre de tableau dont les lignes n'ont pas toutes la même taille : " + this.getNbrTableauMauvaiseColonnes());
	} 
	
	
	
}
