package Lesson15;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class PartC {
    public static void main(String[] args) {
        int arraySize = 10000;
        int[] randomValues = new int[arraySize];
        Random rand = new Random();

        for(int i = 0; i<randomValues.length; i++)
        {
            randomValues[i] = rand.nextInt(arraySize) + 1;
        }

        Arrays.sort(randomValues);
        
        int testRuns = 10000;
        for(int i = 0; i<testRuns; i++)
        {
            int target = rand.nextInt(arraySize) + 1;

            long startLinear = System.currentTimeMillis();
            int linearResult = LinearSearch(randomValues, target);
            long endLinear = System.currentTimeMillis();

            long startBinary = System.currentTimeMillis();
            int binaryResult = Arrays.binarySearch(randomValues, target);
            long endBinary = System.currentTimeMillis();

             System.out.printf("Target: %d | Linear Search: %d (Time: %d ms) | Binary Search: %d (Time: %d ms)%n", 
        target, linearResult, endLinear - startLinear, binaryResult, endBinary - startBinary);
        }
       
    }
    public static int LinearSearch(int[] array, int tgtVal)
    {
        for(int i = 0; i<array.length; i++)
        {
            if(array[i] == tgtVal)
            {
                return i;
            }
        }
        return -1;
        //this one was a doozy, but I THINK we got there...
    }
}
