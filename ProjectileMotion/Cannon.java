package ProjectileMotion;

import javax.swing.*;

import ArtClasses.Soundclip;
import ProjectileMotion.CannonBall.STATE;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.io.*;

public class Cannon {
    private double x;
    private double y;
    private double angle = -45;

    private double pivot_x = 0;
    private double pivot_y = 0;

    private BufferedImage imageCannon;
    private Soundclip soundWheel;
    private Soundclip soundCannon;

    public Cannon() {
        try {
            File imageFile = new File("ArtClasses/media/sm_cannon.png");
            imageCannon = ImageIO.read(imageFile);
            pivot_x = 15;
            pivot_y = imageCannon.getHeight() / 2;
        } catch (Exception e) {
            System.out.println("Error loading cannon image: " + e.getMessage());
        }

        try {
            soundWheel = new Soundclip("ArtClasses/media/wheel.wav");
            soundWheel.open();
            soundCannon = new Soundclip("ArtClasses/media/cannon.wav");
            soundCannon.open();
        } catch (Exception e) {
            System.out.println("Error loading cannon sound: " + e.getMessage());
        }
    }

    public Cannon(double x, double y, double angle) {
        this();
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void draw(Graphics2D g2d) {
        if (imageCannon == null)
            return;

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(x - pivot_x, y - pivot_y);
        affineTransform.rotate(Math.toRadians(angle), pivot_x, pivot_y);

        g2d.drawImage(imageCannon, affineTransform, null);
        int baseWidth = 40;
        int baseHeight = 30;
        int[] xPoints = { (int) x, (int) (x - baseWidth / 2), (int) (x + baseWidth / 2) };
        int[] yPoints = { (int) (y + 5), (int) (y + 5 + baseHeight), (int) (y + 5 + baseHeight) };
        g2d.setColor(Color.PINK);
        g2d.fillPolygon(xPoints, yPoints, 3);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    public void fire(CannonBall ball) {
        if (ball.currentState == CannonBall.STATE.FLYING) {
            return;
        }

        double angleRad = Math.toRadians(angle);
        double xOff = 100 * Math.cos(angleRad);
        double yOff = 100 * Math.sin(angleRad);
        int vx = (int) (20.0 * Math.cos(angleRad));
        int vy = (int) (20.0 * Math.sin(angleRad));
        soundCannon.play();

        ball.launch(x + xOff, y + yOff, vx, vy);
        soundCannon.play();
    }

    public void rotateClockWise() {
        angle += 5;
        if (angle > 0) {
            angle = 0;
        } else {
            soundWheel.play();
        }
    }

    public void rotateCounterClockwise() {
        angle -= 5;
        if (angle < -90) {
            angle = -90;
        } else {
            soundWheel.play();
        }
    }

}
