/*
 * Jahja Ibrakovic
 * 1/7/25
 */

package Lesson19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("temps.txt");
        Scanner in = new Scanner(inputFile);

        ArrayList<Integer> temps = new ArrayList<>();
        int lowestTemp = 1000;

        while (in.hasNext()) {
            int temp = in.nextInt();
            temps.add(temp);
            if (temp < lowestTemp) {
                lowestTemp = temp;
            }
        }

        for (int temp : temps) {
            if (temp == lowestTemp) {
                System.out.println(temp + "<= lowest");
            } else {
                System.out.println(temp);
            }
        }

        in.close();

    }
}
