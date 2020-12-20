package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.piece.ChessPiece;

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
            swapPosition(chessPiece.getPosition());
        }
    }

    private void swapPosition(Position startPosition) {
        swapXCoordinate(startPosition);
        swapYCoordinate(startPosition);
    }

    private void swapXCoordinate(Position startPosition) {
        int xStartPosition = startPosition.getXCoordinate();
        startPosition.setXCoordinate(this.destinationPosition.getXCoordinate());
        destinationPosition.setXCoordinate(xStartPosition);
    }

    private void swapYCoordinate(Position startPosition) {
        int yStartPosition = startPosition.getYCoordinate();
        startPosition.setYCoordinate(this.destinationPosition.getYCoordinate());
        destinationPosition.setYCoordinate(yStartPosition);
    }

    private boolean isValidMove(Movement chessPiece) {
        return true;
        //todo change to that: return chessPiece.isValidTurn(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turn turn = (Turn) o;
        return (turn.chessBoard == this.chessBoard &&
                (turn.destinationPosition == this.destinationPosition));
    }

}
