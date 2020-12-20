package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.utility.Utility;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static net.plyse.chess.utility.Utility.CHESS_GRID_LENGTH;
import static org.junit.Assert.*;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class VerticalMovementTest {

    @Test
    public void getPossibleTurns() {
        assertTrue(obstacleTest());
        assertTrue(noObstacleTest());
    }

    private boolean obstacleTest() {
        int startY = 3;
        int obstacleY = 5;
        Position movementPosition = new Position(3,startY);
        Position obstaclePosition = new Position(3,obstacleY);
        List<Position> occupiedPositions = new ArrayList<>();
        occupiedPositions.add(movementPosition);
        occupiedPositions.add(obstaclePosition);

        List<Position> emptyPositions = new ArrayList<>();
        for (int iAbove = startY + 1; iAbove < obstacleY; iAbove++) {
            emptyPositions.add(new Position(startY, iAbove));
        }
        for (int iBeneath = startY - 1; iBeneath > 0; iBeneath--) {
            emptyPositions.add(new Position(startY, iBeneath));
        }

        ChessBoard chessBoard = new ChessBoard(occupiedPositions, emptyPositions);

        VerticalMovement verticalMovement = new VerticalMovement(chessBoard, movementPosition);
        Set<Turn> expectedSet = new HashSet<>();
        for (Position destinationPosition : emptyPositions) {
            Turn turn = new Turn(destinationPosition, chessBoard);
            expectedSet.add(turn);
        }

        return (verticalMovement.getPossibleTurns().containsAll(expectedSet) &&
                expectedSet.containsAll(verticalMovement.getPossibleTurns()));
    }

    public boolean noObstacleTest() {
        int startX = 3;
        Position movementPosition = new Position(startX,3);
        List<Position> occupiedPositions = new ArrayList<>();
        occupiedPositions.add(movementPosition);

        List<Position> emptyPositions = new ArrayList<>();
        for (int iAbove = startX + 1; iAbove < CHESS_GRID_LENGTH; iAbove++) {
            emptyPositions.add(new Position(startX, iAbove));
        }
        for (int iBeneath = startX - 1; iBeneath > 0; iBeneath--) {
            emptyPositions.add(new Position(startX, iBeneath));
        }

        ChessBoard chessBoard = new ChessBoard(occupiedPositions, emptyPositions);

        VerticalMovement verticalMovement = new VerticalMovement(chessBoard, movementPosition);
        Set<Turn> expectedSet = new HashSet<>();
        for (Position destinationPosition : emptyPositions) {
            Turn turn = new Turn(destinationPosition, chessBoard);
            expectedSet.add(turn);
        }

        return (verticalMovement.getPossibleTurns().containsAll(expectedSet) &&
                expectedSet.containsAll(verticalMovement.getPossibleTurns()));
    }

    @Test
    public void isValidTurn() {
        assertTrue(validTurn());
        assertFalse(invalidTurn());
    }

    private boolean invalidTurn() {
        ChessBoard emptyChessBoard = new ChessBoard();
        Position movementPosition = new Position(3,3);
        Position turnPosition = new Position(5, 5);
        VerticalMovement verticalMovement = new VerticalMovement(emptyChessBoard, movementPosition);
        Turn turn = new Turn(turnPosition, emptyChessBoard);
        return verticalMovement.isValidTurn(turn);
    }

    public boolean validTurn() {
        ChessBoard emptyChessBoard = new ChessBoard();
        Position movementPosition = new Position(3,3);
        Position turnPosition = new Position(3, 4);
        VerticalMovement verticalMovement = new VerticalMovement(emptyChessBoard, movementPosition);
        Turn turn = new Turn(turnPosition, emptyChessBoard);
        return verticalMovement.isValidTurn(turn);
    }


}