package net.plyse.chess.control;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class ChessBoard {

    private final Map<Position, Tile> chessBoard;

    public ChessBoard() {
        this.chessBoard = new HashMap<>();
    }

    Tile getTile(Position position) {
        return null;
    }

    public Map<Position, Tile> getChessBoard() {
        return Collections.unmodifiableMap(this.chessBoard);
    }

}
