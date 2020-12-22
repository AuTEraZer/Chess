package net.plyse.chess.control.board;

import net.plyse.chess.control.movement.Turn;
import net.plyse.chess.control.piece.ChessPiece;
import net.plyse.chess.exception.InvalidTurnException;

import java.util.Objects;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Position(Position position) {
        this.xCoordinate = position.xCoordinate;
        this.yCoordinate = position.yCoordinate;
    }

    public void changePosition(Turn turn, ChessPiece chessPiece) {
        if (turn.isValidMove(chessPiece)) {
            this.xCoordinate = turn.getDestinationPosition().xCoordinate;
            this.yCoordinate = turn.getDestinationPosition().yCoordinate;
            return;
        }
        throw new InvalidTurnException();
    }

    public void changePosition(Turn turn, ChessPiece chessPiece, Position position) {
        if (turn.isValidMove(chessPiece)) {
            this.xCoordinate = position.xCoordinate;
            this.yCoordinate = position.yCoordinate;
            return;
        }
        throw new InvalidTurnException();
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return (position.xCoordinate == this.xCoordinate && position.yCoordinate == this.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}

