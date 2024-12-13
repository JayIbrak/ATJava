/*
 * Jahja Ibrakovic
 * Lesson 16
 */

package Lesson16;
import java.util.Scanner;
import java.util.Arrays;
public class PartB {
    public static double average(double... values)
    {
        double sum = 0;
        for(double value : values)//Is colon valid here?
        {
            sum += value;
        }
        return sum/values.length;
    }

    public static void main(String[] args) {
        System.out.println("The average of 10, 8, 10 is equal to " + average(10, 8, 10));

        double[] scores = {100, 90, 80, 100, 80};
        double[] copyScores = Arrays.copyOf(scores, 5);
        System.out.println("The average of the scores array is " + average(copyScores));
    }
}
