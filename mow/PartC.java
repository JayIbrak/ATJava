/*
 * Jahja Ibrakovic
 * 2-12-25
 */
package mow;

import java.util.Scanner;

public class PartC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Moomba! The world's first self-driving compact lawn mower!");

        System.out.print("To begin, please enter the lawn height:");
        int grassHeight = in.nextInt();
        System.out.print("Please enter the lawn width:");
        int grassWidth = in.nextInt();

        Yard yard = new Yard(grassHeight, grassWidth);
        Mower mower = new Mower(0, 0, 0);
        mower.randomizeInitialPosition(yard);

        while (true) {
            clearScreen();
            mower.mow(yard);
            yard.printYard(mower);
            delay(500);

            if (!mower.activateRoombaMode(yard)) {
                mower.mow(yard);
                break;
            }
        }
        clearScreen();
        yard.printYard(mower);
        System.out.println("aaaand you're done! How easy was that?");
    }

    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
