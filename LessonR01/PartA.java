package LessonR01;

public class PartA {
    public static void printInverted(int n) {
        if (n <= 0) {
            return;
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printInverted(5);
    }
}
