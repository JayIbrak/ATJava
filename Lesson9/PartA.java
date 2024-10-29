/*
 * Jahja Ibrakovic
 * 10/28/24
 */
package Lesson9;
import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        double score; 
        int scoreNum = 0;
        double total = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("When prompted, enter our test scores to find the average, enter a 0 to end.");
        //Initializing variables, and giving rules to the reader    
        while(true)
        {
            System.out.print("Enter a test score:");
            score = in.nextDouble();

            if(score == 0)
            {
                break;
            }
            //Using 0 as a way to break the code
            total = total + score;
            scoreNum = scoreNum + 1;
        }
        double average = total/scoreNum;
        System.out.printf("Your average across your test scores is %.2f", average);
        //and then here it's just about performing that final calculation and printing it
    }
}
