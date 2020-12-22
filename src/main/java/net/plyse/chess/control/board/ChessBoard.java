package net.plyse.chess.control.board;

import net.plyse.chess.control.game.Game;
import net.plyse.chess.control.movement.Turn;
import net.plyse.chess.control.piece.ChessPiece;
import net.plyse.chess.control.player.Player;
import net.plyse.chess.exception.InvalidTurnException;

import java.util.*;

import static net.plyse.chess.utility.Utility.CHESS_GRID_LENGTH;


/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class ChessBoard {

    private final Map<Position, Tile> chessBoard;
    // should be final
    private Game game;

    public ChessBoard() {
        this.chessBoard = createEmptyChessBoard();
    }

    public ChessBoard(List<Position> occupiedPositions) {
        this.chessBoard = createChessBoardWithOccupiedTiles(occupiedPositions);
    }

    public ChessBoard(List<Position> occupiedPositions, List<Position> emptyPositions) {
        this.chessBoard = createEmptyAndOccupiedChessBoard(occupiedPositions, emptyPositions);
    }

    private Map<Position, Tile> createEmptyAndOccupiedChessBoard(List<Position> occupiedPositions,
                                                                 List<Position> emptyPositions) {
        Map<Position, Tile> map = new HashMap<>();
        for (int y = 0; y < CHESS_GRID_LENGTH; y++) {
            for (int x = 0; x < CHESS_GRID_LENGTH; x++) {
                Position position = new Position(x, y);
                Tile tile;
                int occupiedIndex = occupiedPositions.indexOf(position);
                int emptyIndex = emptyPositions.indexOf(position);
                if (occupiedIndex != -1) {
                    position = occupiedPositions.get(occupiedIndex);
                    tile = new OccupiedTile(occupiedPositions.get(occupiedIndex));
                } else {
                    if (emptyIndex != -1) {
                        position = emptyPositions.get(emptyIndex);
                        tile = new EmptyTile(emptyPositions.get(emptyIndex));
                    } else  {
                        tile = new EmptyTile(position);
                    }
                }
                map.put(position, tile);
            }
        }
        return map;
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

    private Map<Position, Tile> createChessBoardWithOccupiedTiles(List<Position> occupiedPositions) {
        Map<Position, Tile> map = new HashMap<>();
        for (int y = 0; y < CHESS_GRID_LENGTH; y++) {
            for (int x = 0; x < CHESS_GRID_LENGTH; x++) {
                Position position = new Position(x, y);
                Tile tile;
                int index = occupiedPositions.indexOf(position);
                if (index != -1) {
                    position = occupiedPositions.get(index);
                    tile = new OccupiedTile(occupiedPositions.get(index));
                } else {
                    tile = new EmptyTile(position);
                }
                map.put(position, tile);
            }
        }
        return map;
    }


    //todo create a interface for those methoes - maybe
    public boolean isPositionOccupied(Position position) {
        return this.chessBoard.get(position).isOccupied();
    }

    public boolean isPositionOccupiedByOpponent(Position position, Player player) {
        if (isPositionOccupied(position)) {
            OccupiedTile occupiedTile = (OccupiedTile) this.chessBoard.get(position);
            return occupiedTile.isOpponent(player);
        }
        return false;
    }

    public void move(ChessPiece chessPiece, Turn turn) {
        if (turn.isValidMove(chessPiece)) {
            Position chessPiecePosition = chessPiece.getPosition();
            Position chessPieceBufferPosition = new Position(chessPiecePosition);
            chessPiecePosition.changePosition(turn, chessPiece);
            changePosition(chessPiece, turn, chessPieceBufferPosition);
            return;
        }
        throw new InvalidTurnException();
    }

    private void changePosition(ChessPiece chessPiece, Turn turn, Position chessPieceBufferPosition) {
        Position turnPosition = turn.getDestinationPosition();
        turnPosition.changePosition(turn, chessPiece, chessPieceBufferPosition);
    }

    @Deprecated
    public Tile getTile(Position position) {
        return this.chessBoard.get(position);
    }

    @Deprecated
    public Tile getTile(int xCoordinate, int yCoordinate) {
        Position position = new Position(xCoordinate,yCoordinate);
        return getTile(position);
    }

    public Map<Position, Tile> getChessBoard() {
        return Collections.unmodifiableMap(this.chessBoard);
    }

}
