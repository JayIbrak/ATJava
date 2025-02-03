/*
 * Jahja Ibrakovic
 * 2-3-25
 */
package Lesson26;

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Let's calculate the perimeter of a circle!");
        System.out.print("Please enter the radius of a circle: ");
        double radius = in.nextDouble();

        double perimeter = 2 * Math.PI * radius;
        System.out.printf("The perimeter of a circle with a radius of %.2f is %.2f", radius, perimeter);
        System.out.println();

        double number = 3.141526;
        System.out.println("Let's round pi to 2 decimal places: " + Math.round(number * 100.0) / 100.0);
    }
}
