package Lesson11;
import java.util.Scanner;
public class PartC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("This is a circle area calculator. Enter the radius of a circle you would like to find the area of: ");
        double rad = in.nextDouble();
        //Retrieving the radius for the sphere which will be fed through the class

        double result = CircleArea(rad);
        System.out.printf("The area of your cirlce is approximately %.2f", result);
        //running the radius through the function itself as well as printing the final result
    }

     public static double CircleArea(double radius){
        double area = ((4.0/3.0) * (Math.PI) * (radius*radius*radius));
        return area;
        //the class made for the calculation itself 
        
    }
        
}
