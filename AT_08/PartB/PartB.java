/*
 * Jahja Ibrakovic
 * 1/4/25
 */
package AT_08.PartB;

import AT_08.PartB.org.derryfield.math.Geometry;

public class PartB {
    public static void main(String[] args) {
        double radius = 10.0;
        double volume = Geometry.calcVolSphere(radius);
        double surface = Geometry.calcSurfSphere(radius);

        System.out.println("The volume of a sphere with a radius of 10 is " + volume);
        System.out.println("The surface area of a sphere with a radius of 10 is " + surface);
    }
}
