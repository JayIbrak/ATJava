package LessonR01;

public class PartB {
    public static void printTriangle(int n) {
        printTriangleHelper(1, n);
    }

    public static void printTriangleHelper(int current, int n) {
        if (current > n) {
            return;
        }

        for (int i = 0; i < current; i++) {

            System.out.print("*");
        }
        System.out.println();
        printTriangleHelper(current + 1, n);
    }

    public static void main(String[] args) {
        printTriangle(5);
    }
}
