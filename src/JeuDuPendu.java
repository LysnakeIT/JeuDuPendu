/**
 * Cette classe met en oeuvre le jeu du pendu
 * @author L.Damien
 */


class JeuDuPendu {
	
	
	/**
	 * Création d’un dictionnaire de mots
	 * @return dictionnaire initialisé
	 */
	 
	String[] creerDico() {
		String[] dico = {"manger", "ordinateur", "voiture", "table",
							"un", "jardin", "anticorps"};
		return dico;
	}
	 
	 
	/**
	 * choix aléatoire d'un mot dans un dictionnaire
	 * @param dico dictionnaire des mots à choisir
	 * @return chaine choisie de manière aléatoire
	 */
	 
	 String choisirMot (String[] dico) {
		 int i =(int) (Math.random() * dico.length);
		 String mot = dico[i];
		 return mot;
	 }
	
	/**
	 * affiche la réponse du joueur
	 * @param reponse reponse du joueur
	 */
	 
	 void afficherReponse(char[] reponse) {
		 for (int i = 0 ; i < reponse.length; i++) {
			 System.out.print (reponse[i] + " ");
		 }
		 System.out.println();
	 }
	 
	 /**
	  * création d’un tableau de reponse contenant des ’_’
	  * @param lg longueur du tableau à créer
	  * @return tableau de reponse contenant des ’_’
	  */
	  
	  char[] creerReponse(int lg) {
		  char[] tab = new char [lg];
		  for ( int i = 0; i < tab.length; i++) {
			  tab[i] = '_';
		  }
		  return tab;
	  }
	  
	/**
	 * teste la présence d’un caractère dans le mot
	 * et le place au bon endroit dans réponse
	 * @param mot mot à deviner
	 * @param reponse réponse à compléter si le caractère est présent dans le mot
	 * @param car caractère à chercher dans le mot
	 * @return vrai ssi le caractère est dans le mot à deviner
	 */
	 
	 boolean tester (String mot, char[] reponse, char car){
		 boolean check = false;
		 int i = 0;
		 while(i < mot.length()) {
			 if (car == mot.charAt(i)) {
				 reponse[i] = car;
				 check = true;
			 }
			 i++;
		 }
		 return check;
	 }
	 
	 /**
	 * rend vrai ssi le mot est trouvé
	 * @param mot mot à deviner
	 * @param reponse réponse du joueur
	 * @return vrai ssi le mot est égal caractère par caractère à la réponse
	 */
	 
	boolean estComplet (String mot, char[] reponse) {
		boolean check = false;
		boolean result = true;
		 int i = 0;
		 while(i < mot.length() && result) {
			 if (reponse[i] != mot.charAt(i)) {
				 result = false;
			 }	 
			 i++;
		 }
		 return result;
	 }
	  
	/**
	 * lancement d’une partie du jeu du pendu
	 * @param dico dictionnaire des mots à deviner
	 */
	 
	void partie(String[] dico) {
		
		int compteur = 9;
		String mot = choisirMot(dico);
		char[] reponse = (creerReponse (mot.length()));
		boolean perdu = false;
		boolean check = false;
		
		while (!perdu && !check) {
			afficherReponse(reponse);
			System.out.println();
			System.out.println("Nombre d'erreurs restantes : " + compteur); 
			char car = SimpleInput.getChar("Entrer un lettre à deviner");
			boolean estBon = tester(mot,reponse, car);
			if (!estBon) {
				compteur = compteur - 1;
				System.out.println();
				System.out.println("Mauvaise réponse");
			}
			if (compteur <= 0) {
				perdu = true;
				System.out.println();
				System.out.println("Vous avez perdu !");
				System.out.println("Le mot est " + mot);
			}
			if(estComplet(mot,reponse)) {
				perdu = true;
				System.out.println();
				System.out.println("Vous avez gagné!");
				System.out.println("Le mot est " + mot);
			}
		}
	}
	
	void principal() {
		System.out.println("Bienvenue dans le jeu du pendu !!!");
		String[] dico = creerDico();
		partie(dico);
	}
}
