package ProjectileMotion;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.util.Timer;
import java.util.TimerTask;

public class BoardSimC extends JPanel implements KeyListener {
    private final int B_WIDTH = 1440;
    private final int B_HEIGHT = 810;
    private int FLOOR = B_HEIGHT - 25;

    private Cannon cannon;
    private final double INITIAL_ANGLE = -45;
    private CannonBall ball;

    private Timer timer;
    private final int INITAL_DELAY = 100;
    private final int TIMER_INTERVAL = 20;

    public BoardSimC() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);
        cannon = new Cannon(60, B_HEIGHT - 60, INITIAL_ANGLE);

        ball = new CannonBall(0, 1, FLOOR);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledUpdate(), INITAL_DELAY, TIMER_INTERVAL);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GREEN);
        g2d.fillRect(0, FLOOR, B_WIDTH, B_HEIGHT - FLOOR);

        cannon.draw(g2d);
        ball.draw(g2d);
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
            cannon.fire(ball);
        }
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    private class ScheduledUpdate extends TimerTask {
        public void run() {
            ball.updateBall();
            repaint();
        }
    }
}
