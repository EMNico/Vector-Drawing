package Objets;

// Courbe servant à approximer un tracé manuel, ce sont des courbes de Bezier quadratiques ou cubiques
public class CourbeBezier extends ObjetGraphiqueSimple{
	private Point depart;
	private Point arrivee;
	private Point controle1;
	private Point controle2;
	private static int compteur = 0;

	
	public CourbeBezier(Crayon crayon, Point depart, Point arrivee,
			Point controle1) {
		super("courbe_bezier" + compteur, crayon);
		CourbeBezier.compteur += 1;
		this.depart = depart;
		this.arrivee = arrivee;
		this.controle1 = controle1;
	}

	public CourbeBezier(Crayon crayon, Point depart, Point arrivee,
			Point controle1, Point controle2) {
		super("courbe_bezier" + compteur, crayon);
		CourbeBezier.compteur += 1;
		this.depart = depart;
		this.arrivee = arrivee;
		this.controle1 = controle1;
		this.controle2 = controle2;
	}

	public Point getDepart() {
		return depart;
	}
	public void setDepart(Point depart) {
		this.depart = depart;
	}
	public Point getArrivee() {
		return arrivee;
	}
	public void setArrivee(Point arrivee) {
		this.arrivee = arrivee;
	}
	public Point getControle1() {
		return controle1;
	}
	public void setControle1(Point controle1) {
		this.controle1 = controle1;
	}
	public Point getControle2() {
		return controle2;
	}
	public void setControle2(Point controle2) {
		this.controle2 = controle2;
	}

	public CourbeBezier clone(){
		if (this.getControle2() != null){
			return new CourbeBezier(this.getCrayon(), this.getDepart().clone(), this.getArrivee().clone(), this.getControle1().clone(), this.getControle2().clone());
		}
		else{
			return new CourbeBezier(this.getCrayon(), this.getDepart().clone(), this.getArrivee().clone(), this.getControle1().clone());
		}
	}
	
	public void translation(int abscisse, int ordonnee){
		this.getArrivee().translation(abscisse, ordonnee);
		this.getDepart().translation(abscisse, ordonnee);
		this.getControle1().translation(abscisse, ordonnee);
		if (this.getControle2() != null){
			this.getControle2().translation(abscisse, ordonnee);
		}
	}
	
	@Override
	public String codeHTML(){
		String type = "Q";
		String controle2 = "";
		if (this.getControle2() != null){
			type = "T";
			controle2 = " " + this.getControle2().getAbscisse() + "," + this.getControle2().getOrdonnee();
		}
		String s =  "<path d='M " + this.getDepart().getAbscisse() + "," + this.getDepart().getOrdonnee() + " " + type + " " + this.getControle1().getAbscisse() + "," + this.getControle1().getOrdonnee() + controle2 + " " + this.getArrivee().getAbscisse() + "," + this.getArrivee().getOrdonnee() + "' ' stroke='" + this.getCrayon().getCouleur() + "' stroke-width='" + this.getCrayon().getEpaisseur() + "'";
		return s;
	}
	
	@Override
	public String codeTexte(){
		String s = "";
		s += "tracé manuel approximé par la courbe de Bézier " + this.getNom() + " allant du point " + this.getDepart().getNom()+ " (" + this.getDepart().getAbscisse() + "," + this.getDepart().getOrdonnee() + ") au point" + this.getArrivee().getNom()+ " (" + this.getArrivee().getAbscisse() + "," + this.getArrivee().getOrdonnee() + ")";
		s += " et de point(s) de controle " + this.getControle1().getNom()+ " (" + this.getControle1().getAbscisse() + "," + this.getControle1().getOrdonnee() + ")";
		if (this.getControle2() != null){
			s += " et " + this.getControle2().getNom()+ " (" + this.getControle2().getAbscisse() + "," + this.getControle2().getOrdonnee() + ")";
		}
		return s;
	}

	@Override
	public String codeSave() {
		int ordre = 1;
		String extraString = "";
		if (this.getControle2() != null){
			ordre = 2;
			extraString = this.getControle2().getAbscisse() + "," + this.getControle2().getOrdonnee() + " ";
		}
		return this.getCrayon().getCouleur() + " " + this.getCrayon().getEpaisseur() + " " + "courbe " + ordre + " " + this.getDepart().getAbscisse() + "," + this.getDepart().getOrdonnee() + " " + this.getArrivee().getAbscisse() + "," + this.getArrivee().getOrdonnee() + " " + this.getControle1().getAbscisse() + "," + this.getControle1().getOrdonnee() + " " + extraString;
	}
}
