package net.plyse.chess.control.movement;


import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.board.Tile;
import net.plyse.chess.control.player.Player;

import java.util.HashSet;
import java.util.Set;

import static net.plyse.chess.utility.Utility.CHESS_GRID_LENGTH;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class VerticalMovement extends Move implements Movement {

    public VerticalMovement(ChessBoard chessBoard, Position position, Player player) {
        super(chessBoard, position, player);
    }

    @Override
    public Set<Turn> getPossibleTurns() {
        Set<Turn> possibleTurns = new HashSet<>();
        int currentYPosition = this.position.getYCoordinate(),
                currentXPosition = this.position.getXCoordinate();

        for (int yCoordinate = 0; yCoordinate < currentYPosition; yCoordinate++) {
            Position possibleTurnDestination = new Position(currentXPosition, yCoordinate);
            if(this.chessBoard.isPositionOccupied(possibleTurnDestination)
                    && !this.chessBoard.isPositionOccupiedByOpponent(this.position, this.player)) {
                break;
            } else {
                possibleTurns.add(new Turn(possibleTurnDestination, this.chessBoard));
                if (this.chessBoard.isPositionOccupiedByOpponent(this.position, this.player)) {
                    break;
                }
            }
        }

        for (int yCoordinate = currentYPosition + 1; yCoordinate < CHESS_GRID_LENGTH; yCoordinate++) {
            Position possibleTurnDestination = new Position(currentXPosition, yCoordinate);
            if(this.chessBoard.isPositionOccupied(possibleTurnDestination)
                    && !this.chessBoard.isPositionOccupiedByOpponent(this.position, this.player)) {
                break;
            } else {
                possibleTurns.add(new Turn(possibleTurnDestination, this.chessBoard));
                if (this.chessBoard.isPositionOccupiedByOpponent(this.position, this.player)) {
                    break;
                }
            }
        }

        return possibleTurns;
    }

    @Override
    public boolean isValidTurn(Turn turn) {
        Position position = turn.getDestinationPosition();
        if (position.getXCoordinate() != this.position.getXCoordinate()) {
            return false;
        }
        int yOfValidatingTurn = position.getYCoordinate(),
                yOfCurrentMovement = this.position.getYCoordinate(),
                xPosition = this.position.getXCoordinate();

        if (yOfValidatingTurn > yOfCurrentMovement) {
            for (int i = yOfValidatingTurn; i > yOfCurrentMovement; i--) {
                Position possibleTurnDestination = new Position(xPosition, i);
                Tile tile = this.chessBoard.getTile(xPosition, i);
                if (tile.isOccupied()) {
                    return false;
                }
            }
        } else {
            for (int i = yOfValidatingTurn; i < yOfCurrentMovement; i++) {
                Tile tile = this.chessBoard.getTile(xPosition, i);
                if (tile.isOccupied()) {
                    return false;
                }
            }
        }
        return true;
    }

}
