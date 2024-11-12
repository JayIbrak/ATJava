/*
 * Jahja Ibrakovic
 * 10/28/24
 */

package AT_07;
class Point{
    private double x;
    private double y;
//initializing the two values
    public Point()
    {
     x = 0;
     y = 0;
    } 

    public Point(double givenX, double givenY)
    {
        x = givenX;
        y = givenY;
    }
//meathods giving default values as well as the user ability to change them
    public double getX()
    {
        return x;
    }

     public double getY()
    {
        return y;
    }

    public double getR()
    {
        return Math.sqrt((x*x)+(y*y));
    }
    
    public double getAngle()
    {
        return Math.atan2(y, x);
    }

    public void translate(double dx, double dy)
    {
        x += dx;
        y += dy;
    }

    public double distanceTo(Point other)
    {
        double dx = other.x-x;
        double dy = other.y-y;
        return Math.sqrt((dx*dx) + (dy*dy));
    }
    //Rest of the methods to fill the list 
}

public class PartB {
    public static void main(String[] args){
        Point point1 = new Point(1, 2);

        System.out.println("point1 -> x: " + point1.getX());
        System.out.println("point1 -> y: " + point1.getY());
        System.out.println("point1 -> r: " + point1.getR());
        System.out.println("point1 -> theta: " + point1.getAngle());
        //ensuring all of the methods are working and will output accurate results

        point1.translate(1, 2);
        System.out.println("After translating the point, x will be " + point1.getX() + ", and y will be " + point1.getY() + ".");

        Point point2 = new Point(2, 5);
        System.out.println("The distance between point 1 and point 2 is " + point1.distanceTo(point2));
        //Other tests, testing the translation and distance to meathods

     }
  }
