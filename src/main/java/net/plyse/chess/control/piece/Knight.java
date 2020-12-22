package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.KnightMovement;
import net.plyse.chess.control.player.Player;
import net.plyse.chess.utility.Utility;

import static net.plyse.chess.utility.Utility.KNIGHT_NOTATION;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Knight extends ChessPiece{

    public Knight(Position position, ChessBoard chessBoard, Player player) {
        super(position, chessBoard, player);
    }

    @Override
    public char getPieceNotation() {
        return KNIGHT_NOTATION;
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new KnightMovement(chessBoard, this.position, this.player));
    }
}
