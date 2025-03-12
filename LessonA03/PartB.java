package LessonA03;

import ArtClasses.Application03;

public class PartB {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Application03 app = new Application03("Bouncy Bounce");
            app.setVisible(true);
        });
    }
}