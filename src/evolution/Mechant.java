package evolution;

public class Mechant {
	
	private byte compteur=0;
	private byte id;
	private String nom;
	private int dps;
	private int vie;
	
	public Mechant(String nom, int dps, int vie) {
		super();
		
		compteur ++ ;
		this.id = compteur;
		this.nom = nom;
		this.dps = dps;
		this.vie = vie;
	}

	public void setDps(int dps) {
		this.dps = dps;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDps() {
		return dps;
	}

	public int getVie() {
		return vie;
	}

	public byte getId() {
		return id;
	}
	
}
