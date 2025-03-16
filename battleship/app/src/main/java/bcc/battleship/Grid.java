package bcc.battleship;

public class Grid {
    private Location[][] grid;

    // Constructor: Initialize the grid with Location objects
    public Grid() {
        grid = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
        for (int row = 0; row < Constants.NUM_ROWS; row++) {
            for (int col = 0; col < Constants.NUM_COLS; col++) {
                grid[row][col] = new Location();
            }
        }
    }

    // Mark a hit in the specified location
    public void markHit(int row, int col) {
        grid[row][col].markHit();
    }

    // Mark a miss in the specified location
    public void markMiss(int row, int col) {
        grid[row][col].markMiss();
    }

    // Set the status of the Location at (row, col)
    public void setStatus(int row, int col, int status) {
        grid[row][col].setStatus(status);
    }

    // Get the status of the Location at (row, col)
    public int getStatus(int row, int col) {
        return grid[row][col].getStatus();
    }

    // Return whether this Location has already been guessed
    public boolean alreadyGuessed(int row, int col) {
        return !grid[row][col].isUnguessed();
    }

    // Set whether there is a ship at this location
    public void setShip(int row, int col, boolean val) {
        grid[row][col].setShip(val);
    }

    // Return whether there is a ship at this location
    public boolean hasShip(int row, int col) {
        return grid[row][col].hasShip();
    }

    // Get the Location object at this row and column
    public Location get(int row, int col) {
        return grid[row][col];
    }

    // Return the number of rows
    public int numRows() {
        return Constants.NUM_ROWS;
    }

    // Return the number of columns
    public int numCols() {
        return Constants.NUM_COLS;
    }

    // Add a ship to the grid
    public boolean addShip(Ship s) {
        int row = s.getRow();
        int col = s.getCol();
        int direction = s.getDirection();
        int length = s.getLength();

        // Check if the ship is within bounds
        if (direction == Constants.HORIZONTAL) {
            if (col + length > Constants.NUM_COLS) return false;
            for (int i = 0; i < length; i++) {
                if (hasShip(row, col + i)) return false;
            }
            for (int i = 0; i < length; i++) {
                setShip(row, col + i, true);
            }
        } else if (direction == Constants.VERTICAL) {
            if (row + length > Constants.NUM_ROWS) return false;
            for (int i = 0; i < length; i++) {
                if (hasShip(row + i, col)) return false;
            }
            for (int i = 0; i < length; i++) {
                setShip(row + i, col, true);
            }
        } else {
            return false;
        }
        return true;
    }

    // Check if all ships have been sunk
    public boolean allShipsSank() {
        for (int row = 0; row < Constants.NUM_ROWS; row++) {
            for (int col = 0; col < Constants.NUM_COLS; col++) {
                if (hasShip(row, col) && getStatus(row, col) != Constants.HIT) {
                    return false;
                }
            }
        }
        return true;
    }
}