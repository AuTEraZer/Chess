package net.plyse.chess.control.board;

import java.util.Collections;
import java.util.Map;
import java.util.Set;


/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class ChessBoard {

    private final Map<Position, Tile> chessBoard;

    public ChessBoard() {
        this.chessBoard = null;
    }

    public ChessBoard(Set<Position> occupiedPosition) {
        this.chessBoard = null;
    }

    Tile getTile(Position position) {
        return this.chessBoard.get(position);
    }

    public Map<Position, Tile> getChessBoard() {
        return Collections.unmodifiableMap(this.chessBoard);
    }

}
