/*
 * Jahja Ibrakovic
 * 1/19/25
 */

package Lesson22;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a file name or '#' to quit: ");
            String fileName = in.nextLine();
            if (fileName.equals("#")) {
                System.out.println("Goodbye!");
                break;
            } else {
                try {
                    File inputFile = new File(fileName);
                    Scanner fileScanner = new Scanner(inputFile);
                    System.out.println("The contents of the file are: ");
                    while (fileScanner.hasNext()) {
                        System.out.println(fileScanner.next());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found. Pleae try again.");
                }
            }
        }
    }
}
