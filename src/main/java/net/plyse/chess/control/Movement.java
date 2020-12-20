package net.plyse.chess.control;

import java.util.Set;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public interface Movement {

    Set<Turn> getPossibleTurns();
    boolean isValidTurn(Turn turn);

}
