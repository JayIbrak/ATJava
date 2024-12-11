package Lesson15;
import java.util.Scanner;
import java.util.Arrays;
public class PartA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[10];
        int currentSize = 0;

        System.out.print("Enter 10 digits...Type 'q' to stop: ");

        while(currentSize<values.length)
        {
            String response = in.nextLine();
            if(response.equalsIgnoreCase("q"))//found this function on stack overflow and makes ending the loop a little easier
            {
                break;
            }
           if(response.matches("-?\\d+"))//another new method I found to see if their input is an int or not, makes the process a little mre streamline
           {
                int number = Integer.parseInt(response);
                values[currentSize] = number;
                currentSize++;
           }
           else
           {
            System.out.print("Invalid input. Enter another integer or q to quit: ");
           }
        }
        System.out.print("*");
        for(int i = 0; i < currentSize; i++)
        {
            System.out.print(values[i] + "*");
        }
        System.out.println();
        Arrays.sort(values, 0, currentSize);
        for(int i = currentSize - 1; i>= 0; i--)
        {
            System.out.print(values[i]);
            if(i>0)
            {
                System.out.print(",");
            }
        }
        
    }
}
