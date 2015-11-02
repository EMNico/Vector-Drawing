package Objets;

public class Point extends ObjetGraphique{
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
	
	public void translation(int abscisse, int ordonnee){
		this.setAbscisse(this.getAbscisse() + abscisse);
		this.setOrdonnee(this.getOrdonnee() + ordonnee);
	}
	
}
