/*
 * Jahja Ibrakovic
 * 10/24/24
 */
package AT_08.PartB.org.derryfield.math;

//The folder structure is not exactly the same as in the document 
//but that is just for organizational purposes
public class Geometry {
    public static double calcVolSphere(double r) {
        return (4.0 / 3.0) * Math.PI * (r * r * r);
    }

    public static double calcSurfSphere(double r) {
        return 4 * Math.PI * (r * r);
    }
}
