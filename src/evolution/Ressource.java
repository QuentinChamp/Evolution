package evolution;

import java.util.ArrayList;
import java.util.List;


public enum Ressource {

	NOURRITURE(1, "NOURRITURE"),
	PIERRE(2, "PIERRE"),
	HABITANT(3, "HABITANT"),
	ENERGIE(4, "ENERGIE");

	private int id;
	private String nom;

	Ressource (){
	}
	
	Ressource (int id, String nom){
		this.id=id;
		this.nom=nom;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	
}

