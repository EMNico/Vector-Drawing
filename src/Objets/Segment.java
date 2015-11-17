package Objets;

public class Segment extends ObjetGraphiqueSimple{
	private Point extremiteA;
	private Point extremiteB;
	private static int compteur = 0;
	
	public Segment(int abscisseA, int ordonneeA, int abscisseB, int ordonneeB, Crayon crayon){
		super("segment" + Segment.compteur, crayon);
		Segment.compteur += 1;
		this.extremiteA = new Point(abscisseA, ordonneeA, crayon);
		this.extremiteB = new Point(abscisseB, ordonneeB, crayon);
	}
	
	public Segment(Point point, int abscisse, int ordonnee, Crayon crayon){
		super("segment" + Segment.compteur, crayon);
		Segment.compteur += 1;
		this.extremiteA = new Point(abscisse, ordonnee, crayon);
		this.extremiteB = point;
	}
	
	public Segment(Point pointA, Point pointB, Crayon crayon){
		super("Segment" + Segment.compteur, crayon);
		Segment.compteur += 1;
		this.extremiteA = pointA;
		this.extremiteB = pointB;
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
		return new Segment(this.getExtremiteA().getAbscisse(), this.getExtremiteA().getOrdonnee(), this.getExtremiteB().getAbscisse(), this.getExtremiteB().getOrdonnee(), this.getCrayon());
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

	public String codeHTML(){
		String s = "<line x1='" + this.getExtremiteA().getAbscisse() + "' y1='" + this.getExtremiteA().getOrdonnee() + "' x2='" + this.getExtremiteB().getAbscisse() + "' y2='" + this.getExtremiteB().getOrdonnee() + "' style='stroke:" + this.getCrayon().getCouleur() + ";stroke-width:" + this.getCrayon().getEpaisseur() + "' />";
		return s;
	}
	
	public String codeTexte(){
		return "segment " + this.getNom() + " allant du point " + this.getExtremiteA().getNom() + " (" + this.getExtremiteA().getAbscisse() + "," + this.getExtremiteA().getOrdonnee() + ") au point " + this.getExtremiteA().getNom() + " (" + this.getExtremiteB().getAbscisse() + "," + this.getExtremiteB().getOrdonnee() + ")";
	}
}
