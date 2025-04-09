package Simulation;

import javax.swing.*;
import ArtClasses.BoardSimB;

public class PartB extends JFrame {
    public PartB() {
        setTitle("Cannon Sim Part B");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoardSimB board = new BoardSimB();
        add(board);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PartB app = new PartB();
            app.setVisible(true);
        });
    }
}
