package ArtClasses;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BoardSimA extends JPanel implements KeyListener {

    public BoardSimA() {
        this.setFocusable(true);
        this.addKeyListener(this);
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                System.out.println("Spacebar was pressed.");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left arrow was pressed.");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right arrow was pressed.");
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up arrow was pressed.");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down arrow was pressed.");
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

}
