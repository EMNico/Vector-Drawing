package Objets;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

abstract class ObjetGraphique {
	private String nom;
	

	public ObjetGraphique(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String codeHTML(){
		return "";
	}
	
	public String codeTexte(){
		return "";
	}
	
	public void displayGraphique(int x, int y){
		String s = "<svg height='" + x + "' width='" + y + "'>";
		s += this.codeHTML();
		s += "</svg>";
		ObjetGraphique.writeHTMLFile(s);
		ObjetGraphique.openHTMLFile();
	}
	
	public void displayTexte(){
		System.out.println(this.codeTexte());
	}
	
	public static void openHTMLFile(){
		File file = new File("src/Page/page.html");
		URI uri = file.toURI();
		try {
			Desktop.getDesktop().browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeHTMLFile(String text){
		try {
			PrintWriter out = new PrintWriter("src/Page/page.html");
			out.println(text);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// EXEMPLE
		Crayon c = new Crayon("black", 2);
		Cercle c1 = new Cercle(50, 50, 40, c);
		c1.remplir("red");
		c1.displayTexte();
		//c1.displayGraphique(1000, 1000);
		Segment c2 = new Segment(10, 20, 150, 300, c);
		DessinVide.getInstance().displayTexte();
		Dessin dessin = DessinVide.getInstance().addElmt(c1);
		dessin = dessin.addElmt(c2);
		dessin.displayTexte();
		dessin.displayGraphique(1000, 1000);
	}
}
