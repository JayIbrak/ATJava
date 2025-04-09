package Simulation;

import javax.swing.*;
import ArtClasses.BoardSimA;

public class PartA extends JFrame {
    public PartA() {
        setTitle("Cannon Sim Part A");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoardSimA board = new BoardSimA();
        add(board);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PartA app = new PartA();
            app.setVisible(true);
        });
    }
}
