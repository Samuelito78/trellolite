package trellolite.views;
import javax.swing.*;
import java.awt.*;

public class projet_vue extends JPanel 
{
public static void main(String[] args) {
	// Crée une nouvelle JFrame
	JFrame frame = new JFrame("Trelite");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1000, 600); // définit la taille de la fenêtre

	// Crée le bandeau latéral
	JPanel sidebar = new JPanel();
	sidebar.setBackground(Color.GRAY); // définit la couleur de fond
	sidebar.setPreferredSize(new Dimension(200, 600)); // définit la taille

	// Ajoute le bandeau latéral à la JFrame
	frame.getContentPane().add(sidebar, BorderLayout.WEST);

	// Crée un JPanel principal
	JPanel mainPanel = new JPanel();
	mainPanel.setBackground(Color.WHITE); // définit la couleur de fond

	// Crée un nouveau JButton
	JButton button = new JButton("Nouveau Tableau");
	button.setBounds(1000, 60, 50, 50); // définit la position et la taille du bouton

	// Ajoute le bouton au JPanel principal
	mainPanel.add(button);

	// Ajoute le JPanel principal à la JFrame
	frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

	// Affiche la fenêtre
	frame.setVisible(true);
	}
}
