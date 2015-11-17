package Objets;

public class Crayon {
	private String couleur;
	private int epaisseur;
	
	public Crayon(String couleur, int epaisseur){
		this.couleur = couleur;
		this.epaisseur = epaisseur;
	}
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getEpaisseur() {
		return epaisseur;
	}
	public void setEpaisseur(int epaisseur) {
		this.epaisseur = epaisseur;
	}
}
