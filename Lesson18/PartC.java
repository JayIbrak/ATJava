/*
 * Jahja Ibrakovic
 * Lesson 19
 */

package Lesson18;
import java.util.ArrayList;
import java.util.Scanner;
public class PartC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Double> temps = new ArrayList<>();

        while(true)
        {
            System.out.print("Enter a temperature or press Q to quit: ");
            String response = in.nextLine();

            if(response.equals("q")||response.equals("Q"))
            {
                break;
            }
            else
            {
               Double degrees = Double.parseDouble(response);
               temps.add(degrees);
            }
        }
        double lowestTemp = temps.get(0);
        for(double temperatures : temps)
        {
            if(temperatures < lowestTemp)
            {
                lowestTemp = temperatures;
            }
        }

        for(double temperatures : temps)
        {
            if(temperatures == lowestTemp)
            {
                System.out.printf("%.2f <= lowest \n", temperatures);
            }
            else
            {
                System.out.printf("%.2f\n ", temperatures);
            }
        }
    }
}
