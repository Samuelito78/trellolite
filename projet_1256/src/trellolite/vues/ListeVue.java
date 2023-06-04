package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe ListeVue représente la vue d'une liste dans l'application Trellolite.
 * Elle affiche le titre de la liste, ainsi que les boutons et panneaux associés.
 * ell permet également de rafraîchir la page avec les nouvelles listes.
 *
 *@author Nawfel Kerarsi
 */
public class ListeVue extends JPanel {

    private JLabel titlePanel;
    private JLabel subtitlePanel;
    private JPanel headPanel;
    private JScrollPane bodyPanel;
    private ArrayList<JButton> listeBtnList;
    private JPanel listePanel;

    private JTextField nomField;

    /**
     * Constructeur de la classe ListeVue.
     * Initialise les composants de la vue de la liste.
     *
     * @param creeListeBtn    Le bouton de création de liste.
     * @param listePanelliste La liste des panneaux de liste.
     * @param nom             Le nom de la liste.
     */
    public ListeVue(JButton creeListeBtn, ArrayList<JPanel> listePanelliste, String nom) {
        setLayout(new BorderLayout());
        setOpaque(false);

        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);
        bodyPanel = new JScrollPane(contentPanel);
        bodyPanel.setOpaque(false);
        bodyPanel.getViewport().setOpaque(false);
        bodyPanel.getVerticalScrollBar().setOpaque(false);
        bodyPanel.setBorder(null);


        ((JPanel) bodyPanel.getViewport().getView()).setOpaque(false);
        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        this.titlePanel = new JLabel("<html><b>" + nom + "</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        this.subtitlePanel = new JLabel();
        subtitlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(), 60));
        subtitlePanel.setForeground(Color.decode("#B9B9B9"));

        headPanel.add(titlePanel, BorderLayout.WEST);

        GridBagConstraints gbcSubTitle = new GridBagConstraints();
        gbcSubTitle.fill = GridBagConstraints.HORIZONTAL;
        gbcSubTitle.gridx = 0;
        gbcSubTitle.gridy = 0;
        gbcSubTitle.weightx = 1.0;

        ((JPanel) bodyPanel.getViewport().getView()).add(subtitlePanel, gbcSubTitle);

        listePanel = new JPanel();
        listePanel.setOpaque(false);

        GridBagConstraints gbcListePanel = new GridBagConstraints();
        gbcListePanel.fill = GridBagConstraints.BOTH;
        gbcListePanel.gridx = 0;
        gbcListePanel.gridy = 1;
        gbcListePanel.weightx = 1.0;
        gbcListePanel.weighty = 1.0;
        ((JPanel) bodyPanel.getViewport().getView()).add(listePanel, gbcListePanel);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        buttonPanel.add(creeListeBtn, gbc);

        headPanel.add(buttonPanel, BorderLayout.EAST);

        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);

        this.refreshPage(listePanelliste);
    }

    /**
     * Met à jour les composants de la page de la liste.
     *
     * @param listePanelliste La liste des panneaux de liste.
     */
    public void refreshPage(ArrayList<JPanel> listePanelliste) {
        String subtitleText = (listePanelliste != null && listePanelliste.size() > 0) ? "VOS LISTES" : "VOUS N'AVEZ AUCUNE LISTE";
        this.subtitlePanel.setText(subtitleText);
        listePanel.removeAll();

        int numColumns = 3;
        listePanel.setLayout(new GridLayout(0, numColumns, 10, 10));

        for (JPanel panelBtn : listePanelliste) {
            listePanel.add(panelBtn);
        }
        for (int k = 0; k < 3; k++) {
            JPanel emptyPanel = new JPanel();
            emptyPanel.setOpaque(false);
            listePanel.add(emptyPanel);
        }

        listePanel.revalidate();
        listePanel.repaint();
    }

    /**
     * Affiche le formulaire de création de liste.
     *
     * @param submitListeBtn  Le bouton de soumission du formulaire.
     * @param returnListeBtn  Le bouton de retour du formulaire.
     * @param dialog          Le dialogue pour afficher le formulaire.
     * @param label           Le label du formulaire.
     */
    public void afficheForm(JButton submitListeBtn, JButton returnListeBtn, JDialog dialog, JLabel label) {
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setResizable(false);

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.setBackground(Color.decode("#252526"));


        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        this.nomField = new JTextField();
        this.nomField.setBackground(Color.decode("#111111"));
        this.nomField.setForeground(Color.WHITE);
        this.nomField.setPreferredSize(new Dimension(nomField.getPreferredSize().width, 40));
        formPanel.add(this.nomField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.decode("#252526"));

        submitListeBtn.setPreferredSize(new Dimension(140, 40));
        submitListeBtn.setBackground(Color.decode("#1a8754"));
        submitListeBtn.setForeground(Color.WHITE);
        submitListeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitListeBtn.setOpaque(true);

        returnListeBtn.setPreferredSize(new Dimension(returnListeBtn.getPreferredSize().width, 40));
        returnListeBtn.setBackground(Color.decode("#252526"));
        returnListeBtn.setForeground(Color.WHITE);
        returnListeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        returnListeBtn.setOpaque(true);
        buttonPanel.add(returnListeBtn);
        buttonPanel.add(submitListeBtn);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(formPanel);

        dialog.pack();

        Point location = this.getLocationOnScreen();
        int x = location.x + this.getWidth() / 2 - dialog.getWidth() / 2;
        int y = location.y + this.getHeight() / 2 - dialog.getHeight() / 2;
        dialog.setLocation(x, y);

        dialog.setVisible(true);
    }

    /**
     * Récupère le nom de la liste saisi dans le formulaire.
     *
     * @return Le nom de la liste.
     */
    public String getNom() {
        return this.nomField.getText();
    }
}
