package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.piece.ChessPiece;

import java.util.Objects;

import static net.plyse.chess.utility.Utility.CAPTURE_TURN;
import static net.plyse.chess.utility.Utility.MOVE_TURN;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Turn {

    private final Position destinationPosition;
    private final ChessBoard chessBoard;
    private final boolean isAttack;

    public Turn(Position destinationPosition, ChessBoard chessBoard) {
        this.destinationPosition = destinationPosition;
        this.chessBoard = chessBoard;
        this.isAttack = isAnAttack();
    }

    public char getTurnNotation() {
        return (this.isAttack) ? CAPTURE_TURN : MOVE_TURN;
    }

    public void makeTurn(ChessPiece chessPiece) {
        chessBoard.move(chessPiece, this);
    }

    public Position getDestinationPosition() {
        return this.destinationPosition;
    }

    public boolean isValidMove(Movement chessPiece) {
        return chessPiece.isValidTurn(this);
    }

    private boolean isAnAttack() {
        return this.chessBoard.isPositionOccupied(this.destinationPosition);
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
