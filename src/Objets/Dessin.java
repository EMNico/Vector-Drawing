package Objets;

import java.util.ArrayList;

public class Dessin extends ObjetGraphique{
	private ArrayList<ObjetGraphique> listeElmts;
	private int abscisseMin;
	private int abscisseMax;
	private int ordonneeMin;
	private int ordonneeMax;

	public Dessin(){
		this.listeElmts = new ArrayList<ObjetGraphique>();
	}
	
	public ArrayList<ObjetGraphique> getListeElmts() {
		return listeElmts;
	}
	public int getAbscisseMin() {
		return abscisseMin;
	}
	public int getAbscisseMax() {
		return abscisseMax;
	}
	public int getOrdonneeMin() {
		return ordonneeMin;
	}
	public int getOrdonneeMax() {
		return ordonneeMax;
	}

	public void addElmt(ObjetGraphique elmt){
		this.listeElmts.add(elmt);
	}
	public void rogner(int aMin, int aMax, int oMin, int oMax){
		this.abscisseMin = aMin;
		this.abscisseMax = aMax;
		this.ordonneeMin = oMin;
		this.ordonneeMax = oMax;
	}
	
	public void translation(int abscisse, int ordonnee){
		// TODO
	}
	
	public Dessin clone(){
		// TODO
		return null;
	}
	
	public String display(){
		String s = "";
		int i;
		for (i = 0; i < this.getListeElmts().size(); i++){
			s += this.getListeElmts().get(i).display() + " \n";
		}
		return s;
	}
	public void interpreteurString(){
		System.out.println(this.display());
	}
	
	public static void main(String[] args) {
		Dessin dessin = new Dessin();
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// Dessiner ici grâce aux methodes
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		dessin.interpreteurString();
	}
}
