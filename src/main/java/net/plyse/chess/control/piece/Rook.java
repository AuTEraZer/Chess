package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.CastlingMovement;
import net.plyse.chess.control.movement.HorizontalMovement;
import net.plyse.chess.control.movement.VerticalMovement;
import net.plyse.chess.control.player.Player;
import net.plyse.chess.utility.Utility;

import static net.plyse.chess.utility.Utility.ROOK_NOTATION;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Rook extends ChessPiece{

    public Rook(Position position, ChessBoard chessBoard, Player player) {
        super(position, chessBoard, player);
    }

    @Override
    public char getPieceNotation() {
        return ROOK_NOTATION;
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new VerticalMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new HorizontalMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new CastlingMovement(chessBoard, this.position, this.player));
    }

}
