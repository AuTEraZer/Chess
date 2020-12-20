package net.plyse.chess.control;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.plyse.chess.utility.Utility.CHESS_GRID_LENGTH;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class ChessBoard {

    private final Map<Position, Tile> chessBoard;

    public ChessBoard() {
        this.chessBoard = getEmptyChessBoard();
    }

    public ChessBoard(Set<Position> occupiedPosition) {
        this.chessBoard = getChessBoardWithOccupiedPositions(occupiedPosition);
    }

    private static Map<Position, Tile> getEmptyChessBoard() {
        Map<Position, Tile> map = new HashMap<>();
        for (int yCoordinate = 0; yCoordinate < CHESS_GRID_LENGTH; yCoordinate++) {
            for (int xCoordinate = 0; xCoordinate < CHESS_GRID_LENGTH; xCoordinate++) {
                Position pos = new Position(xCoordinate, yCoordinate);
                Tile tile = new Tile(pos, true);
                map.put(pos, tile);
            }
        }
        return map;
    }

    private static Map<Position, Tile> getChessBoardWithOccupiedPositions(Set<Position> occupiedPositions) {
        Map<Position, Tile> map = getEmptyChessBoard();
        for (Position occupiedPosition : occupiedPositions) {
            map.get(occupiedPosition).setOccupied(true);
        }
        return map;
    }


    Tile getTile(Position position) {
        return this.chessBoard.get(position);
    }

    public Map<Position, Tile> getChessBoard() {
        return Collections.unmodifiableMap(this.chessBoard);
    }

}
