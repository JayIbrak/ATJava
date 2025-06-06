package ArtClasses;

import java.awt.*;
import javax.swing.*;

import ProjectileMotion.Cannon;

import java.awt.event.*;
import java.awt.image.ImageObserver;

public class BoardSimB extends JPanel implements KeyListener {
    private final int B_WIDTH = 1440;
    private final int B_HEIGHT = 810;
    private int FLOOR = B_HEIGHT - 25;

    private Cannon cannon;
    private final double INITIAL_ANGLE = -45;

    public BoardSimB() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);
        cannon = new Cannon(60, B_HEIGHT - 60, INITIAL_ANGLE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, FLOOR, B_WIDTH, B_HEIGHT - FLOOR);

        cannon.draw(g2d);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
            cannon.rotateCounterClockwise();
            repaint();
        }

        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key pressed");
            cannon.rotateClockWise();
            repaint();
        }

        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            cannon.fire();
        }
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

}
