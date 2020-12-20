package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.DiagonalMovement;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Bishop extends ChessPiece{

    public Bishop(Position position, ChessBoard chessBoard) {
        super(position, chessBoard);
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new DiagonalMovement(chessBoard, this.position));
    }
}
