package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (acheteurConnu) {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] nomVendeurs = controlAcheterProduit.vendeursProduit(produit);
			if (nomVendeurs == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
				for(int i=0; i< nomVendeurs.length; i++) {
					question.append((i+1) + " - " + nomVendeurs[i] + "\n");
				}
				int choixUtilisateur = -1;
				while (choixUtilisateur < 0 && choixUtilisateur > nomVendeurs.length) {
					choixUtilisateur = Clavier.entrerEntier(question.toString());
					if (choixUtilisateur < 0 && choixUtilisateur > nomVendeurs.length) {
						System.out.println("Vous devez entrer un choix entre 1 et " + nomVendeurs.length);
					}
				}
				String nomVendeur = nomVendeurs[choixUtilisateur];
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
			}
		} 
		else {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		// TODO Ã  completer
	}
}
