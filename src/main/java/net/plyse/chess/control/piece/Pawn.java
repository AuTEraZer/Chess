package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.EnPassantMovement;
import net.plyse.chess.control.movement.FirstPawnMovement;
import net.plyse.chess.control.movement.PawnMovement;
import net.plyse.chess.control.movement.PromotionMovement;
import net.plyse.chess.control.player.Player;

import static net.plyse.chess.utility.Utility.PAWN_NOTATION;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Pawn extends ChessPiece {

    public Pawn(Position position, ChessBoard chessBoard, Player player) {
        super(position, chessBoard, player);
    }

    @Override
    public char getPieceNotation() {
        return PAWN_NOTATION;
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new PawnMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new FirstPawnMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new PromotionMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new EnPassantMovement(chessBoard, this.position, this.player));
    }
}
