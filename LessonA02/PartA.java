package LessonA02;

import ArtClasses.Application;
import ArtClasses.Board;

public class PartA {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Application app = new Application("Image Example");
            app.setVisible(true);
        });
    }
}