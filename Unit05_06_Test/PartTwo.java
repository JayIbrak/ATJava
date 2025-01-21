package Unit05_06_Test;

import java.util.ArrayList;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) {
        int count = 0;
        double total = 0;
        ArrayList<Double> quizValues = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a quiz score or 'q' to quit:");
            String response = in.nextLine();
            if (response.equals("q")) {
                break;
            } else {
                Double scores = Double.parseDouble(response);
                quizValues.add(scores);
                total = (int) (total + scores);
                count++;
            }
        }

        System.out.println("----------------------");
        for (Double quizPrint : quizValues) {
            System.out.printf("%.2f\n", quizPrint);
        }
        System.out.println("----------------------");

        double average = total / count;
        System.out.printf("avg = %.2f", average);
    }
}
