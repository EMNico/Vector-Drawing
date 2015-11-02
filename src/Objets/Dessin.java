package Objets;

public class Dessin extends DessinAbstrait{
	private ObjetGraphiqueSimple contenu;
	private DessinAbstrait dessinSuivant; 
	
	public String display(){
		return contenu.display() + dessinSuivant.display();
	}
	
	public static void main(String[] args) {
		// TODO : afficher le display d'un dessin
	}
}
