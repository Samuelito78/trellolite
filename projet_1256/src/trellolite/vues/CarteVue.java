package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CarteVue extends JPanel {
    JLabel nomCarteLabel;
    JLabel nomListeLabel;
    JLabel titlePanel;
    JPanel headPanel;
    JPanel bodyPanel;
    JPanel carteModifPanel;

    JTextField nomField;
    JPanel commentairePanel;
    JPanel etiquettePanel;
    ArrayList<String> commentaireList;
    ArrayList<String> etiquetteList;

    JTextField nomCarteField;
    JTextField descriptionCarteField;
    SpinnerDateModel smDebut;
    SpinnerDateModel smFin;

    public CarteVue(String nomCarte, String descriptionCarte, Date dateDebut, Date dateFin, ArrayList<String> commentaireList, ArrayList<String> etiquetteList, String nomTableau, JButton crossReturn, JButton ajouterCommentaireBtn, JButton ajouterEtiquetteBtn, JButton submitBtn){
        this.commentaireList = commentaireList;
        this.etiquetteList = etiquetteList;
        setLayout(new BorderLayout());
        setOpaque(false);

        // Initialisation et configuration du panneau d'en-tête
        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        // Définition de la taille préférée pour forcer la hauteur à 75px
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));

        // Initialisation et configuration du panneau général
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setOpaque(false);

        // Ajout d'un espace vide de 20px en haut et en bas de carteModifPanel
        bodyPanel.add(Box.createVerticalStrut(20));

        carteModifPanel = new JPanel(new BorderLayout());
        carteModifPanel.setOpaque(true);
        carteModifPanel.setBackground(Color.decode("#252526"));

        JPanel coteGaucheModifPanel = new JPanel(new BorderLayout());
        coteGaucheModifPanel.setOpaque(false);
        coteGaucheModifPanel.setPreferredSize(new Dimension(90, 0));
        coteGaucheModifPanel.add(crossReturn, BorderLayout.NORTH);
        carteModifPanel.add(coteGaucheModifPanel, BorderLayout.WEST);

        JPanel coteDroitModifPanel = new JPanel();
        coteDroitModifPanel.setOpaque(false);
        coteDroitModifPanel.setPreferredSize(new Dimension(90, 0));
        carteModifPanel.add(coteDroitModifPanel, BorderLayout.EAST);

        JPanel formModifPanel = new JPanel(new BorderLayout());
        formModifPanel.setLayout(new BoxLayout(formModifPanel, BoxLayout.Y_AXIS));
        formModifPanel.setOpaque(false);
        carteModifPanel.add(formModifPanel, BorderLayout.CENTER);


        JPanel labelPanel1 = new JPanel(new BorderLayout());
        labelPanel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        labelPanel1.setOpaque(false);
        formModifPanel.add(labelPanel1);


        JLabel nomCarteLabel = new JLabel("<html><b>Nom de la carte</b><html>");
        nomCarteLabel.setForeground(Color.white);
        labelPanel1.add(nomCarteLabel);

        JLabel dateDebutLabel = new JLabel("<html><b>Date de début</b><html>");
        dateDebutLabel.setForeground(Color.white);
        dateDebutLabel.setPreferredSize(new Dimension(210,0));
        labelPanel1.add(dateDebutLabel, BorderLayout.EAST);



        JPanel fieldPanel1 = new JPanel(new BorderLayout());
        fieldPanel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        fieldPanel1.setOpaque(false);
        formModifPanel.add(fieldPanel1);

        nomCarteField = new JTextField();
        nomCarteField.setText(nomCarte);
        nomCarteField.setForeground(Color.white);
        nomCarteField.setBackground(Color.decode("#111111"));
        fieldPanel1.add(nomCarteField);


        smDebut = new SpinnerDateModel(dateDebut, null, null, Calendar.HOUR_OF_DAY);
        JSpinner dateSpinnerDebut = new JSpinner(smDebut);
        dateSpinnerDebut.setEditor(new JSpinner.DateEditor(dateSpinnerDebut, "dd/MM/yyyy"));
        JComponent editorDebut = dateSpinnerDebut.getEditor();
        JSpinner.DefaultEditor spinnerEditorDebut = (JSpinner.DefaultEditor)editorDebut;
        spinnerEditorDebut.getTextField().setBackground(Color.decode("#111111"));
        spinnerEditorDebut.getTextField().setForeground(Color.WHITE);
        dateSpinnerDebut.setPreferredSize(new Dimension(210, 0));
        fieldPanel1.add(dateSpinnerDebut, BorderLayout.EAST);


        JPanel labelPanel2 = new JPanel(new BorderLayout());
        labelPanel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        labelPanel2.setOpaque(false);
        formModifPanel.add(labelPanel2);

        JLabel descriptionCarteLabel = new JLabel("<html><b>Description de la carte</b><html>");
        descriptionCarteLabel.setForeground(Color.white);
        labelPanel2.add(descriptionCarteLabel);

        JLabel dateFinLabel = new JLabel("<html><b>Date de fin</b><html>");
        dateFinLabel.setForeground(Color.white);
        dateFinLabel.setPreferredSize(new Dimension(210,0));
        labelPanel2.add(dateFinLabel, BorderLayout.EAST);


        JPanel fieldPanel2 = new JPanel(new BorderLayout());
        fieldPanel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        fieldPanel2.setOpaque(false);
        formModifPanel.add(fieldPanel2);

        descriptionCarteField = new JTextField();
        descriptionCarteField.setText(descriptionCarte);
        descriptionCarteField.setForeground(Color.white);
        descriptionCarteField.setBackground(Color.decode("#111111"));
        fieldPanel2.add(descriptionCarteField);

        smFin = new SpinnerDateModel(dateFin, null, null, Calendar.HOUR_OF_DAY);
        JSpinner dateSpinnerFin = new JSpinner(smFin);
        dateSpinnerFin.setEditor(new JSpinner.DateEditor(dateSpinnerFin, "dd/MM/yyyy"));
        JComponent editorFin = dateSpinnerFin.getEditor();
        JSpinner.DefaultEditor spinnerEditorFin = (JSpinner.DefaultEditor)editorFin;
        spinnerEditorFin.getTextField().setBackground(Color.decode("#111111"));
        spinnerEditorFin.getTextField().setForeground(Color.WHITE);
        dateSpinnerFin.setPreferredSize(new Dimension(210, 0));
        fieldPanel2.add(dateSpinnerFin, BorderLayout.EAST);


        // Ajout du ChangeListener au modèle du premier JSpinner
        smDebut.addChangeListener(e -> {
            // Obtention des valeurs actuelles des modèles
            Date debut = smDebut.getDate();
            Date fin = smFin.getDate();

            // Vérification et ajustement des valeurs
            if (debut.after(fin)) {
                smFin.setValue(debut);
            }
        });


        // Ajout du ChangeListener au modèle du deuxième JSpinner
        smFin.addChangeListener(e -> {
            // Obtention des valeurs actuelles du modèle
            Date debut = smDebut.getDate();
            Date fin = smFin.getDate();

            // Vérification et ajustement des valeurs
            if (fin.before(debut)) {
                smDebut.setValue(fin);
            }
        });

        JPanel labelPanel3 = new JPanel(new BorderLayout());
        labelPanel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        labelPanel3.setOpaque(false);
        formModifPanel.add(labelPanel3);

        JLabel commentaireCarteLabel = new JLabel("<html><b>Commentaires<html>");
        commentaireCarteLabel.setForeground(Color.white);
        labelPanel3.add(commentaireCarteLabel);

        JLabel etiquetteLabel = new JLabel("<html><b>Étiquettes</b><html>");
        etiquetteLabel.setForeground(Color.white);
        etiquetteLabel.setPreferredSize(new Dimension(210,0));
        labelPanel3.add(etiquetteLabel, BorderLayout.EAST);

        JPanel fieldPanel3 = new JPanel(new BorderLayout());
        fieldPanel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        fieldPanel3.setPreferredSize(new Dimension(Integer.MAX_VALUE, 100));
        fieldPanel3.setOpaque(false);

        // Création d'un panel interne pour l'ajouter plus tard dans JScrollPane
        this.commentairePanel = new JPanel();
        commentairePanel.setLayout(new BoxLayout(commentairePanel, BoxLayout.Y_AXIS)); // You can use any layout
        commentairePanel.setBackground(Color.decode("#111111"));

        for (String commentaire : commentaireList) {
            JLabel comLabel = new JLabel(commentaire);
            comLabel.setForeground(Color.white);
            commentairePanel.add(comLabel);
            commentairePanel.setBackground(Color.decode("#111111"));
        }

        // Ajoute JScrollPane à fieldPanel3
        JScrollPane scrollPaneCommentaire = new JScrollPane(commentairePanel);
        scrollPaneCommentaire.setPreferredSize(new Dimension(Integer.MAX_VALUE, 100));
        scrollPaneCommentaire.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneCommentaire.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneCommentaire.setBounds(50, 30, 200, 50);

        fieldPanel3.add(scrollPaneCommentaire);

        // Création d'un panel interne pour l'ajouter plus tard dans JScrollPane
        etiquettePanel = new JPanel();
        etiquettePanel.setLayout(new BoxLayout(etiquettePanel, BoxLayout.Y_AXIS));
        etiquettePanel.setBackground(Color.decode("#111111"));
        for (String etiquette : etiquetteList) {
            JLabel etiLabel = new JLabel(etiquette);
            etiLabel.setForeground(Color.white);
            etiquettePanel.add(etiLabel);
            etiquettePanel.setBackground(Color.decode("#111111"));
        }

        // Ajoute JScrollPane à etiquettePanel
        JScrollPane scrollPaneEtiquette = new JScrollPane(etiquettePanel);
        scrollPaneEtiquette.setPreferredSize(new Dimension(210, 100));
        scrollPaneEtiquette.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPaneEtiquette.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneEtiquette.setBounds(50, 30, 200, 50);

        // Ajoute scrollPaneEtiquette à fieldPanel3 à l'EST
        fieldPanel3.add(scrollPaneEtiquette, BorderLayout.EAST);

        formModifPanel.add(fieldPanel3);

        JPanel buttonPanel4 = new JPanel(new BorderLayout());
        buttonPanel4.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        buttonPanel4.setOpaque(false);
        formModifPanel.add(buttonPanel4);

        buttonPanel4.add(ajouterCommentaireBtn);
        buttonPanel4.add(ajouterEtiquetteBtn, BorderLayout.EAST);

        JPanel buttonPanel5 = new JPanel(new BorderLayout());
        buttonPanel5.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        buttonPanel5.setBorder(new EmptyBorder(0, 0, 20, 90));
        buttonPanel5.setOpaque(false);
        carteModifPanel.add(buttonPanel5, BorderLayout.SOUTH);

        buttonPanel5.add(submitBtn, BorderLayout.EAST);

        bodyPanel.add(carteModifPanel);



        bodyPanel.add(Box.createVerticalStrut(20));

        // Ajout d'une bordure de 1px en bas du headPanel avec la couleur #363636
        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        // Initialisation et configuration du titre
        this.titlePanel = new JLabel("<html><b>"+nomTableau+"</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        headPanel.add(titlePanel, BorderLayout.WEST);

        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }

    public void afficheForm(JButton submitListeBtn, JButton returnListeBtn, JDialog dialog, JLabel label){
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
        int x = location.x + this.getWidth()/2 - dialog.getWidth()/2;
        int y = location.y + this.getHeight()/2 - dialog.getHeight()/2;
        dialog.setLocation(x, y);

        dialog.setVisible(true);
    }

    public String getNom() {
        return this.nomField.getText();
    }
    public void refreshPage(){
        commentairePanel.removeAll();
        for (String commentaire : commentaireList) {
            System.out.println(commentaire);
            JLabel comLabel = new JLabel(commentaire);
            comLabel.setForeground(Color.white);
            commentairePanel.add(comLabel);
            commentairePanel.setBackground(Color.decode("#111111"));
        }

        etiquettePanel.removeAll();
        for (String etiquette : this.etiquetteList) {
            JLabel etiLabel = new JLabel(etiquette);
            etiLabel.setForeground(Color.white);
            etiquettePanel.add(etiLabel);
            etiquettePanel.setBackground(Color.decode("#111111"));

        }
        etiquettePanel.revalidate();
        etiquettePanel.repaint();

        commentairePanel.revalidate();
        commentairePanel.repaint();
    }

    public void setNomCarteField(String nom){
        nomCarteField.setText(nom);
    }
    public void setDescriptionCarteField(String description){
        descriptionCarteField.setText(description);
    }
    public void setDateDebut(Date dateDebut){
        smDebut.setValue(dateDebut);
    }
    public void setDateFin(Date dateFin){
        smFin.setValue(dateFin);
    }
    public void setCommentaireList(ArrayList<String> commentaireList){
        this.commentaireList = commentaireList;
    }
    public void setEtiquetteList(ArrayList<String> etiquetteList){
        this.etiquetteList = etiquetteList;
    }

    public String getNomCarteField(){
        return nomCarteField.getText();
    }

    public String getDescriptionCarteField(){
        return descriptionCarteField.getText();
    }

    public Date getDebutDate(){
        return (Date) smDebut.getValue();
    }
    public Date getFinDate(){
        return (Date) smFin.getValue();
    }


}
