package net.plyse.chess.control;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Tile {

    private final Position position;
    private boolean occupied;

    public Tile(Position position, boolean occupied) {
        this.position = position;
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
