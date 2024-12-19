/*
 * Jahja Ibrakovic
 * Lesson 19
 */

package Lesson18;
import java.util.ArrayList;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        while(true)
        {
            System.out.print("Enter a name or press '#' to quit: ");
            String response = in.nextLine();

            if(response.equals("#"))
            {
                break;
            }
            else
            {
                names.add(response);
            }
        }

        for(String Name : names)
        {
            System.out.println(Name);
        }//Not too shabby
    }
}
