package evolution;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		

		boolean win = true;
		boolean jouer = true;
		
		intro();
		Graph.evolutionIntro2();
		Scanner sc = new Scanner(System.in);

		System.out.println("Nom du joueur?");
		String pseudo = sc.nextLine();
		
		System.out.println("Bonjour " + pseudo);

		Joueur joueur = new Joueur(pseudo, 20, 100);
		Secteur secteurs[] = genererSecteurs();


		while(jouer == true)
		{
			byte choix = menu(sc);

			switch(choix)
			{
			case 1 :
				win = menuAttaque(sc, secteurs, joueur).attaquer(joueur);
				joueur.augmenterStock();
				break;
			case 2 :
				joueur.affichageBatimentJoueur();
				break;
			case 3 :
				utilisationStock(sc, secteurs, joueur);
				break;
			
			}
			
			
		}
		
		sc.close();
	}

	private static byte menu(Scanner sc) {
		
		byte choix = 0;
		do{
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1- Attaquer");
		System.out.println("2- Afficher possession");
		System.out.println("3- Utilisation ressource");
		
			choix = sc.nextByte();
			if(choix<1 || choix>3)
				System.out.println("Votre réponse doit être comprise entre 1 et 3 ! è_é");
		}while(choix<1 || choix>3);
		return choix;
		
		
	}

	public static void utilisationStock(Scanner sc, Secteur[] secteurs,Joueur joueur) {
		byte choix = 0;

		do{
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1- Soin");
		System.out.println("2- Ameliorer");
		System.out.println("3- Achat");
		
			choix = sc.nextByte();

			if(choix<1 || choix>3)
				System.out.println("Votre réponse doit être comprise entre 1 et 3 ! è_é");
		}while(choix<1 || choix>3);
		
		if (choix == 1)
		{
			joueur.soin();
		}
		else if (choix == 2)
		{
			
		}
		else if (choix == 3)
		{
			menuAchat(sc, secteurs, joueur);
		}
	}
	
	private static void menuAchat(Scanner sc, Secteur[] secteurs, Joueur joueur) {
		byte choix = 0, secteur = 0, ville = 0, batiment = 0;
		boolean verif=false;

		//cout de contruction
		while(verif==false) {
			do{
				System.out.println("Choisissez un secteur :");
				for(int i=0; i<secteurs.length;i++)
					System.out.println(i+"- "+secteurs[i].getNom());

				choix = sc.nextByte();
				if(choix<0 || choix>=secteurs.length)
					System.out.println("Votre réponse doit être comprise entre 0 et "+(secteurs.length-1)+" ! è_é");
			}while(choix<0 || choix>=secteurs.length);
			secteur = choix;

			do{
				System.out.println("Choisissez une ville  :");
				for(int i=0; i<secteurs[secteur].getVille().length;i++)
					System.out.println(i+"- "+secteurs[secteur].getVille()[i].getNom());

				choix = sc.nextByte();
				if(choix<0 || choix>=secteurs[secteur].getVille().length)
					System.out.println("Votre réponse doit être comprise entre 0 et "+(secteurs[secteur].getVille().length-1)+" ! è_é");
			}while(choix<0 || choix>=secteurs[secteur].getVille().length);
			ville = choix;

			do{
				System.out.println("Choisissez un bâtiment à acheté:");
				for(int i=0; i<secteurs[secteur].getVille()[ville].getBatiment().size();i++)
					System.out.println(i+"- "+secteurs[secteur].getVille()[ville].getBatiment().get(i).getNom());

				choix = sc.nextByte();
				if(choix<0 || choix>=secteurs[secteur].getVille()[ville].getBatiment().size())
					System.out.println("Votre réponse doit être comprise entre 0 et "+(secteurs[secteur].getVille()[ville].getBatiment().size()-1)+" ! è_é");
			}while(choix<0 || choix>=secteurs[secteur].getVille()[ville].getBatiment().size());
			batiment = choix;
			
			if (secteurs[secteur].getVille()[ville].getBatiment().get(batiment).getEtat().equals(joueur.getNom()))
			{
				verif=false;
				System.out.println("Ce batiment est deja a vous ...");
			}
			else {
				verif=true;
				
			}
		}
		joueur.augmenterStock();
		
	}
	
	private static Batiment menuAttaque(Scanner sc, Secteur[] secteurs, Joueur joueur) {
		byte choix = 0, secteur = 0, ville = 0, batiment = 0;
		boolean verif=false;

		while(verif==false) {
			do{
				System.out.println("Choisissez un secteur à attaquer :");
				for(int i=0; i<secteurs.length;i++)
					System.out.println(i+"- "+secteurs[i].getNom());

				choix = sc.nextByte();
				if(choix<0 || choix>=secteurs.length)
					System.out.println("Votre réponse doit être comprise entre 0 et "+(secteurs.length-1)+" ! è_é");
			}while(choix<0 || choix>=secteurs.length);
			secteur = choix;

			do{
				System.out.println("Choisissez une ville à attaquer :");
				for(int i=0; i<secteurs[secteur].getVille().length;i++)
					System.out.println(i+"- "+secteurs[secteur].getVille()[i].getNom());

				choix = sc.nextByte();
				if(choix<0 || choix>=secteurs[secteur].getVille().length)
					System.out.println("Votre réponse doit être comprise entre 0 et "+(secteurs[secteur].getVille().length-1)+" ! è_é");
			}while(choix<0 || choix>=secteurs[secteur].getVille().length);
			ville = choix;

			do{
				System.out.println("Choisissez un bâtiment à attaquer :");
				for(int i=0; i<secteurs[secteur].getVille()[ville].getBatiment().size();i++)
					System.out.println(i+"- "+secteurs[secteur].getVille()[ville].getBatiment().get(i).getNom());

				choix = sc.nextByte();
				if(choix<0 || choix>=secteurs[secteur].getVille()[ville].getBatiment().size())
					System.out.println("Votre réponse doit être comprise entre 0 et "+(secteurs[secteur].getVille()[ville].getBatiment().size()-1)+" ! è_é");
			}while(choix<0 || choix>=secteurs[secteur].getVille()[ville].getBatiment().size());
			batiment = choix;
			
			if (secteurs[secteur].getVille()[ville].getBatiment().get(batiment).getEtat().equals(joueur.getNom()))
			{
				verif=false;
				System.out.println("Ce batiment est deja a vous ...");
			}
			else {
				verif=true;
				
			}
		}
		joueur.augmenterStock();
		return secteurs[secteur].getVille()[ville].getBatiment().get(batiment);
	}

	
	public static Secteur[] genererSecteurs() {
		int totalSecteurs =2;
		
		Secteur[] secteurs = new Secteur [totalSecteurs];
		
		secteurs[0] = new Secteur ("Picardie");
		
		secteurs[0].addVille(0, new Ville ("Amiens"));
		secteurs[0].addVille(1, new Ville ("Beauvais"));
		secteurs[0].addVille(2, new Ville ("Laon"));
		secteurs[0].addVille(3, new Ville ("Saint-Quentin"));
		secteurs[0].addVille(4, new Ville ("Abbeville"));
		
		secteurs[1] = new Secteur ("Grand Poney");
		
		secteurs[1].addVille(0, new Ville ("Shetland"));
		secteurs[1].addVille(1, new Ville ("Pottok"));
		secteurs[1].addVille(2, new Ville ("Connemara"));
		secteurs[1].addVille(3, new Ville ("Welsh"));
		secteurs[1].addVille(4, new Ville ("Haflinger"));
		
		secteurs[0].getVille()[0].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[0].getVille()[0].addBatiment(new Batiment("Chez JeanJean", 100 , 200 , Ressource.NOURRITURE));
		secteurs[0].getVille()[0].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[0].getVille()[0].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[0].getVille()[0].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		secteurs[0].getVille()[1].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[0].getVille()[1].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[0].getVille()[1].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[0].getVille()[1].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		secteurs[0].getVille()[2].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[0].getVille()[2].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[0].getVille()[2].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		
		secteurs[0].getVille()[3].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[0].getVille()[3].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[0].getVille()[3].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		secteurs[0].getVille()[4].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[0].getVille()[4].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[0].getVille()[4].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		
		secteurs[1].getVille()[0].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[1].getVille()[0].addBatiment(new Batiment("Chez JeanJean", 100 , 200 , Ressource.NOURRITURE));
		secteurs[1].getVille()[0].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[1].getVille()[0].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[1].getVille()[0].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		secteurs[1].getVille()[1].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[1].getVille()[1].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[1].getVille()[1].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[1].getVille()[1].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		secteurs[1].getVille()[2].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[1].getVille()[2].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[1].getVille()[2].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		
		secteurs[1].getVille()[3].addBatiment(new Batiment("Carouf", 100 , 200 , Ressource.NOURRITURE));
		secteurs[1].getVille()[3].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[1].getVille()[3].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		secteurs[1].getVille()[4].addBatiment(new Batiment("Casto", 100 , 200 , Ressource.PIERRE));
		secteurs[1].getVille()[4].addBatiment(new Batiment("EDP", 100 , 200 , Ressource.ENERGIE));
		secteurs[1].getVille()[4].addBatiment(new Batiment("IBIS", 100 , 200 ,  Ressource.HABITANT));
		
		return secteurs;
	}

	private static void intro() {
		System.out.println("Coucou, tu veux voir...");
		try {Thread.sleep(2500);}catch (Exception e){}
		System.out.println("...");
		try {Thread.sleep(2500);}catch (Exception e){}
		System.out.println("...");
		try {Thread.sleep(3000);}catch (Exception e){}
		Graph.evolutionIntro() ;
		System.out.println("?");
		try {Thread.sleep(2000);}catch (Exception e){}
		System.out.println("Un jeu developpé par la team JAVA");
		try {Thread.sleep(2000);}catch (Exception e){}
		System.out.println("Avec la participation de Ricard PREDATOR !!!");
		System.out.println("\n\n\n\n");
	}
	
	public static void title() {
		System.out.println("       ____    ____              ____               _______     ___  ______________   _________       ");
		System.out.println("      /    \\  /    \\            /    \\             |       \\   |   | |             | |   ______|  ");
		System.out.println("     /   __ \\/ __   \\          /      \\            |    o   |  |   | |____     ____| |   |         ");
		System.out.println("    /   /  \\  /  \\   \\        /   /\\   \\           |        /  |   |      |    |     |   |____   ");
		System.out.println("   /   /    \\/    \\   \\      /   /__\\   \\          |        \\  |   |      |    |     |   ____|  ");
		System.out.println("  /   /            \\   \\    /    ____    \\         |    O    | |   |      |    |     |   |         ");
		System.out.println(" /   /              \\   \\  /   /      \\   \\        |         | |   |      |    |     |   |______  ");
		System.out.println("/___/                \\___\\/___/        \\___\\       |________/  |___|      |____|     |_________|  ");
	}


}
