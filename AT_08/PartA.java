/*
 * Jahja Ibrakovic
 * 1/4/25
 */

package AT_08;

import java.time.LocalDate;
import java.time.LocalTime;

public class PartA {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        System.out.println("Today's date is " + currentDate);
        System.out.println("The time is " + currentTime);
    }
}
