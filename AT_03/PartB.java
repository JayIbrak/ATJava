/*
 * Jahja Ibrakovic
 * AT Problem Set 03
 */

package AT_03;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your phone number (no spaces): ");
        String number = in.nextLine();

        String formattednumber = "(" + number.substring(0, 3) + ")" + number.substring(3, 6) + "-" + number.substring(6, 10);

        System.out.println("To format your number, right it as " + formattednumber);
    } 
}
