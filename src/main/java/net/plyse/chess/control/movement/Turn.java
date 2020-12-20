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
            //swaps position values
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
