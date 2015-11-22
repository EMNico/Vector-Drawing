package Objets;

abstract interface ObjetGraphique {

	public String getNom();
	public void setNom(String nom);
	
	public void displayGraphique(int x, int y);
	public void displayTexte();
	
	public String codeHTML();
	public String codeTexte();
	public String codeSave();
}
