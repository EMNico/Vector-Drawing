package Objets;

abstract class FormePleine extends ObjetGraphiqueSimple{
	private String couleurInt;

	public FormePleine(String nom, Crayon crayon) {
		super(nom, crayon);
		this.couleurInt = null;
	}

	public String getCouleurInt() {
		return couleurInt;
	}
	
	public void remplir(String couleur){
		this.couleurInt = couleur;
	}
	
	public void vider(){
		this.couleurInt = null;
	}
}
