package net.plyse.chess.control.piece;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.movement.Movement;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.Turn;
import net.plyse.chess.control.player.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public abstract class ChessPiece implements Movement {

    protected Position position;
    protected Set<Movement> movementSet;
    protected Player player;

    public ChessPiece(Position position, ChessBoard chessBoard, Player player) {
        this.position = position;
        this.movementSet = new HashSet<>();
        this.player = player;
        addMovementSet(chessBoard);
    }

    public Player getPlayer() {
        return player;
    }

    public Position getPosition() {
        return this.position;
    }

    public abstract char getPieceNotation();

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
