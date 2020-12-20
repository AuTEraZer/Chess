package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.CastlingMovement;
import net.plyse.chess.control.movement.HorizontalMovement;
import net.plyse.chess.control.movement.VerticalMovement;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Rook extends ChessPiece{

    public Rook(Position position, ChessBoard chessBoard) {
        super(position, chessBoard);
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new VerticalMovement(chessBoard, this.position));
        this.movementSet.add(new HorizontalMovement(chessBoard, this.position));
        this.movementSet.add(new CastlingMovement(chessBoard, this.position));
    }
}
