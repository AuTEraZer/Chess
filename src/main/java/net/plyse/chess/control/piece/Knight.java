package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.HorizontalMovement;
import net.plyse.chess.control.movement.KnightMovement;
import net.plyse.chess.control.movement.VerticalMovement;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Knight extends ChessPiece{


    public Knight(Position position, ChessBoard chessBoard) {
        super(position, chessBoard);
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new KnightMovement(chessBoard, this.position));
    }
}
