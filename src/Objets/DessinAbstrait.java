package Objets;

abstract class DessinAbstrait extends ObjetGraphique{

	public String display(){
		String s = "";
		return s;
	}
	public void interpreteurString(){
		System.out.println(this.display());
	}
}
