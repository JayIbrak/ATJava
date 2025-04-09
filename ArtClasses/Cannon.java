package ArtClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import javax.sound.sampled.*;
import java.io.*;

public class Cannon {
    private double x, y, angle;
    private double muzzleVelocity;
    private Image cannonImage;
    private Clip wheelSound, cannonSound;

    public Cannon() {
        try {
            cannonImage = Toolkit.getDefaultToolkit().getImage("/Users/jay/Downloads/sm_cannon.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            AudioInputStream wheelStream = AudioSystem.getAudioInputStream(new File("/Users/jay/Downloads/wheel.wav"));
            wheelSound = AudioSystem.getClip();
            wheelSound.open(wheelStream);

            AudioInputStream cannonStream = AudioSystem
                    .getAudioInputStream(new File("/Users/jay/Downloads/cannon.wav"));
            cannonSound = AudioSystem.getClip();
            cannonSound.open(cannonStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.x = 60;
        this.y = 60;
        this.angle = 45;
        this.muzzleVelocity = 0.0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public void setMuzzleVelocity(double velocity) {
        this.muzzleVelocity = velocity;
    }

    public void rotateClockWise() {
        if (angle < 90) {
            if (angle < 90) {
                angle += 5;
                if (wheelSound != null) {
                    wheelSound.setFramePosition(0);
                    wheelSound.start();
                }
            }
        }
    }

    public void rotateCounterClockwise() {
        if (angle > 0) {
            angle -= 5;
            if (wheelSound != null) {
                wheelSound.setFramePosition(0);
                wheelSound.start();
            }
        }
    }

    public void fireCannon() {
        if (cannonSound != null) {
            cannonSound.setFramePosition(0);
            cannonSound.start();
        }
    }

    public void draw(Graphics2D g2d) {
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        at.rotate(Math.toRadians(angle), 15, 25);

        if (cannonImage != null) {
            g2d.drawImage(cannonImage, at, null);
        } else {
            System.out.println("Cannon image is not loaded!");
        }

        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) (x + 15 - 5), (int) (y + 25 - 5), 10, 10);

        Polygon base = new Polygon();
        base.addPoint((int) (x + 10), (int) (y + 50));
        base.addPoint((int) (x + 30), (int) (y + 50));
        base.addPoint((int) (x + 20), (int) (y + 70));
        g2d.setColor(Color.PINK);
        g2d.fillPolygon(base);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(base);
    }
}
