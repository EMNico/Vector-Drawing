package Objets;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

final class Methodes {
	
	public static void openHTMLFile(String fileName){
		File file = new File(fileName);
		URI uri = file.toURI();
		try {
			Desktop.getDesktop().browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeHTMLFile(String text, String fileName){
		try {
			PrintWriter out = new PrintWriter(fileName);
			out.println(text);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void save(String fileName, ObjetGraphique objet){
		writeHTMLFile(objet.codeHTML(), fileName);
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
