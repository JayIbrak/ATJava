/*
 * Jahja Ibrakovic
 * 10/28/24
 */

package Lesson9;
import java.util.Random;
public class PartC {
    public static void main(String[] args) {
        Random random = new Random();
        int ranNum = 10;
        int ranSum = 0;
        //initializing for the loop

        for(int i = 0; i<ranNum; i++)
        {
            int ran = random.nextInt(10) + 1;//this is really the key. By making the range of the function 0-9 and adding one, we're shifting it to make it 1-10
            ranSum = ranSum + ran;
        }
        //Running the loop and adding to the sum of the randoms
        double average = ranSum/ranNum;
        System.out.println("The average of 10 random numbers is " + average);
        //printing results
    }
}
