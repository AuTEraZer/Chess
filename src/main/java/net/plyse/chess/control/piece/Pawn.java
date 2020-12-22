package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.EnPassantMovement;
import net.plyse.chess.control.movement.FirstPawnMovement;
import net.plyse.chess.control.movement.PawnMovement;
import net.plyse.chess.control.movement.PromotionMovement;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Pawn extends ChessPiece {

    public Pawn(Position position, ChessBoard chessBoard) {
        super(position, chessBoard);
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new PawnMovement(chessBoard, this.position));
        this.movementSet.add(new FirstPawnMovement(chessBoard, this.position));
        this.movementSet.add(new PromotionMovement(chessBoard, this.position));
        this.movementSet.add(new EnPassantMovement(chessBoard, this.position));
    }
}
