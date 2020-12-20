package net.plyse.chess.control.board;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class OccupiedTile extends Tile{

    public OccupiedTile(Position position) {
        super(position);
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

}
