package Objets;

public class Cercle extends FormePleine{
	private Point centre;
	private int rayon;
	private static int compteur = 0;
	
	public Cercle(int abscisse, int ordonnee, int rayon, Crayon crayon){
		super("Cercle" + Cercle.compteur, crayon);
		Cercle.compteur += 1;
		this.centre = new Point(abscisse, ordonnee, crayon);
		this.rayon = rayon;
	}
	
	public Cercle(Point centre, int rayon, Crayon crayon){
		super("cercle" + Cercle.compteur, crayon);
		Cercle.compteur += 1;
		this.centre = centre;
		this.rayon = rayon;
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
		return new Cercle(this.getCentre().getAbscisse(), this.getCentre().getOrdonnee(), this.getRayon(), this.getCrayon());
	}
	
	public void translation(int abscisse, int ordonnee){
		this.getCentre().translation(abscisse, ordonnee);
	}
	
	public String codeTexte(){
		return "cercle " + this.getNom() + " de centre " + this.getCentre().getNom() + " (" + this.getCentre().getAbscisse() + "," + this.getCentre().getOrdonnee() + ") et de rayon " + this.getRayon();
	}
}
