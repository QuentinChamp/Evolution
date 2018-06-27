package evolution;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
	private String nom;
	private int dps; 
	private int vie;
	private List<Batiment> batimentsJoueur = new ArrayList<Batiment>();
	private List<Ville> villesJoueur = new ArrayList<Ville>();
	private int stockNourriture;
	private int stockHabitant;
	private int stockPierre;
	private int stockEnergie;
	
	public Joueur(String nom, int dps, int vie) {
		super();
		
		this.nom = nom;
		this.dps = dps;
		this.vie = vie;
	}


	public String getNom() {
		return nom;
	}


	public int getDps() {
		return dps;
	}


	public void setDps(int dps) {
		this.dps = dps;
	}


	public int getVie() {
		return vie;
	}


	public void setVie(int vie) {
		this.vie = vie;
	}


	public List<Batiment> getBatimentsJoueur() {
		return batimentsJoueur;
	}


	public void gagnerBatimentsJoueur(Batiment batiment) {
		this.batimentsJoueur.add(batiment);
	}
	
	public void perdreBatimentsJoueur(Batiment batiment) {
		this.batimentsJoueur.remove(batiment);
	}

	public List<Ville> getVillesJoueur() {
		return villesJoueur;
	}

	public void setVillesJoueur(List<Ville> villesJoueur) {
		this.villesJoueur = villesJoueur;
	}
	
	public void affichageBatimentJoueur() {
		for (Batiment a : this.batimentsJoueur) {
			
			System.out.println(a.getNom());
		}
	}
	
	public void augmenterStock() {
				
		for (int i = 0 ; i <getBatimentsJoueur().size() ; i++)
		{
			switch(getBatimentsJoueur().get(i).getRessource().getNom())
			{
			case "NOURRITURE" :
				this.stockNourriture += getBatimentsJoueur().get(i).getStock();
				break;
			case "HABITANT" :
				this.stockHabitant += getBatimentsJoueur().get(i).getStock();
				break;
			case "PIERRE" :
				this.stockPierre += getBatimentsJoueur().get(i).getStock();
				break;
			case "ENERGIE" :
				this.stockEnergie += getBatimentsJoueur().get(i).getStock();
				break;
			default :
				break;
			}		
			
		}
		
		
	}
	
	public void utilisationStock() {
		
	}
	
	
	
}
