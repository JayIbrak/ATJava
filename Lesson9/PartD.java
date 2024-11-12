/*
 * Jahja Ibrakovic
 * 10/28/24
 */

package Lesson9;
import java.util.Scanner;
import java.util.Random;

class Die{
    private int value;
    Random random = new Random();
//initializing

    public Die()
    {
        value = 1;
    } 

    public Die(int givenValue)
    {
        if(givenValue >= 1 && givenValue <= 6)
        {
            value = givenValue;
        }
        else
        {
            value = 1;
        }
    }
    //I created two constructors here, which consist of a default constuctor and one to track a given value, in the end, the value will be whatever is given or 1 if a number is not given

    void sides()
    {
        value = 1;
    }

    void roll()
    {
        value = random.nextInt(6) + 1;
    }

    void view()
    {
        if(value == 1)
    {
        System.out.println("+--------+");
        System.out.println("|        |");
        System.out.println("|    0   |");
        System.out.println("|        |");
        System.out.println("+--------+");
    }

    else if(value == 2)
    {
        System.out.println("+--------+");
        System.out.println("|  0     |");
        System.out.println("|        |");
        System.out.println("|      0 |");
        System.out.println("+--------+");
    }

    else if(value == 3)
    {
        System.out.println("+--------+");
        System.out.println("|  0     |");
        System.out.println("|    0   |");
        System.out.println("|      0 |");
        System.out.println("+--------+");
    }
    else if(value == 4)
    {
        System.out.println("+--------+");
        System.out.println("| 0    0 |");
        System.out.println("|        |");
        System.out.println("| 0    0 |");
        System.out.println("+--------+");
    }
    else if(value ==5)
    {
        System.out.println("+--------+");
        System.out.println("| 0    0 |");
        System.out.println("|   0    |");
        System.out.println("| 0    0 |");
        System.out.println("+--------+");
    }

    else if(value ==6)
    {
        System.out.println("+--------+");
        System.out.println("| 0     0 |");
        System.out.println("| 0     0 |");
        System.out.println("| 0     0 |");
        System.out.println("+--------+");
    }
    }
//listing all of the things that you can do in the class as well as making the graphics for the dice
    
}

public class PartD {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the inital value of the die(1-6): ");
        int givenValue = in.nextInt();
        System.out.println();

        Die die = new Die(givenValue);
        System.out.println("Initial value of the die: ");
        die.view();

        while(true)
        {
        System.out.print("Let's roll some dice! What would you like to do with the die(r to roll, d to view the current value, and q to quit):");
        String move = in.nextLine();

        if(move.equals("r"))
        {
            die.roll();
            System.out.println("You rolled the die!");
        }
        else if(move.equals("d"))
        {
            die.view();
        }
        else if(move.equals("q"))
        {
        System.out.println("Goodbye! Thanks for playing!");
        break;
        }
        //essentially the body of the program itself, actually USING the class we just made to make the user able to interact with the die
     }
  }
}


