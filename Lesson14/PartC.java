package Lesson14;
public class PartC {
    public static void main(String[] args) {
        double[] numbers = {2.2, 1.0, 3.7, 4.1, 88.0};

        double sum = 0.0;
        double average;

        for(double num : numbers)
        {
            System.out.println(num); 
            sum += num;
        }
    
        average = sum/numbers.length;
        System.out.println("Avg = " + average);
 }
}