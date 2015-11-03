package Objets;

abstract class DessinAbstrait extends ObjetGraphique{

	public DessinAbstrait(String nom) {
		super(nom);
	}
	
	public String display(){
		String s = "";
		return s;
	}
	public void interpreteurString(){
		System.out.println(this.display());
	}
}
