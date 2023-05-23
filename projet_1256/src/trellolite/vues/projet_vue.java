package trellolite.vues;
import javax.swing.*;

public class projet_vue extends JPanel {
	// D?larer les composants comme attributs
	JLabel lLongeur ;
	JTextField tLongeur ;
	JLabel lLargeur ;
	JTextField tLargeur ;
	JLabel lResultat ;
	JLabel lValeurResultat ; 
	JButton bCalculer ;
	JButton bNettoyer ;
	
	// Constructeur 
	projet_vue() {
		// Initialiser les composants
		lLongeur = new JLabel ("Longueur :");
		tLongeur = new JTextField (20); 
		lLargeur = new JLabel ("Largeur :");
		tLargeur = new JTextField (20); 
		lResultat = new JLabel ("Resultat :");
		lValeurResultat = new JLabel ("0");
		bCalculer = new JButton ("Calculer");
		bNettoyer = new JButton ("Nettoyer");
		
		// Ajouter ces composants dans 
		// CE panneau p?imetre que je suis en train de construire
		add (lLongeur);
		add (tLongeur);
		add (lLargeur);
		add (tLargeur);
		add (lResultat);
		add (lValeurResultat);
		add (bCalculer);
		add (bNettoyer);
	}
	
	// M?hode main
	public static void main(String[] args) {
		// Creer une fenetre
		JFrame fenetre = new JFrame ("trelite");
		fenetre.setSize (800, 800);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Cr?r une instance de MA classe graphique
		projet_vue panneauPerimetre = new projet_vue () ;
		
		// Ajouter le panneau dans la fenetre
		fenetre.add(panneauPerimetre);

		// Afficher la fenetre
		fenetre.setVisible(true);

	}
}
