import java.util.Scanner;
public class Testprep {
    public static void main(String[] args) {
        int spacecount = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a phrase to measure the amount of spaces: ");
        String phrase = in.nextLine();

        for (int i = phrase.length()-1; i>=0; i--)
        {
            if(phrase.charAt(i) == ' ')
            {
                spacecount = spacecount+1;
            }
        }

        System.out.println("There are " + spacecount + " spaces in your phrase.");
    }
}
