package Objets;

public class Segment extends ObjetGraphique{
	private Point extremiteA;
	private Point extremiteB;
	private static int compteur = 0;
	
	public Segment(int abscisseA, int ordonneeA, int abscisseB, int ordonneeB){
		this.extremiteA = new Point(abscisseA, ordonneeA);
		this.extremiteB = new Point(abscisseB, ordonneeB);
		this.nom = "segment" + Segment.compteur;
		Segment.compteur += 1;
	}
	
	public Segment(Point point, int abscisse, int ordonnee){
		this.extremiteA = new Point(abscisse, ordonnee);
		this.extremiteB = point;
		this.nom = "segment" + Segment.compteur;
		Segment.compteur += 1;
	}
	
	public Segment(Point pointA, Point pointB){
		this.extremiteA = pointA;
		this.extremiteB = pointB;
		this.nom = "segment" + Segment.compteur;
		Segment.compteur += 1;
	}
	
	public Point getExtremiteA() {
		return extremiteA;
	}
	public void setExtremiteA(Point extremiteA) {
		this.extremiteA = extremiteA;
	}
	public Point getExtremiteB() {
		return extremiteB;
	}
	public void setExtremiteB(Point extremiteB) {
		this.extremiteB = extremiteB;
	}
	
	public Segment clone(){
		return new Segment(this.getExtremiteA().getAbscisse(), this.getExtremiteA().getOrdonnee(), this.getExtremiteB().getAbscisse(), this.getExtremiteB().getOrdonnee());
	}
	
	public void translation(int abscisse, int ordonnee){
		this.getExtremiteA().translation(abscisse, ordonnee);
		this.getExtremiteB().translation(abscisse, ordonnee);
	}
	
	public void rotation(int angle){
		// TODO
	}
	
	public void rotation(Point centre, int angle){
		// TODO
	}
	
	public String display(){
		return "segment " + this.getNom() + " allant du point " + this.getExtremiteA().getNom() + " (" + this.getExtremiteA().getAbscisse() + "," + this.getExtremiteA().getOrdonnee() + ") au point " + this.getExtremiteA().getNom() + " (" + this.getExtremiteB().getAbscisse() + "," + this.getExtremiteB().getOrdonnee() + ")";
	}
}
