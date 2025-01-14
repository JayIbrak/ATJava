/*
 * Jahja Ibrakovic
 * 1/13/25
 */
package Lesson21;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Again, something is wrong with the way I am dealing with delimiters
//I will stop by during AB but I attempted this assignment with delimiters at first and it just couldn't work
//I'm using an array for now to split the string but I will try and revisit when my gap in knowledge is filled

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("Top5Unemployment.txt");
        Scanner in = new Scanner(inputFile);

        System.out.println("---------------------------------------------------------------");
        System.out.println("                 Top 5 Unemployment Rates");
        System.out.println("---------------------------------------------------------------");

        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] parts = line.split(",");

            String country = parts[0].trim();
            double rate = Double.parseDouble(parts[1].trim());
            int rank = Integer.parseInt(parts[2].trim());
            String continent = parts[3].trim();

            System.out.printf("Ranked #%d: %-18s | %6.2f%%  | %-10s\n", rank, country, rate, continent);
        }
        System.out.println("---------------------------------------------------------------");
    }
}
