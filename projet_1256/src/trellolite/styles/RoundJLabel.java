package trellolite.styles;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * classe qui étend JLabel pour créer un JLabel avec des coins arrondis.
 * 
 * @author Nawfel Kerarsi
 */
public class RoundJLabel extends JLabel {
    private static final int ARC_WIDTH = 30;
    private static final int ARC_HEIGHT = 30;

    /**
     * Constructeur de la classe RoundJLabel.
     * Initialise le JLabel et configure la transparence.
     */
    public RoundJLabel() {
        super();
        setOpaque(false);
    }

    /**
     * Redéfinition de la méthode paintComponent pour dessiner le composant.
     * Dessine un rectangle avec des coins arrondis autour du JLabel.
     *
     * @param g L'objet Graphics utilisé pour le dessin.
     */
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT));
        g2d.dispose();

        super.paintComponent(g);
    }
}
