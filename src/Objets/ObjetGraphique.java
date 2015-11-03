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
	
	public String codeHTML(){
		return "";
	}
	
	public String codeTexte(){
		return "";
	}
	
	public void displayGraphique(){
		Dessin.writeHTMLFile(this.codeHTML());
		Dessin.openHTMLFile();
	}
	
	public void displayTexte(){
		System.out.println(this.codeTexte());
	}
}
