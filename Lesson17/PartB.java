package Lesson17;

public class PartB {
    public static void main(String[] args) {
        int[][] arrayOne = 
        {
            {8,6,7},
            {5,3,0}
        };

         int[][] arrayTwo = 
        {
            {0,7,6,5},
            {2,2,0,1},
            {8,4,5,7}
        };
        System.out.println("The values in array one are: ");
        print(arrayOne);

        System.out.println("The values in array two are: ");
        print(arrayTwo);
    }

    public static void print(int[][] values)
    {
        for(int row = 0; row < values.length; row ++)
        {
            for(int column = 0; column < values[row].length; column++)
            {
                if(column == 0)
                {
                    System.out.print(" " + values[row][column]);
                }
                else
                {
                    System.out.print(", " + values[row][column]);
                }
            }
           System.out.println();
        }
    }
}
