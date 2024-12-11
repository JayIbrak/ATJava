package Classwork;
import java.util.Scanner;
public class December {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int currentsize = 0;
        final int CAPACITY = 100;
        double[] testvalues = new double[10];
        while(true)
        {
            System.out.print("Enter a test value or q to quit: ");
            if(in.hasNext("q") || in.hasNext("Q"))
            {
                System.out.println("Done with your inputs");
                break;
            }
            if(currentsize<CAPACITY)
            {
                double value = in.nextDouble()
                testvalues[currentsize] = value;
                currentsize++; 
            }
            else
            {
                System.out.println("There is no room left for more test scores...");
                break;
            }
            System.out.println("---------------------");
            
            
        }



    }
}
