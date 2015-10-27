package Objets;

abstract class ObjetGraphique {
	
	public String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String display(){
		return "";
	}
}
