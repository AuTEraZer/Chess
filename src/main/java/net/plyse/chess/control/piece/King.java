package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.CastlingMovement;
import net.plyse.chess.control.movement.KingMovement;
import net.plyse.chess.control.player.Player;
import net.plyse.chess.utility.Utility;

import static net.plyse.chess.utility.Utility.KING_NOTATION;
import static net.plyse.chess.utility.Utility.KNIGHT_NOTATION;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class King extends ChessPiece {

    public King(Position position, ChessBoard chessBoard, Player player) {
        super(position, chessBoard, player);
    }

    @Override
    public char getPieceNotation() {
        return KING_NOTATION;
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new KingMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new CastlingMovement(chessBoard, this.position, this.player));
        //todo add movement for not getting captured
    }
}
