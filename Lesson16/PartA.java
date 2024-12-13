/*
 * Jahja Ibrakovic
 * Lesson 16
 */

package Lesson16;
import java.util.Scanner;
import java.util.Arrays;
public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] quizValues = new double[100];
        int currentSize = 0;

        while(currentSize<quizValues.length)
        {
            System.out.print("Enter an quiz score or 'q' to quit: ");

            if(in.hasNext("q") || in.hasNext("Q"))//found this function on stack overflow and makes ending the loop a little easier
            {
                in.next();
                break;
            }
          else if(in.hasNext())
           {
                quizValues[currentSize] = in.nextDouble();
                currentSize++;
                in.nextLine();
           }
           else
           {
            System.out.print("Invalid input. Enter another integer or q to quit: ");
            in.next();
           }
        }
        System.out.println("Your current quiz scores: ");
        for(int i = 0; i<currentSize; i++)
        {
            System.out.print(quizValues[i]);
            if(i<currentSize-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("Would you like to drop your lowest score(y/n)?: ");
        in.nextLine();
        String input = in.nextLine();

        if(input.equalsIgnoreCase("y"))
        {
            currentSize = (int) dropLowest(quizValues, currentSize);
            System.out.println("Quiz scores after the drop: ");
            for(int i = 0; i<currentSize; i++)
            {
                System.out.println(quizValues[i]);
                 if(i<currentSize-1)
            {
                System.out.print(", ");
            }
            }
            System.out.println();

        }
    }
    private static int dropLowest(double[] quizValues, int size) {
            if(size == 0)
            {
                System.out.println("No scores to drop");
                return size;
            }
            int min = 0;
            for(int i = 0; i<size; i++){
            if(quizValues[i] < quizValues[min])
            {
                min = i;
            }
    
           }
           for(int i = min; i<size-1; i++)
           {
            quizValues[i] = quizValues[i+1];
       }
       return size-1;
       //This one took a bunch of debugging but the practice with arrays is great so far
}
}

