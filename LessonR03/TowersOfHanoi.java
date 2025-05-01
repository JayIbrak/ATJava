package LessonR03;

public class TowersOfHanoi {
    public static void main(String[] args) {
        int discNum = 3;
        int startPeg = 1;
        int endPeg = 3;

        hanoi(discNum, startPeg, endPeg);
    }

    public static void hanoi(int n, int start, int end) {
        if (n == 1) {
            printMove(start, end);
        } else {
            int interim = getInterim(start, end);
            hanoi(n - 1, start, interim);
            printMove(start, end);
            hanoi(n - 1, interim, end);
        }
    }

    public static int getInterim(int start, int end) {
        return 6 - start - end;
    }

    public static void printMove(int start, int end) {
        System.out.println(start + " -> " + end);
    }
}