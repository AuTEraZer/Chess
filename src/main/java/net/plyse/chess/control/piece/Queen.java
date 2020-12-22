package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.DiagonalMovement;
import net.plyse.chess.control.movement.HorizontalMovement;
import net.plyse.chess.control.movement.VerticalMovement;
import net.plyse.chess.control.player.Player;
import net.plyse.chess.utility.Utility;

import static net.plyse.chess.utility.Utility.QUEEN_NOTATION;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class Queen extends ChessPiece{

    public Queen(Position position, ChessBoard chessBoard, Player player) {
        super(position, chessBoard, player);
    }

    @Override
    public char getPieceNotation() {
        return QUEEN_NOTATION;
    }

    @Override
    protected void addMovementSet(ChessBoard chessBoard) {
        this.movementSet.add(new VerticalMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new HorizontalMovement(chessBoard, this.position, this.player));
        this.movementSet.add(new DiagonalMovement(chessBoard, this.position, this.player));
    }
}
