package Objets;

abstract class DessinAbstrait implements ObjetGraphique{
	private String nom;
	
	public DessinAbstrait(String nom){
		this.nom = nom;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
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
