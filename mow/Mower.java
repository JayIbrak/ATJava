/*
 * Jahja Ibrakovic
 * 2-6-25
 */
package mow;

import java.util.Random;
import mow.Yard;

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
        direction = (direction + 3) % 4;
    }

    public void turnRight() {
        direction = (direction + 1) % 4;
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
        yard.setCell(row, column, ' ');
    }

    public void randomizeInitialPosition(Yard yard) {
        int corner = (int) (Math.random() * 4);
        if (corner == 0) {
            row = 1;
            column = 1;
        } else if (corner == 1) {
            row = 1;
            column = yard.getWidth();
        } else if (corner == 2) {
            row = yard.getHeight();
            column = 1;
        } else if (corner == 3) {
            row = yard.getHeight();
            column = yard.getWidth();
        }
        direction = (int) (Math.random() * 4);
    }

    public boolean activateRoombaMode(Yard yard) {// I'm building the roomba algorithm using conditionals.
                                                  // I will come back to this and see if I can find a more efficient
                                                  // approach
                                                  // but this is just to get a functioning program for now
        int frontRow = row;
        int frontColumn = column;
        if (direction == 0) {
            frontRow--;
        } else if (direction == 1) {
            frontColumn++;
        } else if (direction == 2) {
            frontRow++;
        } else if (direction == 3) {
            frontColumn--;
        }

        if (isWithinYard(frontRow, frontColumn, yard) && yard.getCell(frontRow, frontColumn) == '+') {
            moveForward();
            return true;
        }

        int rightDirection = (direction + 1) % 4;
        int rightRow = row;
        int rightColumn = column;
        if (rightDirection == 0) {
            rightRow--;
        } else if (rightDirection == 1) {
            rightColumn++;
        } else if (rightDirection == 2) {
            rightRow++;
        } else if (rightDirection == 3) {
            rightColumn--;
        }

        if (isWithinYard(rightRow, rightColumn, yard) && yard.getCell(rightRow, rightColumn) == '+') {
            turnRight();
            moveForward();
            return true;
        }

        int leftDirection = (direction + 3) % 4;
        int leftRow = row;
        int leftColumn = column;
        if (leftDirection == 0) {
            leftRow--;
        } else if (leftDirection == 1) {
            leftColumn++;
        } else if (leftDirection == 2) {
            leftRow++;
        } else if (leftDirection == 3) {
            leftColumn--;
        }
        if (isWithinYard(leftRow, leftColumn, yard) && yard.getCell(leftRow, leftColumn) == '+') {
            turnLeft();
            moveForward();
            return true;
        }
        return false;
    }

    private boolean isWithinYard(int r, int c, Yard yard) {
        return (r >= 1 && r <= yard.getHeight() && c >= 1 && c <= yard.getWidth());
    }
}
