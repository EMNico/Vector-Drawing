package Objets;

public final class DessinVide extends DessinAbstrait{
	private static volatile DessinVide instance = null;
	private static int compteur = 0;
	
	public DessinVide(String nom) {
		super(nom);
	}
    
    public final static DessinVide getInstance() {
        if (DessinVide.instance == null) {
           synchronized(DessinVide.class) {
             if (DessinVide.instance == null) {
               DessinVide.instance = new DessinVide("DessinVide");
             }
           }
        }
        return DessinVide.instance;
    }
	
	public Dessin addElmt(ObjetGraphiqueSimple elmt){
		String nom = "dessin" + DessinVide.compteur;
		DessinVide.compteur += 1;
		return new Dessin(elmt, DessinVide.getInstance(), nom);
	}
	
	public String display(){
		return "";
	}

}
