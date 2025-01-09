/*
 * Jahja Ibrakovic
 * 1/9/25
 */

package Lesson19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("quizzes.txt");
        Scanner in = new Scanner(inputFile);

        File outputFile = new File("quizzesMod.txt");
        PrintWriter out = new PrintWriter(outputFile);

        int count = 0;
        double total = 0;

        while (in.hasNext()) {
            double score = in.nextDouble();
            System.out.printf("Quiz %03d: %.2f\n", count, score);
            total = total + score;
            count++;
        }

        double average = total / count;
        System.out.println("----------------");
        System.out.printf("Average: %.2f\n", average);
        in.close();

    }
}
