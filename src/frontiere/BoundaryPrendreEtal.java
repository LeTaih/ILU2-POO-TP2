package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + "je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder renseignements = new StringBuilder();
		renseignements.append("C'est parfait, il me reste un étal pour vous !\n");
		renseignements.append("Il me faudrait quelques renseignements :\n");
		renseignements.append("Quel produit souhaitez-vous vendre ?");
		String produit = Clavier.entrerChaine(renseignements.toString());
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé a l'étal n°" + (numeroEtal+1));
		}
	}
}
