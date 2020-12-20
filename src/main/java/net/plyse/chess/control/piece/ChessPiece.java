package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.movement.Movement;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.Turn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public abstract class ChessPiece implements Movement {

    protected Position position;
    protected Set<Movement> movementSet;

    public ChessPiece(Position position, ChessBoard chessBoard) {
        this.position = position;
        this.movementSet = new HashSet<>();
        addMovementSet(chessBoard);
    }

    protected abstract void addMovementSet(ChessBoard chessBoard);

    @Override
    public Set<Turn> getPossibleTurns() {
        Set<Turn> turnSet = new HashSet<>();
        for (Movement movement : this.movementSet) {
            Set<Turn> turnCollection = movement.getPossibleTurns();
            turnSet.addAll(turnCollection);
        }
        return turnSet;
    }

    @Override
    public boolean isValidTurn(Turn turn) {
        for (Movement movement : this.movementSet) {
            if (movement.isValidTurn(turn)) {
                return true;
            }
        }
        return false;
    }
}
