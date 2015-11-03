package Objets;

import java.util.ArrayList;

// Courbe servant à approximer un tracé manuel
public class CourbeBezier extends ObjetGraphiqueSimple{
	private ArrayList<Point> listePoints;
	private static int compteur = 0;

	public CourbeBezier(Crayon crayon, ArrayList<Point> listePoints) {
		super("CourbeBezier" + CourbeBezier.compteur, crayon);
		CourbeBezier.compteur += 1;
		this.listePoints = listePoints;
	}
	
	public ArrayList<Point> getlistePoints() {
		return listePoints;
	}
	
	public CourbeBezier clone(){
		// TODO
		return null;
	}
	
	public void translation(int abscisse, int ordonnee){
		// TODO
	}
	
	public String codeTexte(){
		String s = "tracé manuel approximé par la courbe de Bézier " + this.getNom() + " passant par les points ";
		int i;
		for (i = 0; i < this.getlistePoints().size(); i++){
			s += this.getlistePoints().get(i).getNom() + " (" + this.getlistePoints().get(i).getAbscisse() + "," + this.getlistePoints().get(i).getOrdonnee() + "), "; 
		}
		return s;
	}
}
