package ArtClasses;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Soundclip {
    private String filePath;
    private File audioFile;
    private AudioInputStream audioStream;
    private Clip clip;
    private boolean loop = false;

    public Soundclip(String path) {
        filePath = path;
        clip = null;
    }

    public void open() {
        try {
            audioFile = new File(filePath);
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error opening audio file: " + e.getMessage());
        }
    }

    public void play() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            clip.setFramePosition(0);
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        }
    }

    public void play(boolean wait) {
        play();
        if (clip != null && wait) {
            long msec = clip.getMicrosecondLength() / 1000;
            try {
                Thread.sleep(msec);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void close() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
