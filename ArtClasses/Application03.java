package ArtClasses;

import javax.swing.JFrame;

public class Application03 extends JFrame {
    private final int FRAME_WIDTH = 640;
    private final int FRAME_HEIGHT = 480;

    public Application03(String title) {
        int borderWidth = 0;
        int barHeight = 0;
        OS os = checkOS();
        switch (os) {
            case WIN -> {
                borderWidth = 7;
                barHeight = 30;
            }
            case MAC -> {
                borderWidth = 0;
                barHeight = 28;
            }
            default -> {
            }
        }

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Board03 board = new Board03();
        this.add(board);
        this.pack();

        int adjustedHeight = this.getHeight() + barHeight + borderWidth;
        int adjustedWidth = this.getWidth() + 2 * borderWidth;
        this.setSize(adjustedWidth, adjustedHeight);

        this.setVisible(true);
    }

    public static OS checkOS() {
        String name = System.getProperty("os.name").toLowerCase();
        if (name.contains("win"))
            return OS.WIN;
        else if (name.contains("mac"))
            return OS.MAC;
        else if (name.contains("nux"))
            return OS.LINUX;
        else
            return OS.OTHER;
    }

    public enum OS {
        WIN, MAC, LINUX, OTHER
    }
}