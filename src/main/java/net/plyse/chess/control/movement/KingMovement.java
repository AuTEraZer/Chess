package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.player.Player;

import java.util.Set;

/**
 * @author Raphael Dichler on 20.12.20
 * @project Chess
 */
public class KingMovement extends Move implements Movement{

    public KingMovement(ChessBoard chessBoard, Position position, Player player) {
        super(chessBoard, position, player);
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
