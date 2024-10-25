/*
 * Jahja Ibrakovic
 * 10/24/24
 */

package Lesson8;

public class PartB {
    public static void main(String[] args) {
        double cesium = 100.00;
        int years = 0;

        while(cesium > 1)
        {
            cesium = cesium/2;
            years = years + 30;
        }
        System.out.println("It will take " + years + " years for cecium to lose 99% of the initial volume");
    }
}
