package LessonA03;

import javax.sound.sampled.LineUnavailableException;
import sound.ToneGenerator;
import sound.ToneGenerator.Note;

public class PartA {
    public static void main(String[] args) throws LineUnavailableException {
        ToneGenerator tg = new ToneGenerator();
        tg.init();

        tg.play(Note.C5, 125);
        tg.play(Note.REST, 50);
        tg.play(Note.E5, 125);
        tg.play(Note.REST, 50);
        tg.play(Note.G5, 125);
        tg.play(Note.REST, 50);
        tg.play(Note.C6, 250);
        tg.play(Note.REST, 125);
        tg.play(Note.B5, 125);
        tg.play(Note.A5, 125);
        tg.play(Note.G5, 125);
        tg.play(Note.F5, 125);
        tg.play(Note.E5, 125);
        tg.play(Note.D5, 125);
        tg.play(Note.C5, 250);
        tg.play(Note.REST, 125);

        tg.close();
    }
}
