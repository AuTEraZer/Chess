package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.piece.King;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class TurnTest {

    @Test
    public void makeTurn() {

        List<Position> positions = new ArrayList<>();
        Position startPosition = new Position(3,3);
        Position destinationPosition = new Position(4,3);
        positions.add(startPosition);
        positions.add(destinationPosition);
        ChessBoard chessBoard = new ChessBoard(positions);

        King king = new King(startPosition, chessBoard);
        Turn turn = new Turn(destinationPosition, chessBoard);
        turn.makeTurn(king);
        assertTrue(startPosition.getXCoordinate() == 4);
        assertTrue(destinationPosition.getXCoordinate() == 3);

    }
}