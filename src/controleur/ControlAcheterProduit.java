package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return(controlVerifierIdentite.verifierIdentite(nomVendeur));
	}
	
	public String[] vendeursProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = null;
		if (vendeurs != null) {
			nomVendeurs = new String[vendeurs.length];
			for (int i = 0; i < vendeurs.length; i++) {
				nomVendeurs[i] = vendeurs[i].getNom();
			}
		}
		return(nomVendeurs);
	}
	
	public String acheterProduit(String produit, int nbProduit, String nomVendeur, String nomAcheteur) {
		String res = (nomAcheteur + " n'a pas réussi à acheter " + nbProduit + " " + produit + " à " + nomVendeur);
		int quantiteAchete = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(nbProduit);
		if (quantiteAchete == 0) {
			res = (nomAcheteur + " veut acheter " + nbProduit + " " + produit +", malheureusement il n’y en a plus !");
		}
		else if (quantiteAchete < nbProduit) {
			res = (nomAcheteur + " veut acheter "+ nbProduit + " " + produit +", malheureusement "+ nomVendeur + " n’en a plus que " + nbProduit + ". "+ nomAcheteur + " achète tout le stock de "+ nomVendeur +".");

		}
		else if (quantiteAchete == nbProduit) {
			res = (nomAcheteur + " achète " + nbProduit + " " + produit + " à " + nomVendeur);
		}
		return(res);
	}
}
