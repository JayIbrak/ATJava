/*
 * Jahja Ibrakovic
 * 10/24/24
 */
package AT_05;
import java.util.Scanner;

public class PartB {
    private static class DimmableLight
    {
        private boolean state;
        private int brightness;

        private DimmableLight(){
        boolean state = false;
        int brightness = 1;
        }

        void turnOn(){
            state = true;
        }

        void turnOff(){
            state = false;
        }

        void increase(){
            if (brightness < 10)
            {
                brightness = brightness + 1;
                System.out.println("The brightness has been increased by 1");
            }
            else
            {
                System.out.println("The brightness is at its max");
            }
         }

         void decrease(){
            if (brightness > 1)
            {
                brightness = brightness - 1;
                System.out.println("The brightness has been decreased by 1");
            }
            else
            {
                System.out.println("The brightness is at its minimum");
            }
         }

         void view(){
            if(state)
            {
               String state;
                state = "on";
                System.out.println("The light is " + state + " and has a brightness of "+ brightness);
            }
            else
             {
                String state;
                state = "off";
                System.out.println("The light is " + state + " and has a brightness of "+ brightness);
            }
         }
    //listing EVERYTHING that the class will do for us when we actually use it in a variable. 
    //I used some of the printlns here in the class and some in the next but it should not matter ultimately
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DimmableLight light = new DimmableLight();

        System.out.print("How would you like to change the light?(enter on, off, up, down, view, or q): ");
        while(true)
        {
            String response = in.nextLine();

            if (response.equals("on"))
            {
                light.turnOn();
                System.out.println("The light is now on");
            }
            else if (response.equals("off"))
            {
                light.turnOff();
                System.out.println("The light is now off");
            }
            else if (response.equals("up"))
            {
                light.increase();
            }
            else if (response.equals("down"))
            {
               light.decrease();
            }
            else if (response.equals("view"))
            {
                light.view();
            }
            else if (response.equals("q"))
            {
                System.out.println("You are exiting the brightness settings");
                in.close();
            }
            //Now we're just using instance meathods to account for all the possible commands
        }
    }
}
