package evolution;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;*/

public class Secteur {

	//private byte compteur=0;
	private byte id;
	private String nom;
	private Ville[] villes;
	
	
	/*public Secteur() 
	{
		compteur++;
		this.id=compteur;
		Scanner clavier = new Scanner(System.in);
		System.out.print("Le nom du secteur est : ");
		this.nom= clavier.nextLine();
		this.villes=new Ville[5];
	}
	
	public Secteur(String nom) {
		super();
		compteur ++ ;
		this.id=compteur;
		this.nom = nom;
		this.villes = new Ville[5];
		
	}*/
	
	public int getID() {
		return this.id;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Ville[] getVille(){
		return this.villes;
	}
	
	public void addVille(int index, Ville villes) {
		this.villes[index] = villes;
		
	}


	
	// tableau secteur, tableau ville, list batiment
	// tableau secteur dans le main avec une methode objectif
	
}
