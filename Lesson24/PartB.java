/*
 * Jahja Ibrakpvic
 * Lesson 24 Part A
 */
package Lesson24;

import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Counter cakeCounter = new Counter();
        Counter pieCounter = new Counter();

        System.out.println("Welcome to the dessert Ballot!");
        System.out.print("Enter 'c' for cake, 'p' for pie, or 'q' to quit: ");

        while (true) {
            System.out.print("Enter 'c' for cake, 'p' for pie, or 'q' to quit: ");
            String response = in.nextLine();
            if (response.equals("c")) {
                cakeCounter.count();
            } else if (response.equals("p")) {
                pieCounter.count();
            } else if (response.equals("q")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'c', 'p', or 'q'.");
            }
        }
        System.out.println("Voting results:");
        System.out.println("Cake: " + cakeCounter.getValue());
        System.out.println("Pie: " + pieCounter.getValue());
        in.close();
    }

}

class Counter {
    private int count = 0;

    public int getValue() {
        return count;
    }

    public void count() {
        count = count + 1;
    }

    public void reset() {
        count = 0;
    }
}
