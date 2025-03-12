package ArtClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Board02 extends JPanel {
    private BufferedImage image;
    private int x = 0;
    private int y = 0;
    private int angle = 0;
    private int speedX = 1;
    private int speedY = 1;
    private final int WIDTH = 720;
    private final int HEIGHT = 480;
    private final int DELAY = 25;

    public Board02() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        try {
            image = ImageIO.read(new File("/Users/jay/Downloads/Andy.png"));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        Timer timer = new Timer(DELAY, e -> updateAnimation());
        timer.start();
    }

    private void updateAnimation() {
        x = (x + speedX) % WIDTH;
        y = (y + speedY) % HEIGHT;
        angle = (angle + 5) % 360;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D art = (Graphics2D) g;
        int centerX = x + image.getWidth() / 2;
        int centerY = y + image.getHeight() / 2;
        art.translate(centerX, centerY);
        art.rotate(Math.toRadians(angle));
        art.translate(-image.getWidth() / 2, -image.getHeight() / 2);
        art.drawImage(image, 0, 0, this);
    }

}