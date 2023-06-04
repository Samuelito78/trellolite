package trellolite.vues;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Color;

/**
 * La classe NavBarVue représente la barre de navigation de l'application.
 *
 * @author Samuel Boix-Segura
 */
public class NavBarVue extends JPanel{
    // Déclaration d'un attribut pour le bouton de projet
    private JPanel projectButton;

    /**
     * Constructeur de la classe NavBarVue.
     * 
     * @param projectButton Le bouton projet à afficher dans la barre de navigation.
     * @param navButtonPannel Le panneau de boutons à afficher dans la barre de navigation.
     */
    // Définition du constructeur de la classe NavBarVue
    public NavBarVue(JPanel projectButton, JPanel navButtonPannel){
        // Chargement de l'icône à partir de l'emplacement spécifié
        ImageIcon originalIcon = new ImageIcon("src/trellolite/ressources/images/trelite.png");
        // Extraction de l'image de l'icône
        Image originalImage = originalIcon.getImage();
        // Redimensionnement de l'image à une taille spécifique
        Image resizedImage = originalImage.getScaledInstance(120, 24, Image.SCALE_SMOOTH);
        // Création d'une nouvelle icône avec l'image redimensionnée
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Définition du gestionnaire de disposition du panneau comme BorderLayout
        setLayout(new BorderLayout());
        // Définition de la taille préférée du panneau
        setPreferredSize(new Dimension(260, 0));
        // Définition de la couleur d'arrière-plan du panneau
        setBackground(Color.decode("#252526"));
        // Ajout du bouton de projet au sud (bas) du panneau
        add(projectButton, BorderLayout.SOUTH);

        // Création d'un label avec l'icône redimensionnée
        JLabel label = new JLabel(resizedIcon);
        // Définition de la bordure du label
        label.setBorder(new EmptyBorder(20,0,20,0));
        // Ajout du label au nord (haut) du panneau
        add(label, BorderLayout.NORTH);
        // Ajout du panneau de boutons au centre du panneau
        add(navButtonPannel, BorderLayout.CENTER);
    }
}
