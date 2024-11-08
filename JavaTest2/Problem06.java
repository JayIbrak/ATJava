package JavaTest2;
import java.util.Scanner;
public class Problem06{
 public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("In a second, Enter three integers to sort from greatest to least");

    System.out.print("Please enter your first number: ");
    int num1 = in.nextInt();

    System.out.print("Please enter your second number: ");
    int num2 = in.nextInt();

    System.out.print("Please enter your last number: ");
    int num3 = in.nextInt();
    int temp = 0;

    if (num1 < num2) {
        // swap values of num1 and num2
        temp = num1;
        num1 = num2;
        num2 = temp;
        
    }

   if (num1 < num3) {
        // swap values of num1 and num2
        temp = num1;
        num1 = num3;
        num3 = temp;
    }

   if (num2 < num3) {
        // swap values of num1 and num2
       temp = num2;
       num2 = num3;
       num3 = temp;
    }

    System.out.println("The order of your numbers greatest to least is " + num1 + num2 + num3);
  }
}

