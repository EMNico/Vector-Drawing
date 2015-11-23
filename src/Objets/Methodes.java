package Objets;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;

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
		writeHTMLFile(objet.codeSave(), fileName);
	}
	
	@SuppressWarnings("null")
	public static DessinAbstrait recover(String fileName){
		String ligne = "";
		String fichier = fileName;
		BufferedReader ficTexte;
		DessinAbstrait dessin = DessinVide.getInstance();
		try {
			ficTexte = new BufferedReader(new FileReader(new File(fichier)));
			do {
				ligne = ficTexte.readLine();
				if (!ligne.matches("")) {
					dessin = dessin.addElmt(Methodes.recoverObject(ligne));
				}
			} while (ficTexte != null&&!ligne.matches(""));
			ficTexte.close();
			System.out.println("\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return dessin;
	}
	
	public static ObjetGraphiqueSimple recoverObject(String ligne){
		char[] liste = ligne.toCharArray();
		int i = 0;
		String color = "";
		ObjetGraphiqueSimple resultat;
		
		while  (liste[i] != ' '){
			color += liste[i];
			i++;
		}
		i++;
		
		String epaisseur = "";
		while (i< liste.length&&liste[i] != ' '){
			epaisseur += liste[i];
			i++;
		}
		int epaisseurInt = Integer.parseInt(epaisseur);
		i++;
		
		String type = "";
		while (liste[i] != ' '){
			type += liste[i];
			i++;
		}
		i++;
		
		String couleurInt = "";
		
		Crayon crayon = new Crayon(color, epaisseurInt);
		
		switch(type){
		
		case "point":
			String pointAbs = "";
			while (liste[i] != ','){
				pointAbs += liste[i];
				i++;
			}
			i++;
			String pointOrd = "";
			while (liste[i] != ' '){
				pointOrd += liste[i];
				i++;
			}
			
			resultat = new Point(Integer.parseInt(pointAbs), Integer.parseInt(pointOrd), crayon);
			break;
			
		case "cercle":
			String centreAbs = "";
			while (liste[i] != ','){
				centreAbs += liste[i];
				i++;
			}
			i++;
			String centreOrd = "";
			while (liste[i] != ' '){
				centreOrd += liste[i];
				i++;
			}
			i++;
			String rayon = "";
			while (liste[i] != ' '){
				rayon += liste[i];
				i++;
			}
			i++;
			
			resultat = new Cercle(Integer.parseInt(centreAbs), Integer.parseInt(centreOrd), Integer.parseInt(rayon), crayon);
			
			if (i < liste.length){
				while (liste[i] != ' '){
					couleurInt += liste[i];
					i++;
				}
				((Cercle) resultat).remplir(couleurInt);
			}
			break;
			
		case "segment":
			String aAbs = "";
			while (liste[i] != ','){
				aAbs += liste[i];
				i++;
			}
			i++;
			String aOrd = "";
			while (liste[i] != ' '){
				aOrd += liste[i];
				i++;
			}
			i++;
			String bAbs = "";
			while (liste[i] != ','){
				bAbs += liste[i];
				i++;
			}
			i++;
			String bOrd = "";
			while (liste[i] != ' '){
				bOrd += liste[i];
				i++;
			}
			i++;
			
			resultat = new Segment(Integer.parseInt(aAbs), Integer.parseInt(aOrd), Integer.parseInt(bAbs), Integer.parseInt(bOrd), crayon);
			break;
			
		case "polygone":
			String size = "";
			while (liste[i] != ' '){
				size += liste[i];
				i++;
			}
			int sizeInt = Integer.parseInt(size);
			i++;
			
			ArrayList<Point> listeSommets = new ArrayList<Point>();
			
			int j;
			String abs;
			String ord;
			for (j = 0 ; j < sizeInt ; j++){
				abs = "";
				ord = "";
				while (liste[i] != ','){
					abs += liste[i];
					i++;
				}
				i++;
				while (liste[i] != ' '){
					ord += liste[i];
					i++;
				}
				i++;
				listeSommets.add(new Point(Integer.parseInt(abs), Integer.parseInt(ord), crayon));
			}
			
			resultat = new Polygone(crayon, listeSommets);
			
			if (i < liste.length){
				while (liste[i] != ' '){
					couleurInt += liste[i];
					i++;
				}
				((Polygone) resultat).remplir(couleurInt);
			}
			break;
			
		case "courbe":
			int ordre = Integer.parseInt(liste[i] + "");
			i++;
			
			String depAbs = "";
			while (liste[i] != ','){
				depAbs += liste[i];
				i++;
			}
			i++;
			String depOrd = "";
			while (liste[i] != ' '){
				depOrd += liste[i];
				i++;
			}
			i++;
			
			Point dep = new Point(Integer.parseInt(depAbs), Integer.parseInt(depOrd), crayon);
			
			String arrAbs = "";
			while (liste[i] != ','){
				arrAbs += liste[i];
				i++;
			}
			i++;
			String arrOrd = "";
			while (liste[i] != ' '){
				arrOrd += liste[i];
				i++;
			}
			i++;
			
			Point arr = new Point(Integer.parseInt(arrAbs), Integer.parseInt(arrOrd), crayon);
			
			String c1Abs = "";
			while (liste[i] != ','){
				c1Abs += liste[i];
				i++;
			}
			i++;
			String c1Ord = "";
			while (liste[i] != ' '){
				c1Ord += liste[i];
				i++;
			}
			i++;
			
			Point c1 = new Point(Integer.parseInt(c1Abs), Integer.parseInt(c1Ord), crayon);
			
			if (ordre ==2){
				String c2Abs = "";
				while (liste[i] != ','){
					c2Abs += liste[i];
					i++;
				}
				i++;
				String c2Ord = "";
				while (liste[i] != ' '){
					c2Ord += liste[i];
					i++;
				}
				i++;
				
				Point c2 = new Point(Integer.parseInt(c2Abs), Integer.parseInt(c2Ord), crayon);
				
				resultat = new CourbeBezier(crayon, dep, arr, c1, c2);
			}
			else{
				resultat = new CourbeBezier(crayon, dep, arr, c1);
			}
			break;
			
		default:
			return null;
		}
		
		return resultat;
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
		save("fichier.txt",dessin);
		DessinAbstrait d = recover("fichier.txt");
		d.displayTexte();
		d.displayGraphique(1000, 1000);
		
	}
}
