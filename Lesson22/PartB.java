/*
 * Jahja Ibrakovic
 * 1/19/25
 */

package Lesson22;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartB {
    public static void main(String[] args) {
        File inputFile = new File("birthyears.txt");
        try {
            Scanner in = new Scanner(inputFile);
            in.useDelimiter("[,\\n]");
            while (in.hasNext()) {
                String name = in.next();
                String yearString = in.next();
                try {
                    if (yearString.equals("n/a")) {
                        System.out.println(name + " was born in an unknown year");
                    } else {
                        int year = Integer.parseInt(yearString);
                        System.out.println(name + " was born in " + year + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("I do not know when" + name + "was born.");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file was found please try again");

        }
    }
}
