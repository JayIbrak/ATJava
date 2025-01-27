/*
 * Jahja Ibrakpvic
 * Lesson 24 Part A
 */
package Lesson24;

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        System.out.println("Your name is: " + name);
        System.out.println("Hello, " + name + "!");

        System.out.print("Please enter your age: ");
        int age = in.nextInt();
        System.out.println("Your age is: " + age);
        System.out.println("You are " + age + " years old.");

        in.close();
    }
}
