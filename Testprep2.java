import java.util.Scanner;
public class Testprep2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        double value = 0;
        int valuecount = 0;
        double total = 0;
        boolean looptest = true;

        System.out.print("Enter a series of double values and we will determine the min, max, amount of valid anwers, and average of valid answers. Enter q or Q to quit: ");

        while(looptest == true)
        {
            if(in.hasNext("q") || in.hasNext("Q"))
            {
                looptest = false;
            
            }
            else
            {
                 value = in.nextDouble();

                 if(value>max)
                 {
                    max = value;
                 }

                  if(value<min)
                 {
                    min = value;
                 }
            
                 valuecount = valuecount + 1;
                 total = total + value;

            }

            double average = total/valuecount;

            System.out.println("The maximum value given was " + max);
            System.out.println("The minimum value given was " + min);
            System.out.println("The total number of valid entries " + valuecount);
            System.out.println("The average of the valid entires is " + average);

        }
    }
}
