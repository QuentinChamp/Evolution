package evolution;

import java.util.ArrayList;
import java.util.List;

public class Batiment {
	private byte compteur=0;
	
	private byte id;
	private String nom;
	private List<Mechant> mechants = new ArrayList<Mechant>();
	private int stock; 
	private int vie;
	private Ressource ressource;
	private String etat;
	
	public Batiment(String nom, int stock, int vie, Ressource ressource) {
		super();
		compteur++;
		this.id = compteur;
		this.nom = nom;
		this.stock = stock;
		this.vie = vie;
		this.ressource = ressource;
		this.etat = "";
		genererMechants(this.mechants);
	}

	
	public byte getId() {
		return id;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Mechant> getMechants() {
		return mechants;
	}


	public void setMechants(List<Mechant> mechants) {
		this.mechants = mechants;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getVie() {
		return vie;
	}


	public void setVie(int vie) {
		this.vie = vie;
	}


	public Ressource getRessource() {
		return ressource;
	}


	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	
	public boolean attaquer(Joueur joueur)
	{
		int dps=0;
		boolean win = false;
		Mechant mechant = this.mechants.get(random(0, this.mechants.size()-1));
		while(mechant.getVie()>0 && joueur.getVie()>0)
		{
			dps = random(0, joueur.getDps());
			mechant.setVie(mechant.getVie() - dps);
			if(mechant.getVie()>0)
				System.out.println("Vous faites "+dps+" de dégats à "+mechant.getNom()+", il lui reste "+mechant.getVie()+".");
			else
				System.out.println("Vous faites "+dps+" de dégats à "+mechant.getNom()+", il est KO.");
			if(mechant.getVie()<=0)
			{
				win = true;
				break;
			}
			dps = random(0, mechant.getDps());
			
			if(joueur.getVie() - dps >=0)
				joueur.setVie(joueur.getVie() - dps);
			else
				joueur.setVie(0);
			
			if(joueur.getVie()>0)
				System.out.println(mechant.getNom()+" vous fait "+dps+" de dégats, il vous reste "+joueur.getVie()+".");
			else
			{
				System.out.println(mechant.getNom()+" vous fait "+dps+" de dégats, vous êtes KO.");
				MainClass.title();
			}
			if(joueur.getVie()<=0)
				win = false;
		}
		if(win==true)
			gagner(joueur);
		else
			defaite();
		return win;
	}
	
	public boolean defendre(Joueur joueur)
	{
		
		boolean win = true;
		Mechant mechant = this.mechants.get(random(0, this.mechants.size()));
		while(mechant.getVie()>0 && joueur.getVie()>0)
		{
			joueur.setVie(joueur.getVie() - random(0, mechant.getDps()));
			if(joueur.getVie()<=0)
			{
				win = false;
				break;
			}
			mechant.setVie(mechant.getVie() - random(0, joueur.getDps()));
			if(mechant.getVie()<=0)
				win = true;
		}
		return win;
	}
	
	public void gagner(Joueur joueur) {
		System.out.println("Victoire ! Tu as gagné "+this.nom+" !\n\n");
		this.setEtat(joueur.getNom());
		joueur.gagnerBatimentsJoueur(this);
	}
	
	public void perdre(Joueur joueur) {
		System.out.println("Defaite ! Tu as perdu "+this.nom+" !\n\n");
		this.setEtat("");
		joueur.perdreBatimentsJoueur(this);
	}
	
	public void victoire() {
		System.out.println("Victoire ! Tu as réussi à défendre "+this.nom+" !\n\n");
	}
	
	public void defaite() {
		System.out.println("Defaite ! Tu as échoué dans la conquête de "+this.nom+" !\n\n");
	}
	
	
	
	public int random(int min, int max) {
		
		return (int)(Math.random()*(max+1-min)+min);
		
	}
	
	public void genererMechants(List<Mechant> mechants) {
		Mechant kevin = new Mechant("Flash sensible", 24, 1);
		Mechant thibault = new Mechant("Papy", 5, 31);
		Mechant yves = new Mechant("Monsieur le juge", 50, 50);
		Mechant paola = new Mechant("Lapin", 0, 1);
		
		mechants.add(kevin);
		mechants.add(thibault);
		mechants.add(yves);
		mechants.add(paola);
	}

	
}
