package Lesson23;

import java.util.Scanner;

public class PartA {
    public static int getQuizScore(Scanner in) {
        while (true) {
            try {
                System.out.print("Enter a quiz score (0 to 100): ");
                int score = in.nextInt();
                if (score < 0 || score > 100) {
                    throw new ArithmeticException("Invalid score. Please enter a score between 0 and 100.");
                }
                return score;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                in.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int quizScore = getQuizScore(in); // Get a valid score
            System.out.println("Quiz score: " + quizScore);
        } finally {
            in.close(); // Close the scanner
        }
    }
}