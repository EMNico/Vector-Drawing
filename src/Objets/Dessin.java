package Objets;

import java.util.ArrayList;

public class Dessin{
	private ArrayList<ObjetGraphique> listeElmts;
	
	public Dessin(){
		this.listeElmts = new ArrayList<ObjetGraphique>();
	}
	
	public ArrayList<ObjetGraphique> getListeElmts() {
		return listeElmts;
	}

	public void addElmt(ObjetGraphique elmt){
		this.listeElmts.add(elmt);
	}
	
	private String display(){
		String s = "";
		int i;
		for (i = 0; i < this.getListeElmts().size(); i++){
			if (!(this.getListeElmts().get(i) instanceof Point)){
				s += this.getListeElmts().get(i).display() + " \n";
			}
		}
		return s;
	}
	public void interpreteurString(){
		System.out.println(this.display());
	}
}
