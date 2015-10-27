package Objets;

import java.awt.Color;

public class Crayon {
	private Color couleur;
	private int epaisseur;
	
	public Crayon(Color couleur, int epaisseur){
		this.couleur = couleur;
		this.epaisseur = epaisseur;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public int getEpaisseur() {
		return epaisseur;
	}
	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}
}
