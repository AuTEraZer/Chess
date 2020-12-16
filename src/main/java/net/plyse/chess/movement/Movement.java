package net.plyse.chess.movement;

import java.util.Set;

/**
 * @author Raphael Dichler on 16.12.20
 * @project Chess
 */
public interface Movement {

    Set<Move> getPossibleMoves();

}
