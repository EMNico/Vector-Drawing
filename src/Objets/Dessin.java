package Objets;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

public class Dessin extends DessinAbstrait{
	private ObjetGraphiqueSimple contenu;
	private DessinAbstrait dessinSuivant; 
	
	public Dessin(ObjetGraphiqueSimple contenu, DessinAbstrait dessinSuivant, String nom) {
		super(nom);
		this.contenu = contenu;
		this.dessinSuivant = dessinSuivant;
	}

	public ObjetGraphiqueSimple getContenu() {
		return contenu;
	}
	public void setContenu(ObjetGraphiqueSimple contenu) {
		this.contenu = contenu;
	}
	public DessinAbstrait getDessinSuivant() {
		return dessinSuivant;
	}
	public void setDessinSuivant(DessinAbstrait dessinSuivant) {
		this.dessinSuivant = dessinSuivant;
	}
	
	public Dessin addElmt(ObjetGraphiqueSimple elmt){
		return new Dessin(elmt, this, this.getNom());
	}

	public void fusionner(DessinAbstrait dessin){
		if (this.dessinSuivant instanceof Dessin){
			this.dessinSuivant = (Dessin) this.dessinSuivant;
			((Dessin) this.dessinSuivant).fusionner(dessin);
		}
		else{
			this.setDessinSuivant(dessin);
		}
	}
	
	public String codeHTML(){
		return this.getContenu().codeHTML() + this.getDessinSuivant().codeHTML();
	}

	public String codeTexte(){
		return contenu.codeTexte() + ", " + dessinSuivant.codeTexte();
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
		Crayon c = new Crayon(Color.black, 10);
		Cercle c1 = new Cercle(10, 10, 5, c);
		c1.displayTexte();
		Segment c2 = new Segment(10, 20, 10, 30, c);
		DessinVide.getInstance().displayTexte();
		Dessin dessin = DessinVide.getInstance().addElmt(c1);
		dessin = dessin.addElmt(c2);
		dessin.displayTexte();
	}
}
