package JavaTest2;
public class Problem05{
 public static void main(String[] args) {
   int total = 0;
   int count = 0;
   
    for(int i = 1; i<= 100; i++)
    {
        total = total + i;
        count = count + 1;
    }

    double average = total/count;
    System.out.printf("The average of all numbers between 1 and 100 is %.2f%n", average);
    }
}

