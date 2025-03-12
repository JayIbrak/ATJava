package ArtClasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import ArtClasses.Soundclip;

public class Board03 extends JPanel implements ActionListener {
    private BufferedImage image;
    private int x, y, vx, vy;
    private Timer timer;
    private Soundclip sitar;
    private Soundclip owSound;

    public Board03() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(720, 720));
        Random rand = new Random();
        vx = rand.nextInt(5) + 1;
        vy = rand.nextInt(5) + 1;
        x = 720 / 2;
        y = 720 / 2;
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
        updateAnimation(e);
    }

    private void updateAnimation(ActionEvent e) {
        x += vx;
        y += vy;
        int imgWidth = image != null ? image.getWidth() : 50;
        int imgHeight = image != null ? image.getHeight() : 50;
        if (x < 0 || x > getWidth() - imgWidth) {
            vx = -vx;
            owSound.play();
        }
        if (y < 0 || y > getHeight() - imgHeight) {
            vy = -vy;
            owSound.play();
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D art = (Graphics2D) g;
        art.drawImage(image, x, y, null);
    }
}