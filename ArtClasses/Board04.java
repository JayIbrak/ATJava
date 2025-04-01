package ArtClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board04 extends JPanel implements MouseListener, KeyListener {
    private int circleX, circleY;
    private static final int DIAMETER = 20;
    private static final int B_WIDTH = 720;
    private static final int B_HEIGHT = 720;
    private Soundclip blip;
    private Soundclip blop;

    public Board04() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        circleX = (B_WIDTH - DIAMETER) / 2;
        circleY = (B_HEIGHT - DIAMETER) / 2;
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        blip = new Soundclip("/Users/jay/Downloads/blip.wav");
        blip.open();
        blop = new Soundclip("/Users/jay/Downloads/blop.wav");
        blop.open();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.fillOval(circleX, circleY, DIAMETER, DIAMETER);
    }

    public void mousePressed(MouseEvent e) {
        circleX = e.getX() - DIAMETER / 2;
        circleY = e.getY() - DIAMETER / 2;
        repaint();
        blip.play();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            circleX = (B_WIDTH - DIAMETER) / 2;
            circleY = (B_HEIGHT - DIAMETER) / 2;
            repaint();
            blop.play();
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}