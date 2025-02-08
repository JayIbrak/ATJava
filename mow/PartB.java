/*
 * Jahja Ibrakovic
 * 2-6-25
 */

package mow;

import mow.Yard;
import mow.Mower;

public class PartB {
    public static void main(String[] args) {
        int grassHeight = 5;
        int grassWidth = 20;
        Yard yard = new Yard(grassHeight, grassWidth);

        int initialRow = 3;
        int initialColumn = 1;
        int initialDirection = 1;
        Mower mower = new Mower(initialRow, initialColumn, initialDirection);

        while (true) {
            mower.mow(yard);
            yard.printYard(mower);
            delay(500);
            if (mower.getColumn() >= yard.getWidth()) {
                break;
            }
            mower.moveForward();
        }
        clearScreen();
        yard.printYard(mower);
        System.out.println();
        System.out.println("The mower has drawn a line of grass now where's my money");
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
