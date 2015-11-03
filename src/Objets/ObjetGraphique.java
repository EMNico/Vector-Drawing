package Objets;

abstract class ObjetGraphique {
	private String nom;
	

	public ObjetGraphique(String nom) {
		this.nom = nom;
	}

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
