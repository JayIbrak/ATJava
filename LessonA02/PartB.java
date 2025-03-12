package LessonA02;

import ArtClasses.Application02;

public class PartB {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Application02 app = new Application02("Andy Round' and Round'");
            app.setVisible(true);
        });
    }
}