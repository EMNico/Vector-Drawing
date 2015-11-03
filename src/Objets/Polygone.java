package Objets;

import java.util.ArrayList;

public class Polygone extends FormePleine{
	private ArrayList<Point> listeSommets;
	private static int compteur = 0;

	public Polygone(Crayon crayon, ArrayList<Point> listeSommets) {
		super("Polygone" + Polygone.compteur, crayon);
		Polygone.compteur += 1;
		this.listeSommets = listeSommets;
	}
	
	public ArrayList<Point> getListeSommets() {
		return listeSommets;
	}
	
	public void inserer(int position, Point point){
		this.getListeSommets().add(position, point);
	}
	public void inserer(int position, int abscisse, int ordonnee, Crayon crayon){
		this.getListeSommets().add(position, new Point(abscisse, ordonnee, crayon));
	}
	
	public void retirer(int position){
		this.getListeSommets().remove(position);
	}
	
	public Polygone clone(){
		// TODO
		return null;
	}
	
	public void translation(int abscisse, int ordonnee){
		// TODO
	}
	
	public String codeTexte(){
		String s = "polygone " + this.getNom() + " de sommets ";
		int i;
		for (i = 0; i < this.getListeSommets().size(); i++){
			s += this.getListeSommets().get(i).getNom() + " (" + this.getListeSommets().get(i).getAbscisse() + "," + this.getListeSommets().get(i).getOrdonnee() + "), "; 
		}
		return s;
	}

}
