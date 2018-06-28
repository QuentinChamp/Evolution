package evolution;

import java.util.ArrayList;
import java.util.List;

public class Ville {
	
	private byte compteur=0;
	private byte id;
	private String nom;
	private ArrayList<Batiment> batiments;
	private String etat; // attaquer/ gagner/ perdre/ se fait attaquer.
	
	public Ville(String nom) {
		super();
		compteur++;
		this.id=compteur;
		this.nom = nom;
		this.batiments = new ArrayList<Batiment>();
		this.etat = "";
	}

	public void addBatiment(Batiment batiment) // ajoute un batiment dans la ville
	{
		this.batiments.add(batiment);
	}

	public byte getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Batiment> getBatiment()
	{
		return this.batiments;
	}
	
	

	
}
