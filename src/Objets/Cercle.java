package Objets;

public class Cercle extends ObjetGraphique{
	private Point centre;
	private int rayon;
	private static int compteur = 0;
	
	public Cercle(int abscisse, int ordonnee, int rayon){
		this.centre = new Point(abscisse, ordonnee);
		this.rayon = rayon;
		this.nom = "cercle" + Cercle.compteur;
		Cercle.compteur += 1;
	}
	
	public Cercle(Point centre, int rayon){
		this.centre = centre;
		this.rayon = rayon;
		this.nom = "cercle" + Cercle.compteur;
		Cercle.compteur += 1;
	}
	
	public Point getCentre() {
		return centre;
	}
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	
	public Cercle clone(){
		return new Cercle(this.getCentre().getAbscisse(), this.getCentre().getOrdonnee(), this.getRayon());
	}
	
	public void translation(int abscisse, int ordonnee){
		this.getCentre().translation(abscisse, ordonnee);
	}
	
	public String display(){
		return "cercle " + this.getNom() + " de centre " + this.centre.nom + " (" + this.getCentre().getAbscisse() + "," + this.getCentre().getOrdonnee() + ") et de rayon " + this.rayon;
	}
}
