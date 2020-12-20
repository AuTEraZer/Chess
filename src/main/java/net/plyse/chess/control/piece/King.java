package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.CastlingMovement;
import net.plyse.chess.control.movement.KingMovement;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class King extends ChessPiece{


    public King(Position position, ChessBoard chessBoard) {
        super(position, chessBoard);
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new KingMovement(chessBoard, this.position));
        this.movementSet.add(new CastlingMovement(chessBoard, this.position));
        //todo add movement for not getting captured
    }
}
