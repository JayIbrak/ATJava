/*
 * Jahja Ibrakovic
 * Lesson 12
 */

package Lesson12 ;
public class PartB{

public static double Smallest(double x, double y, double z)
{   
    double smallest = x;

    if (y<x && y<z)
    {
        smallest = y;
    }
    else if (z<x && z<y)
    {
        smallest = z;
    }
    else{
        return smallest;
    }
    return smallest;

}


 public static void main(String[] args)
    {
        double num1 = 2.74;
        double num2 = 4.37;
        double num3 = 8.83;

        System.out.println("The smallest number among " + num1 + ", " + num2 + ", " + num3 + " is " + Smallest(num1, num2, num3));
    }

}