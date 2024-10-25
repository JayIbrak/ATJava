/*
 * Jahja Ibrakovic
 * 10/24/24
 */

package Lesson8;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your current APR: ");
        double apr = in.nextDouble()/100;

        System.out.print("Enter your current balance: ");
        double balance = in.nextDouble();
        System.out.printf("\nYear\tProft\tBalance%n");


        for(int year = 1; year < 6; year = year+1)
        {
            double profit = apr*balance;
            balance = balance + profit;
            System.out.printf("%d\t$%.2f\t\t$%.2f%n", year, profit, balance);
        }
    }
}
