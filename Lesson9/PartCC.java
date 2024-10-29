/*
 * Jahja Ibrakovic
 * 10/28/24
 */

package Lesson9;
import java.util.Random;
public class PartCC {
    public static void main(String[] args) {
        Random random = new Random();
        int ranNum = 1000;
        int ranSum = 0;
        //initializing for the loop

        for(int i = 0; i<ranNum; i++)
        {
            int ran = random.nextInt(1000) + 1;//this is really the key. By making the range of the function 0-9 and adding one, we're shifting it to make it 1-10
            ranSum = ranSum + ran;
        }
        //Running the loop and adding to the sum of the randoms
        double average = ranSum/ranNum;
        System.out.println("The average of 1000 random numbers is " + average);
        //printing results

        /* In terms of whether the results were expected or not, you can see that the average was not very precise
        The range was larger, and would output anything between 3 and 7 most often 
        When having a larger sample size of 1000, you end up with much more accurate averages. 
        If the sample size were to get larger and larger, the average would only get closer to the center point*/
   
    }
}
