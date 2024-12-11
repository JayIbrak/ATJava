package Lesson15;
import java.util.Scanner;
import java.util.Arrays;
public class PartB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[20];
        int currentSize = 0;

        while(currentSize<values.length)
        {
            System.out.print("Enter an integer or 'q' to quit: ");

            if(in.hasNext("q") || in.hasNext("Q"))//found this function on stack overflow and makes ending the loop a little easier
            {
                in.next();
                break;
            }
           if(in.hasNext())
           {
                values[currentSize] = in.nextInt();
                currentSize++;
           }
           else
           {
            System.out.print("Invalid input. Enter another integer or q to quit: ");
            in.next();
           }
        }
        System.out.println("All of your input data:");
        for(int i = 0; i < currentSize; i++)
        {
            System.out.print(values[i]);
            if(i<currentSize-1)
            {
                System.out.println(", ");
            }
        }
        System.out.println();
    
       System.out.println("Enter an integer for a target value: ");
       int target = in.nextInt();

       int count = 0;
       for(int i = 0; i<currentSize; i++)
       {
        if(values[i] == target)
        {
            count++;
        }
       }

       System.out.println("The value " + target + "occurs in your initial data " + count + " times.");
    }
}
