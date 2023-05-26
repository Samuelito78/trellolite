package trellolite.styles;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundJLabel extends JLabel {
    private static final int ARC_WIDTH = 30;
    private static final int ARC_HEIGHT = 30;

    public RoundJLabel() {
        super();
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, ARC_WIDTH, ARC_HEIGHT));
        g2d.dispose();

        super.paintComponent(g);
    }
}
