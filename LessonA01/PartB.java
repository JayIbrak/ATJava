package LessonA01;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Rectangle;

public class PartB {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Application app = new Application("Rotated Rectangle");
            app.setVisible(true);
        });
    }
}

class Application extends JFrame {
    private final int FRAME_WIDTH = 640;
    private final int FRAME_HEIGHT = 480;

    /*
     * Constructor.
     */
    public Application(String title) {
        // the values for border width and title bar height
        // depend on the operating system.
        int border_width = 0;
        int bar_height = 0;
        OS os = checkOS();
        switch (os) {
            case WIN:
                border_width = 7;
                bar_height = 30;
                break;
            case MAC:
                border_width = 0;
                bar_height = 28;
                break;
            case LINUX:
                // I don't know what the values are for Linux.
                break;
            case OTHER:
                break;
        }

        // int application_width = FRAME_WIDTH + 2 * border_width;
        // int application_height = FRAME_HEIGHT + bar_height + border_width;
        this.setTitle(title);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Board board = new Board();
        this.add(board);

        // set the size based on the board size
        // and also account for the border width and the bar height.
        int application_height = (int) board.getPreferredSize().getHeight() + bar_height + border_width;
        int application_width = (int) board.getPreferredSize().getWidth() + 2 * border_width;
        this.setSize(application_width, application_height);
    }

    public static enum OS {
        WIN, MAC, LINUX, OTHER
    }

    public static OS checkOS() {
        OS val;
        String name = System.getProperty("os.name").toLowerCase();
        if (name.indexOf("win") >= 0) {
            val = OS.WIN;
        } else if (name.indexOf("mac") >= 0) {
            val = OS.MAC;
        } else if (name.indexOf("nux") >= 0) {
            val = OS.LINUX;
        } else {
            val = OS.OTHER;
        }
        return val;
    }

}

class Board extends JPanel {
    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;

    /*
     * Constructor
     */
    public Board() {
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int rectWidth = 150;
        int rectHeight = 150;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // AffineTransform for translation and rotation
        AffineTransform transform = new AffineTransform();
        transform.translate(centerX - rectWidth / 2, centerY - rectHeight / 2);
        transform.rotate(Math.toRadians(22.5), rectWidth / 2.0, rectHeight / 2.0);

        g2d.setColor(Color.MAGENTA);
        g2d.fill(transform.createTransformedShape(new Rectangle(0, 0, rectWidth, rectHeight)));

        g2d.setColor(Color.BLUE);
        g2d.drawString("Hello, World!", 0, 0);
    }
}
