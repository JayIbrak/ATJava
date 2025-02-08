/*
 * Jahja Ibrakovic
 * 2-6-25
 */
package mow;

public class Mower {
    private int row;
    private int column;
    private int direction;

    public Mower(int row, int column, int direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getDirection() {
        return direction;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void moveForward() {
        if (direction == 0) {
            row--;
        } else if (direction == 1) {
            column++;
        } else if (direction == 2) {
            row++;
        } else if (direction == 3) {
            column--;
        }
    }

    public void turnLeft() {
        setDirection(direction - 1);
    }

    public void turnRight() {
        setDirection(direction + 1);
    }

    public char sensor(Yard yard) {
        int nextRow = row;
        int nextColumn = column;
        if (direction == 0) {
            nextRow--;
        } else if (direction == 1) {
            nextColumn++;
        } else if (direction == 2) {
            nextRow++;
        } else if (direction == 3) {
            nextColumn--;
        }
        return yard.getCell(nextRow, nextColumn);
    }

    public void mow(Yard yard) {
        if (sensor(yard) == '+') {
            yard.setCell(row, column, ' ');
        }
    }
}
