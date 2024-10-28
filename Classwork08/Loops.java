package Classwork08;
import java.util.Scanner;
public class Loops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double amount;
        do
        {
            System.out.print("Please enter a dollar amount: ");
            amount = in.nextDouble();
         
        }
        while(amount > 0);
    }
}
