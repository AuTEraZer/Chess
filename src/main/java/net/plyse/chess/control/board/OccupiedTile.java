package net.plyse.chess.control.board;

import net.plyse.chess.control.piece.ChessPiece;
import net.plyse.chess.control.player.Player;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class OccupiedTile extends Tile {

    private ChessPiece chessPiece;

    public OccupiedTile(Position position) {
        super(position);
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    public boolean isOpponent(Player player) {
        return this.chessPiece.getPlayer().isOpponent(player);
    }

}
