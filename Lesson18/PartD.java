/*
 * Jahja Ibrakovic
 * Lesson 19
 */

package Lesson18;
import java.util.ArrayList;
import java.util.Scanner;
public class PartD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while(true)
        {
            System.out.print("Enter any integer or q to quit: ");
            String response = in.nextLine();

            if(response.equals("q")||response.equals("Q"))
            {
                break;
            }
            else
            {
               int values = Integer.parseInt(response);
               numbers.add(values);
            }
        }

        numbers.removeIf(n -> n%2 != 0);//LAMBDA EXPRESSION ALERT...
        //found this neat little line of code on stack overflow and makes taking out odd numbers much easier syntax-wise

        for(int values : numbers)
        {
            System.out.println(values);
        }
    }
}
