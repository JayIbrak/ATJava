package ArtClasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Board03 extends JPanel implements ActionListener {
    private BufferedImage image;
    private int x, y, vx, vy;
    private Timer timer;
    private Soundclip sitar;
    private Soundclip owSound;
    private int angle = 0;

    public Board03() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(720, 720));
        Random rand = new Random();
        vx = rand.nextInt(5) + 1;
        vy = rand.nextInt(5) + 1;
        x = (720 - 50) / 2;
        y = (720 - 50) / 2;

        try {
            image = ImageIO.read(new File("/Users/jay/Downloads/Andy.png"));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }

        sitar = new Soundclip("/Users/jay/Downloads/sitar.wav");
        sitar.open();
        sitar.setLoop(true);
        sitar.play();

        owSound = new Soundclip("/Users/jay/Downloads/ow.wav");
        owSound.open();

        timer = new Timer(25, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        updateAnimation();
    }

    private void updateAnimation() {
        x += vx;
        y += vy;
        angle += 5; // Increment angle for continuous rotation
        int imgWidth = image != null ? image.getWidth() : 50;
        int imgHeight = image != null ? image.getHeight() : 50;

        if (x <= 0) {
            x = 0;
            vx = Math.abs(vx);
            owSound.play();
        } else if (x >= getWidth() - imgWidth) {
            x = getWidth() - imgWidth;
            vx = -Math.abs(vx);
            owSound.play();
        }

        if (y <= 0) {
            y = 0;
            vy = Math.abs(vy);
            owSound.play();
        } else if (y >= getHeight() - imgHeight) {
            y = getHeight() - imgHeight;
            vy = -Math.abs(vy);
            owSound.play();
        }

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

        art.drawImage(image, 0, 0, null);
    }
}