package ArtClasses;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private BufferedImage image;

    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        try {
            image = ImageIO.read(new File("/Users/jay/Downloads/Ibrakovic.png"));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D art = (Graphics2D) g;

        if (image != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double scaleFactor = Math.sqrt(0.25);

            int scaledWidth = (int) (panelWidth * scaleFactor);
            int scaledHeight = (int) (panelHeight * scaleFactor);

            int x = panelWidth - scaledWidth;
            int y = panelHeight - scaledHeight;

            art.drawImage(image, x, y, scaledWidth, scaledHeight, this);
        }
    }

}