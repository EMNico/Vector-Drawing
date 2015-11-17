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
		ArrayList<Point> listeSommets = null;
		int i;
		for (i = 0 ; i < this.getListeSommets().size() ; i++){
			listeSommets.add(i, this.getListeSommets().get(i).clone());
		}
		return new Polygone(this.getCrayon(), listeSommets);
	}
	
	public void translation(int abscisse, int ordonnee){
		int i;
		for (i = 0 ; i < this.getListeSommets().size() ; i++){
			this.getListeSommets().get(i).translation(abscisse, ordonnee);
		}
	}
	
	public String codeHTML(){
		String s =  "<polygon points='";
		int i;
		for (i = 0; i < this.getListeSommets().size(); i++){
			s += this.getListeSommets().get(i).getAbscisse() + "," + this.getListeSommets().get(i).getOrdonnee() + " ";
		}
		String fill = "none";
		if (this.getCouleurInt() != null){
			fill = this.getCouleurInt();
		}
		s += "' style='fill:" + fill + ";stroke:" + this.getCrayon().getCouleur() + ";stroke-width:" + this.getCrayon().getEpaisseur() + "' />";
		return s;
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
