package Objets;

public class Dessin extends DessinAbstrait{
	private ObjetGraphiqueSimple contenu;
	private DessinAbstrait dessinSuivant; 
	
	public Dessin(ObjetGraphiqueSimple contenu, DessinAbstrait dessinSuivant, String nom) {
		super(nom);
		this.contenu = contenu;
		this.dessinSuivant = dessinSuivant;
	}

	public ObjetGraphiqueSimple getContenu() {
		return contenu;
	}
	public void setContenu(ObjetGraphiqueSimple contenu) {
		this.contenu = contenu;
	}
	public DessinAbstrait getDessinSuivant() {
		return dessinSuivant;
	}
	public void setDessinSuivant(DessinAbstrait dessinSuivant) {
		this.dessinSuivant = dessinSuivant;
	}
	
	public Dessin addElmt(ObjetGraphiqueSimple elmt){
		return new Dessin(elmt, this, this.getNom());
	}

	public void fusionner(DessinAbstrait dessin){
		if (this.dessinSuivant instanceof Dessin){
			this.dessinSuivant = (Dessin) this.dessinSuivant;
			((Dessin) this.dessinSuivant).fusionner(dessin);
		}
		else{
			this.setDessinSuivant(dessin);
		}
	}
	
	public String codeHTML(){
		return this.getDessinSuivant().codeHTML() + this.getContenu().codeHTML();
	}

	public String codeTexte(){
		return contenu.codeTexte() + ", " + dessinSuivant.codeTexte();
	}
}
