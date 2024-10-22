/*
 * Jahja Ibrakovic
 * AT Problem Set 03
 */

package AT_03;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Give me an amount of money in the format of dollar, period, cents. ex.(25.25): ");
        double amount = in.nextDouble();

        int dollars = (int) amount;
        int cents = (int) Math.round((amount - dollars) * 100);

        System.out.println("You have " + dollars + " dollars and " + cents + " cents.");
    } 
}