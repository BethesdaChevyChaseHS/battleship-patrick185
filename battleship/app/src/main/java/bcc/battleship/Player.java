package bcc.battleship;

public class Player {
    private Ship[] ships;
    private Grid myGrid;
    private Grid opponentGrid;

    public Player() {
        myGrid = new Grid();
        opponentGrid = new Grid();
        ships = new Ship[Constants.SHIP_LENGTHS.length];
        
        for (int i = 0; i < Constants.SHIP_LENGTHS.length; i++) {
            ships[i] = new Ship(Constants.SHIP_LENGTHS[i]);
        }
    }
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        if (index < 0 || index >= ships.length) {
            return false;
        }
        
        ships[index].setLocation(row, col);
        ships[index].setDirection(direction);
        
        return myGrid.addShip(ships[index]);
    }
   
    public boolean recordOpponentGuess(int row, int col) {
        if (myGrid.hasShip(row, col)) {
            myGrid.markHit(row, col);
            return true;
        } else {
            myGrid.markMiss(row, col);
            return false;
        }
    }
    
    public Grid getMyGrid() {
        return myGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
