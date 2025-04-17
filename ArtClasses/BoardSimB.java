package ArtClasses;

import ArtClasses.Cannon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

public class BoardSimB extends JPanel implements KeyListener {
    private Cannon cannon;

    public BoardSimB() {
        this.setFocusable(true);
        this.addKeyListener(this);
        cannon = new Cannon();
    }

    public void paintComponent(Graphics g2d) {
        super.paintComponent(g2d);
        setBackground(Color.CYAN);

        final int FLOOR = getHeight() - 25;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, FLOOR, getWidth(), 5);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, FLOOR + 5, getWidth(), getHeight());

        cannon.draw(g2d);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cannon.rotateCounterClockwise();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cannon.rotateClockWise();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            cannon.fireCannon();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

}
