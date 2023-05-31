package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ListeVue extends JPanel {

    private JLabel titlePanel;
    private JLabel subttitlePanel;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private ArrayList<JButton> listeBtnList;
    private JPanel listePanel;

    private JTextField nomListeField;

    public ListeVue(JButton creeListeBtn, ArrayList<JPanel> listePanelliste, String nom){
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

        this.titlePanel = new JLabel("<html><b>"+nom+"</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        this.subttitlePanel = new JLabel();
        subttitlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(),60));
        subttitlePanel.setForeground(Color.decode("#B9B9B9"));

        headPanel.add(titlePanel, BorderLayout.WEST);

        GridBagConstraints gbcSubTitle = new GridBagConstraints();
        gbcSubTitle.fill = GridBagConstraints.HORIZONTAL;
        gbcSubTitle.gridx = 0;
        gbcSubTitle.gridy = 0;
        gbcSubTitle.weightx = 1.0;

        bodyPanel.add(subttitlePanel, gbcSubTitle);

        listePanel = new JPanel();
        listePanel.setOpaque(false);

        GridBagConstraints gbcListePanel = new GridBagConstraints();
        gbcListePanel.fill = GridBagConstraints.BOTH;
        gbcListePanel.gridx = 0;
        gbcListePanel.gridy = 1;
        gbcListePanel.weightx = 1.0;
        gbcListePanel.weighty = 1.0;
        bodyPanel.add(listePanel, gbcListePanel);

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

    public void refreshPage(ArrayList<JPanel> listePanelliste) {
        String subtitleText = (listePanelliste != null && listePanelliste.size() > 0) ? "VOS LISTES" : "VOUS N'AVEZ AUCUNE LISTE";
        this.subttitlePanel.setText(subtitleText);
        listePanel.removeAll();

        int numColumns = 3;
        listePanel.setLayout(new GridLayout(0, numColumns, 10, 10));

        for (JPanel panelBtn : listePanelliste) {
            listePanel.add(panelBtn);
        }
        for (int k=0; k<3;k++) {
            JPanel PanelVide = new JPanel();
            PanelVide.setOpaque(false);
            listePanel.add(PanelVide);
        }

        listePanel.revalidate();
        listePanel.repaint();
    }

    public void afficheForm(JButton submitListeBtn, JButton returnListeBtn, JDialog dialog){
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setTitle("Formulaire de création de liste");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setResizable(false);

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.setBackground(Color.decode("#252526"));

        JLabel label = new JLabel("Nom de la liste");
        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        this.nomListeField = new JTextField();
        this.nomListeField.setBackground(Color.decode("#111111"));
        this.nomListeField.setForeground(Color.WHITE);
        this.nomListeField.setPreferredSize(new Dimension(nomListeField.getPreferredSize().width, 40));
        formPanel.add(this.nomListeField, BorderLayout.CENTER);

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
        int x = location.x + this.getWidth()/2 - dialog.getWidth()/2;
        int y = location.y + this.getHeight()/2 - dialog.getHeight()/2;
        dialog.setLocation(x, y);

        dialog.setVisible(true);
    }


    public void afficheFormCarte(JButton submitListeBtn, JButton returnListeBtn, JDialog dialog, JPanel listePanel){
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setTitle("Formulaire de création de carte");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setResizable(false);

        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.setBackground(Color.decode("#252526"));

        JLabel label = new JLabel("Nom de la carte");
        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        this.nomListeField = new JTextField();
        this.nomListeField.setBackground(Color.decode("#111111"));
        this.nomListeField.setForeground(Color.WHITE);
        this.nomListeField.setPreferredSize(new Dimension(nomListeField.getPreferredSize().width, 40));
        formPanel.add(this.nomListeField, BorderLayout.CENTER);

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
        int x = location.x + this.getWidth()/2 - dialog.getWidth()/2;
        int y = location.y + this.getHeight()/2 - dialog.getHeight()/2;
        dialog.setLocation(x, y);

        dialog.setVisible(true);
    }

    public String getNom() {
        return this.nomListeField.getText();
    }
}
