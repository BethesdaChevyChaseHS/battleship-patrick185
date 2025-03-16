package bcc.battleship;

public class Location {
    // Instance variables
    private boolean containsShip;
    private int status;
    // Constructor. Initializes with no ship and status UNGUESSED.
    public Location() {
        containsShip = false;
        status = Constants.UNGUESSED;
    }

    // Was this Location a hit?
    public boolean checkHit() {
        if (status == Constants.HIT) {
            return true;
        }
        return false;
    }

    // Was this location a miss?
    public boolean checkMiss() {
        if (status == Constants.MISSED) {
            return true;
        }
        return false;
    }

    // Was this location unguessed?
    public boolean isUnguessed() {
        if (status == Constants.UNGUESSED) {
            return true;
        }
        return false;
    }

    // Mark this location as a hit.
    public void markHit() {
        status = Constants.HIT;
    }

    // Mark this location as a miss.
    public void markMiss() {
        status = Constants.MISSED;
    }

    // Return whether or not this location has a ship.
    public boolean hasShip() {
        if (containsShip == false) {
            return false;
        }
        return true;
    }

    // Set whether this location has a ship.
    public void setShip(boolean val) {
        if (val) {
            containsShip = true;
        }
        else {
            containsShip = false;
        }
    }

    // Set the status of this Location.
    public void setStatus(int status) {
        this.status = status;
    }

    // Get the status of this Location.
    public int getStatus() {
        return status;
    }
}
