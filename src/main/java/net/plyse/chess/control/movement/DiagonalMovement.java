package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;

import java.util.Set;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class DiagonalMovement extends Move implements Movement{

    public DiagonalMovement(ChessBoard chessBoard, Position position) {
        super(chessBoard, position);
    }

    @Override
    public Set<Turn> getPossibleTurns() {
        return null;
    }

    @Override
    public boolean isValidTurn(Turn turn) {
        return false;
    }
}
