package net.plyse.chess.control.board;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public abstract class Tile {

    private final Position position;

    public Tile(Position position) {
        this.position = position;
    }

    public abstract boolean isOccupied();

    public Position getPosition() {
        return position;
    }
}
