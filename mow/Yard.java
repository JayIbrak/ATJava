/*
 * Jahja Ibrakovic
 * 2-3-25
 */
package mow;

public class Yard {
    private char[][] yard;
    private int lawnHeight;
    private int lawnWidth;
    // initializing stuff --> the yard both including the red brick but also just
    // the dimensions of the grass

    public Yard(int height, int width) {
        // constructer for the yard
        this.lawnHeight = height;
        this.lawnWidth = width;

        int rows = lawnHeight + 2;
        int columns = lawnWidth + 2;
        yard = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == columns - 1) {
                    yard[i][j] = 'R'; // Red brick
                } else {
                    yard[i][j] = '+'; // Grass
                }
            }
        }
    }

    public char getCell(int row, int col) {
        return yard[row][col];
    }

    public void setCell(int row, int col, char value) {
        yard[row][col] = value;
    }

    public int getHeight() {
        return lawnHeight;
    }

    public int getWidth() {
        return lawnWidth;
    }

    public void printYard() {
        for (int i = 0; i < yard.length; i++) {
            for (int j = 0; j < yard[i].length; j++) {
                System.out.print(yard[i][j]);
            }
            System.out.println();
        }
    }
    // All the getters and setters for the yard as well as the print method

}
