package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.piece.ChessPiece;
import net.plyse.chess.control.piece.King;
import org.junit.Before;
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

    private ChessBoard emptyChessBoardA;
    private ChessBoard emptyChessBoardB;

    @Before
    public void setUp() throws Exception {
        this.emptyChessBoardA = new ChessBoard();
        this.emptyChessBoardB = new ChessBoard();
    }

    @Test
    public void makeTurn() {
        List<Position> positions = new ArrayList<>();
        List<Position> positionsFree = new ArrayList<>();
        Position startPosition = new Position(3,3);
        Position destinationPosition = new Position(4,3);
        positions.add(startPosition);
        positionsFree.add(destinationPosition);
        ChessBoard chessBoard = new ChessBoard(positions, positionsFree);
        King king = new King(startPosition, chessBoard);
        Turn turn = new Turn(destinationPosition, chessBoard);
        turn.makeTurn(king);
        assertTrue(startPosition.getXCoordinate() == 4);
        assertTrue(destinationPosition.getXCoordinate() == 3);
    }

    @Test
    public void equals() {
        Position positionA = new Position(1,1);
        Position positionB = new Position(2,2);

        Turn turnA = new Turn(positionA, this.emptyChessBoardA);
        Turn turnB = new Turn(positionA, this.emptyChessBoardA);
        assertTrue(turnA.equals(turnB));

        Turn turnC = new Turn(positionA, this.emptyChessBoardA);
        Turn turnD = new Turn(positionB, this.emptyChessBoardA);
        assertFalse(turnC.equals(turnD));

        Turn turnE = new Turn(positionA, this.emptyChessBoardB);
        Turn turnF = new Turn(positionA, this.emptyChessBoardA);
        assertFalse(turnE.equals(turnF));

    }

}