package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MembreVue extends JPanel {
    JPanel headPanel;
    JPanel bodyPanel;
    JLabel titlePanel;
    JLabel subtitlePanel;
    JPanel membresPanel;
    JPanel membreContainer;
    public MembreVue(ArrayList<String> listesutilisateurs, ArrayList<JComboBox<String>> listeComboBox){
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

        this.titlePanel = new JLabel("<html><b>Membres</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        String subtitleText = "LES MEMBRES" ;
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

        membresPanel = new JPanel();
        membresPanel.setLayout(new BoxLayout(membresPanel, BoxLayout.Y_AXIS));
        membresPanel.setOpaque(false);

        for (int i=0; i<listesutilisateurs.size(); i++) {
            JPanel membrePanel = new JPanel(new BorderLayout());
            membrePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,70));
            JLabel nomEtPrenomLabel = new JLabel("<html><b style='font-size: 11px'>"+ listesutilisateurs.get(i)+"</b><html>");
            nomEtPrenomLabel.setForeground(Color.white);
            nomEtPrenomLabel.setBorder(new EmptyBorder(0, 20, 0, 0));

            membrePanel.add(listeComboBox.get(i), BorderLayout.EAST);
            membrePanel.add(nomEtPrenomLabel);
            membrePanel.setBackground(Color.decode("#111111"));

            membresPanel.add(membrePanel);
        }


        GridBagConstraints gbcReunionPanel = new GridBagConstraints();
        gbcReunionPanel.fill = GridBagConstraints.BOTH;
        gbcReunionPanel.gridx = 0;
        gbcReunionPanel.gridy = 1;
        gbcReunionPanel.weightx = 1.0;
        gbcReunionPanel.weighty = 1.0;

        bodyPanel.add(membresPanel, gbcReunionPanel);



        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;


        headPanel.add(buttonPanel, BorderLayout.EAST);

        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }


}
