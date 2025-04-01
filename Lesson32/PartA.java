package Lesson32;

import ArtClasses.Application04;

public class PartA {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Application04 app = new Application04("Circle Hide and Seek");
            app.setVisible(true);
        });
    }
}