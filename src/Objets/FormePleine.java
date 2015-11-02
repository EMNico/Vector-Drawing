package Objets;

import java.awt.Color;

abstract class FormePleine extends ObjetGraphique{
	private Color couleurInt;

	public FormePleine(String nom, Crayon crayon) {
		super(nom, crayon);
		this.couleurInt = null;
	}

	public Color getCouleurInt() {
		return couleurInt;
	}
	
	public void remplir(Color couleur){
		this.couleurInt = couleur;
	}
	
	public void vider(){
		this.couleurInt = null;
	}

}
