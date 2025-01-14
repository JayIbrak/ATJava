/*
 * Jahja Ibrakovic
 * 1/9/25
 */
package Lesson21;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("characters.txt");
        Scanner in = new Scanner(inputFile);
        int characters = 0;
        int letters = 0;
        int digits = 0;

        while (in.hasNext()) {
            String line = in.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                characters++;

                if (Character.isLetter(ch)) {
                    letters++;
                } else if (Character.isDigit(ch))// knowing char funcs makes this significantly easier
                {
                    digits++;
                }
                System.out.print(ch);
            }

        }
        System.out.println();
        System.out.println("Count = " + characters);
        System.out.println("Digits = " + digits);
        System.out.println("letters = " + letters);
        in.close();
    }
}
