/*
 * Jahja Ibrakovic
 * 1/13/25
 */
package Lesson21;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("sales_by_cat.txt");
        Scanner in = new Scanner(inputFile);

        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] parts = line.split(",");

            double salesRevenue = 0.0;
            String department = parts[0].trim();
            String manager = parts[1].trim();
            String revenue = parts[2].trim();

            if (!revenue.equals("n/a")) {
                salesRevenue = Double.parseDouble(revenue);
            }

            System.out.printf("%-17s| %-9s | $%10.2f\n", department, manager, salesRevenue);
        }

    }
}
