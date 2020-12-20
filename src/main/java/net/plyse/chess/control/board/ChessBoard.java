package net.plyse.chess.control.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.plyse.chess.utility.Utility.CHESS_GRID_LENGTH;


/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class ChessBoard{

    private final Map<Position, Tile> chessBoard;

    public ChessBoard() {
        this.chessBoard = createEmptyChessBoard();
    }

    public ChessBoard(Set<Position> occupiedPositions) {
        this.chessBoard = createChessBoardWithOccupiedTiles(occupiedPositions);
    }

    private Map<Position, Tile> createEmptyChessBoard(){
        Map<Position, Tile> map = new HashMap<>();
        for (int y = 0; y < CHESS_GRID_LENGTH; y++) {
            for (int x = 0; x < CHESS_GRID_LENGTH; x++) {
                Position position = new Position(x, y);
                Tile tile = new EmptyTile(position);
                map.put(position, tile);
            }
        }
        return map;
    }

    private Map<Position, Tile> createChessBoardWithOccupiedTiles(Set<Position> occupiedPositions) {
        Map<Position, Tile> map = createEmptyChessBoard();
        for (int y = 0; y < CHESS_GRID_LENGTH; y++) {
            for (int x = 0; x < CHESS_GRID_LENGTH; x++) {
                Position position = new Position(x, y);
                Tile tile;
                if (position.equals(occupiedPositions)) {
                    tile = new OccupiedTile(position);
                } else {
                    tile = new EmptyTile(position);
                }
                map.put(position, tile);
            }
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
