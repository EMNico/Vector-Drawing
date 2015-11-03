package Objets;

abstract class ObjetGraphiqueSimple extends ObjetGraphique{
	private Crayon crayon;
	
	public ObjetGraphiqueSimple(String nom, Crayon crayon) {
		super(nom);
		this.crayon = crayon;
	}

	public Crayon getCrayon() {
		return crayon;
	}

	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}
	
}
