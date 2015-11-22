package Objets;

public class Point extends ObjetGraphiqueSimple{
	private int abscisse;
	private int ordonnee;
	private static int compteur = 0;
	
	public Point(int abscisse, int ordonnee, Crayon crayon){
		super("Point" + Point.compteur, crayon);
		Point.compteur += 1;
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	public int getAbscisse() {
		return abscisse;
	}
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	public Point clone(){
		return new Point(this.getAbscisse(), this.getOrdonnee(), this.getCrayon());
	}
	
	public void translation(int abscisse, int ordonnee){
		this.setAbscisse(this.getAbscisse() + abscisse);
		this.setOrdonnee(this.getOrdonnee() + ordonnee);
	}

	public String codeHTML() {
		return "";
	}

	public String codeTexte() {
		return "";
	}
	
	public String codeSave() {
		return this.getCrayon().getCouleur() + " " + this.getCrayon().getEpaisseur() + " " + "point " + this.abscisse + "," + this.ordonnee + " ";
	}
	
}
