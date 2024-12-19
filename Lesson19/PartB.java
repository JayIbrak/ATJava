/*
 * Jahja Ibrakovic
 * Lesson 19
 */

package Lesson19;
import java.util.ArrayList;
import java.util.Scanner;
public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> testValues = new ArrayList<>();

         while(true)
        {
            System.out.print("Enter a test score or press Q to quit: ");
            String response = in.nextLine();

            if(response.equals("q")||response.equals("Q"))
            {
                break;
            }
            else
            {
               Double scores = Double.parseDouble(response);//parsed the input into a double here there might be a better way of doing this however
               testValues.add(scores);
            }
        }

         for(Double Test : testValues)
        {
            System.out.printf("%.2f\n", Test);
        }

        double sum = 0;
        for(Double score : testValues)
        {
            sum += score;
        }
        double average = sum/testValues.size();
        System.out.printf("Average of your scores: %.2f\n", average);
        //so far so good

    }
}
