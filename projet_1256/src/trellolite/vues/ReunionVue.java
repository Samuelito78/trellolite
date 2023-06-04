package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe ReunionVue représente la vue des réunions d'un projet dans l'application Trellolite.
 * Elle affiche les réunions existantes et permet d'ajouter de nouvelles réunions.
 * 
 * @author Nawfel Kerarsi
 */
public class ReunionVue extends JPanel {
    private JLabel titlePanel;
    private JLabel subtitlePanel;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private ArrayList<JButton> reunionBtnList;
    private JPanel reunionPanel;

    private JTextField nomReunionField;

    /**
     * Constructeur de la classe ReunionVue.
     *
     * @param creeReunionBtn   Le bouton de création de réunion.
     * @param reunionBtnList   La liste des boutons représentant les réunions existantes.
     */
    public ReunionVue(JButton creeReunionBtn, ArrayList<JButton> reunionBtnList) {
        setLayout(new BorderLayout());
        setOpaque(false);

        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));

        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout());
        bodyPanel.setOpaque(false);

        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        this.titlePanel = new JLabel("<html><b>Réunions</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        String subtitleText = (reunionBtnList != null && reunionBtnList.size() > 0) ? "VOS REUNIONS" : "VOUS N'AVEZ AUCUNE REUNION";
        this.subtitlePanel = new JLabel(subtitleText);
        subtitlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(), 60));
        subtitlePanel.setForeground(Color.decode("#B9B9B9"));

        headPanel.add(titlePanel, BorderLayout.WEST);

        GridBagConstraints gbcSubTitle = new GridBagConstraints();
        gbcSubTitle.fill = GridBagConstraints.HORIZONTAL;
        gbcSubTitle.gridx = 0;
        gbcSubTitle.gridy = 0;
        gbcSubTitle.weightx = 1.0;

        bodyPanel.add(subtitlePanel, gbcSubTitle);

        reunionPanel = new JPanel();
        reunionPanel.setOpaque(false);

        GridBagConstraints gbcReunionPanel = new GridBagConstraints();
        gbcReunionPanel.fill = GridBagConstraints.BOTH;
        gbcReunionPanel.gridx = 0;
        gbcReunionPanel.gridy = 1;
        gbcReunionPanel.weightx = 1.0;
        gbcReunionPanel.weighty = 1.0;

        bodyPanel.add(reunionPanel, gbcReunionPanel);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        buttonPanel.add(creeReunionBtn, gbc);

        headPanel.add(buttonPanel, BorderLayout.EAST);

        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }

    /**
     * Met à jour la vue des réunions.
     *
     * @param reunionBtnList   La liste des boutons représentant les réunions existantes.
     */
    public void refreshPage(ArrayList<JButton> reunionBtnList) {
        String subtitleText = (reunionBtnList != null && reunionBtnList.size() > 0) ? "VOS REUNIONS" : "VOUS N'AVEZ AUCUNE REUNION";
        this.subtitlePanel.setText(subtitleText);
        reunionPanel.removeAll();

        int numColumns = 4;
        reunionPanel.setLayout(new GridLayout(0, numColumns, 10, 10));

        for (JButton reunionBtn : reunionBtnList) {
            reunionPanel.add(reunionBtn);
        }

        for (int k=0; k<8;k++) {
            JPanel PanelVide = new JPanel();
            PanelVide.setOpaque(false);
            reunionPanel.add(PanelVide);
        }

        reunionPanel.revalidate();
        reunionPanel.repaint();
    }

    /**
     * Affiche le formulaire de création de réunion dans une boîte de dialogue.
     *
     * @param submitReunionBtn   Le bouton de soumission du formulaire.
     * @param returnReunionBtn   Le bouton de retour du formulaire.
     * @param dialog             La boîte de dialogue pour afficher le formulaire.
     */
    public void afficheForm(JButton submitReunionBtn, JButton returnReunionBtn, JDialog dialog){
        // Création de la JDialog
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setTitle("Formulaire de création de réunion");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Ajuste la taille de la JDialog
        dialog.setResizable(false);

        // Création du formulaire
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Setting the background color
        formPanel.setBackground(Color.decode("#252526"));

        // Ajout du label
        JLabel label = new JLabel("Nom de la réunion");
        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        // Champ de saisie pour le nom de la réunion
        this.nomReunionField = new JTextField();
        this.nomReunionField.setBackground(Color.decode("#111111"));
        this.nomReunionField.setForeground(Color.WHITE);
        this.nomReunionField.setPreferredSize(new Dimension(nomReunionField.getPreferredSize().width, 40));
        formPanel.add(this.nomReunionField, BorderLayout.CENTER);

        // Boutons submit et return
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.decode("#252526"));

        // Personnalisation du bouton submitReunionBtn
        submitReunionBtn.setPreferredSize(new Dimension(140, 40));
        submitReunionBtn.setBackground(Color.decode("#1a8754"));
        submitReunionBtn.setForeground(Color.WHITE);
        submitReunionBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitReunionBtn.setOpaque(true);
        // Personnalisation du bouton returnReunionBtn
        returnReunionBtn.setPreferredSize(new Dimension(returnReunionBtn.getPreferredSize().width, 40));
        returnReunionBtn.setBackground(Color.decode("#252526"));
        returnReunionBtn.setForeground(Color.WHITE);
        returnReunionBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        returnReunionBtn.setOpaque(true);
        buttonPanel.add(returnReunionBtn);
        buttonPanel.add(submitReunionBtn);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajout du formulaire à la JDialog
        dialog.add(formPanel);

        // Affichage de la JDialog
        dialog.pack();

        // Calcul et définition de la position de la JDialog pour la centrer par rapport à la JPanel
        Point location = this.getLocationOnScreen();
        int x = location.x + this.getWidth()/2 - dialog.getWidth()/2;
        int y = location.y + this.getHeight()/2 - dialog.getHeight()/2;
        dialog.setLocation(x, y);

        // Rendre la JDialog visible
        dialog.setVisible(true);
    }

    /**
     * Récupère le nom de la réunion saisi dans le formulaire.
     *
     * @return Le nom de la réunion.
     */
    public String getNom() {
        return this.nomReunionField.getText();
    }
}
