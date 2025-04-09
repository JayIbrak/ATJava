package ArtClasses;

import ArtClasses.Cannon;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BoardSimB extends JPanel implements KeyListener {
    private Cannon cannon;

    public BoardSimB() {
        this.setFocusable(true);
        this.addKeyListener(this);
        cannon = new Cannon();
    }

    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        setBackground(Color.CYAN);

        final int FLOOR = getHeight() - 25;
        G.setColor(Color.BLACK);
        G.fillRect(0, FLOOR, getWidth(), 5);

        G.setColor(Color.GREEN);
        G.fillRect(0, FLOOR + 5, getWidth(), getHeight());
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
