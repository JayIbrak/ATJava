/*
 * Jahja Ibrakovic
 * 1/9/25
 */
//There may be a gap in my understanding but I cannon seem to get this program to work
//There is something conceptually wrong here but I can't seem to figure it out
//Is there any way I could get feedback on this code and how i've set up my customer data file and finish after?
package Lesson20;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("customerdata.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("[,\n]+");

        System.out.println("---------------------------------------");
        System.out.println("   ID  |    NAME    |      BALANCE     ");
        System.out.println("---------------------------------------");

        while (in.hasNext()) {
            String id = in.next();
            String name = in.next();
            String balance1 = in.next();
            balance1 = balance1.replace(",", "");
            double balance = Double.parseDouble(balance1);

            System.out.printf("%06d  |  %-12s  | $ %12,.2f\n", Integer.parseInt(id), name, balance);
        }

        in.close();
    }
}
