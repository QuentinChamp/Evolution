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
	
	public ArrayList<Batiment> getBatiment() {
		return this.batiments;
	}
	
	public void proprioVille(Joueur joueur) { // verifie si tous les batiments d'une ville appartiennent au joueur, si oui la ville appartient au joueur
		
		int compteurEtat=0;
		
		for(Batiment b : this.batiments)
		{
			if(b.getEtat().equals(joueur.getNom()))
					compteurEtat++;
		}
		
		if(compteurEtat == this.batiments.size())
			this.etat = joueur.getNom();
		else
			this.etat = "";
	}
	
}
