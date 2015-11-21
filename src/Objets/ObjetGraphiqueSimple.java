package Objets;

abstract class ObjetGraphiqueSimple implements ObjetGraphique{
	private Crayon crayon;
	private String nom;
	
	public ObjetGraphiqueSimple(String nom, Crayon crayon) {
		this.nom = nom;
		this.crayon = crayon;
	}

	public Crayon getCrayon() {
		return crayon;
	}
	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;	
	}

	public void displayGraphique(int x, int y){
		String s = "<svg height='" + x + "' width='" + y + "'>";
		s += this.codeHTML();
		s += "</svg>";
		Methodes.writeHTMLFile(s, "src/Page/page.html");
		Methodes.openHTMLFile("src/Page/page.html");
	}
	
	public void displayTexte(){
		System.out.println(this.codeTexte());
	}
}
