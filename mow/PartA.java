/*
 * Jahja Ibrakovic 
 * 2-3-25
 */
package mow;

import mow.Yard;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the lawn simulator! An exciting breakthrough in lawn care technology!");
        System.out.print("Please enter the height of your lawn: ");
        int height = in.nextInt();
        System.out.print("Please enter the width of your lawn: ");
        int width = in.nextInt();

        Yard yard = new Yard(height, width);
        System.out.println();
        yard.printYard();
    }
}
