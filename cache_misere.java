public class cache_misere {
    /*
         panel.setLayout(new GridBagLayout());

        // Créer les champs de texte
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 20));

        descriptionArea = new JTextArea();
        descriptionArea.setPreferredSize(new Dimension(200, 100));

        // Créer la liste déroulante
        String[] options = { "Petite entreprise", "Ressources humaines", "Opérations", "Ingénierie & informatique", "Marketing", "Vente et gestion de la relation client", "Éducation", "Autre" };
        selectionBox = new JComboBox<>(options);
        selectionBox.setPreferredSize(new Dimension(200, 20));

        // Créer le bouton
        submitButton = new JButton("Créer le projet");
        submitButton.setPreferredSize(new Dimension(200, 30));

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                projet_controleur projet = new projet_controleur(nameField.getText(), descriptionArea.getText(), selectionBox.getSelectedItem().toString());
            }
        });
        
        GridBagConstraints c = new GridBagConstraints();

        // Ajouter les composants au panneau
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 5, 0);
        c.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Nom du projet"), c);

        c.gridy = 1;
        c.insets = new Insets(0, 0, 20, 0);
        panel.add(nameField, c);

        c.gridy = 2;
        c.insets = new Insets(0, 0, 5, 0);
        panel.add(new JLabel("Catégorie du projet"), c);

        c.gridy = 3;
        c.insets = new Insets(0, 0, 20, 0);
        panel.add(selectionBox, c);

        c.gridy = 4;
        c.insets = new Insets(0, 0, 5, 0);
        panel.add(new JLabel("Description du projet (facultatif)"), c);

        c.gridy = 5;
        c.insets = new Insets(0, 0, 20, 0);
        panel.add(new JScrollPane(descriptionArea), c);


        c.gridy = 6;
        panel.add(submitButton, c);
     */
}


/*
 * 
 * Définir le titre de la fenêtre
        JFrame frame = new JFrame("Trelite");
        JPanel mainPanel = new JPanel();
        private projet_controle projet_controle;
    
        public void changementVue(){
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
        }
        public fenetre_vue(projet_controle projet_controle) {
            this.projet_controle = projet_controle;
            // Crée une nouvelle JFrame
    
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600); // définit la taille de la fenêtre
            frame.setMinimumSize(new Dimension(1000, 600)); // Définir la taille minimale du JPanel
    
            // Crée le bandeau latéral
            JPanel sidebar = new JPanel();
            sidebar.setBackground(Color.GRAY); // définit la couleur de fond
            sidebar.setPreferredSize(new Dimension(200, 600)); // définit la taille
    
            // Ajoute le bandeau latéral à la JFrame
            frame.getContentPane().add(sidebar, BorderLayout.WEST);
    
            // Crée un JPanel principal
     
            mainPanel.setBackground(Color.WHITE); // définit la couleur de fond
            mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, frame.getHeight() / 2));
    
            JLabel label = new JLabel("Vous n'êtes sur aucun projet.");
            JButton button = new JButton("Créer un projet");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changementVue();
                    formulaire_vue projet = new formulaire_vue(mainPanel);
                }
            });
            // Ajoute le bouton au JPanel principal
            mainPanel.add(label);
            mainPanel.add(button);
    
            // Ajoute le JPanel principal à la JFrame
            frame.getContentPane().add(mainPanel);
    
            // Affiche la fenêtre
            frame.setVisible(true);
 */