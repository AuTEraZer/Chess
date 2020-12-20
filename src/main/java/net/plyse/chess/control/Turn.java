package net.plyse.chess.control;

import java.util.Objects;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Turn {

    // should be the same ref as the board position
    private final Position destinationPosition;
    private final ChessBoard chessBoard;

    public Turn(Position destinationPosition, ChessBoard chessBoard) {
        this.destinationPosition = destinationPosition;
        this.chessBoard = chessBoard;
    }


    // is used by the player
    public void makeTurn(ChessPiece chessPiece) {
        if (isValidMove(chessPiece)) {

            // is maybe unnecessary if the ChessPiece class has the same position ref as the chessBoard
            Position oldPositionOfChessPiece = chessPiece.getPosition();

            //is maybe unnecessary if the member var destinationPosition is the same ref as the chess board
            Tile startTile = this.chessBoard.getTile(oldPositionOfChessPiece);
            startTile.setOccupied(false);

            chessPiece.setPosition(destinationPosition);

            Tile destinationTile = chessBoard.getTile(this.destinationPosition);
            destinationTile.setOccupied(true);
        }
    }

    private boolean isValidMove(Movement chessPiece) {
        return chessPiece.isValidTurn(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turn turn = (Turn) o;
        return (turn.chessBoard == this.chessBoard &&
                (turn.destinationPosition.getXCoordinate() == this.destinationPosition.getXCoordinate() &&
                        turn.destinationPosition.getYCoordinate() == this.destinationPosition.getYCoordinate()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationPosition, chessBoard);
    }
}
