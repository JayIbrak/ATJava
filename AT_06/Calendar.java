/*
 * Jahja Ibrakovic
 * 10/29/24
 */

package AT_06;
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
public class Calendar {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate firstOfMonth = now.minusDays((now.getDayOfMonth()) - 1);
        Month month = now.getMonth();

        System.out.println(" ");
        System.out.println("          " + now.getMonth() + "           ");
        System.out.println(" ");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        //really about setting everything up here. Setting up the headers as well as initializing the most critical variables

        DayOfWeek firstDate = firstOfMonth.getDayOfWeek();
        int spaces = firstDate.getValue() - 1;
        //establishing the amount of spaces. Java reads Monday as 1, yet if the month were to start on a Monday, we would want no spaces, so subtracting by one gets the final space count 

        for(int i = 0; i<spaces; i = i+1)
        {
            System.out.print("    ");
        }
        //Printing the spaces themselves

       LocalDate loopDays = firstOfMonth;
       while(loopDays.getMonth() == month)
       {
            if(loopDays.equals(now))
            {
                System.out.printf("%3d* ", loopDays.getDayOfMonth());
            }
            else 
            {
                System.out.printf("%3d ", loopDays.getDayOfMonth());
            }

            if(loopDays.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                System.out.println();
            }

            loopDays = loopDays.plusDays(1);
       }
       //And finally its all about just looping through and printing all of the days in the month into our formatted calendar, adding an asterisk to mark today's date

    }
}
