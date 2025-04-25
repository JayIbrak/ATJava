package ProjectileMotion;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

import ArtClasses.Soundclip;

public class CannonBall {
    public double x;
    public double y;
    public double vx;
    public double vy;
    public double ax;
    public double ay;

    public enum STATE {
        IDLE, FLYING, EXPLODING
    }

    public STATE currentState = STATE.IDLE;
    private double diameter = 18;
    private Soundclip boom;
    private BufferedImage flame;
    public double ground;

    public CannonBall(double x, double y, double ground) {
        this.x = x;
        this.y = y;
        this.ground = ground;

        this.ax = 0.0;
        this.ay = 0.4;

        boom = new Soundclip("ArtClasses/media/boom.wav");
        boom.open();

        try {
            File imageFile = new File("ArtClasses/media/flame01.png");
            flame = ImageIO.read(imageFile);
        } catch (Exception e) {
            System.out.println("Error loading cannonball image: " + e.getMessage());
        }
    }

    public void draw(Graphics2D g2d) {
        AffineTransform affine = new AffineTransform();
        if (currentState == STATE.EXPLODING) {
            if (currentState == STATE.EXPLODING) {
                double flameWidth = flame.getWidth();
                double flameHeight = flame.getHeight();

                affine.translate(x - flameWidth / 2, y - flameHeight / 2);
                g2d.drawImage(flame, affine, null);
            }
        } else {
            if (currentState == STATE.FLYING) {
                affine.translate(x - diameter / 2, y - diameter / 2);
                Ellipse2D ellipse = new Ellipse2D.Float(0, 0, (int) diameter, (int) diameter);
                Shape shape = affine.createTransformedShape(ellipse);
                g2d.setColor(Color.MAGENTA);
                g2d.draw(shape);
            }
        }
    }

    public void updateBall() {
        if (currentState == STATE.FLYING) {
            vx = vx + ax;
            vy = vy + ay;
            x = x + vx;
            y = y + vy;
            if (y >= ground) {
                currentState = STATE.EXPLODING;
                boom.play();
            }
        }
    }

    public void launch(double x, double y, double vx, double vy) {
        if (currentState != STATE.FLYING) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            currentState = STATE.FLYING;
        }
    }

}
