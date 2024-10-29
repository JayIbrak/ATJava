/*
 * Jahja Ibrakovic
 * 10/28/24
 */
package Lesson9;
import java.util.Scanner;
public class PartB {
    public static void main(String[] args) {
        int eCount = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Let's find out how many 'e's are in a phrase");
        System.out.print("Enter a random phrase:");
        String phrase = in.nextLine();
        //initializing and rules and such

        for(int i = 0; i<phrase.length(); i = i+1)
        {
            if(phrase.charAt(i) == 'e')
            {
                eCount = eCount + 1;
            }
            else if(phrase.charAt(i) == 'E')
            {
                eCount = eCount + 1;
            }
        }
        //conditionals to determine if there is in fact an e
        System.out.println("There are " + eCount + " 'e's in your phrase");
        //printing results
    }
}
