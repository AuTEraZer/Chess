package net.plyse.chess.piece;

import net.plyse.chess.control.Movement;
import net.plyse.chess.control.Position;
import net.plyse.chess.control.Turn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public abstract class ChessPiece implements Movement {

    protected Position position;
    protected Set<Movement> movementSet;

    public ChessPiece(Position position) {
        this.position = position;
        addMovementSet();
    }

    protected abstract void addMovementSet();

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public Set<Turn> getPossibleTurns() {
        Set<Turn> turnSet = new HashSet<>();
        for (Movement movement : this.movementSet) {
            Set<Turn> turnCollection = movement.getPossibleTurns();
            turnSet.addAll(turnCollection);
        }
        return turnSet;
    }
}
