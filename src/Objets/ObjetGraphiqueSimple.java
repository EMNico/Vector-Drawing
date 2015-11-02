package Objets;

abstract class ObjetGraphiqueSimple extends ObjetGraphique{
	private String nom;
	private Crayon crayon;
	
	public ObjetGraphiqueSimple(String nom, Crayon crayon){
		this.nom = nom;
		this.crayon = crayon;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Crayon getCrayon() {
		return crayon;
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}
	
}
