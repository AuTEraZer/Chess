package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.piece.ChessPiece;

import java.util.Objects;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Turn {

    private final Position destinationPosition;
    private final ChessBoard chessBoard;

    public Turn(Position destinationPosition, ChessBoard chessBoard) {
        this.destinationPosition = destinationPosition;
        this.chessBoard = chessBoard;
    }

    public void makeTurn(ChessPiece chessPiece) {
        if (isValidMove(chessPiece)) {
            chessBoard.move(chessPiece, this);
        }
        //todo throw an error/exception
    }

    public Position getDestinationPosition() {
        return this.destinationPosition;
    }

    public boolean isValidMove(Movement chessPiece) {
        //return true;
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

    // todo check if thats ok
    @Override
    public int hashCode() {
        return Objects.hash(destinationPosition, chessBoard);
    }
}
