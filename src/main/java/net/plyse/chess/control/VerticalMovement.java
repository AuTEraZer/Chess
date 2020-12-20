package net.plyse.chess.control;


import java.util.Set;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class VerticalMovement extends Move implements Movement {

    public VerticalMovement(ChessBoard chessBoard, Position position) {
        super(chessBoard, position);
    }

    @Override
    public Set<Turn> getPossibleTurns() {
        return null;
    }

    @Override
    public boolean isValidTurn(Turn turn) {
        return true;
    }

}
