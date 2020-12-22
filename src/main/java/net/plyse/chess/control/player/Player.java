package net.plyse.chess.control.player;

import net.plyse.chess.control.piece.ChessPiece;
import net.plyse.chess.exception.InvalidOpponentException;

import java.util.Set;

/**
 * @author Raphael Dichler on 22.12.20
 * @project Chess
 */
public class Player {

    private final Player opponentPlayer;
    private final Color color;
    // should be accessable and deleteable could be final
    private Set<ChessPiece> pieceSet;


    //todo add a builder for player
    public Player(Color color, Set<ChessPiece> pieceSet) {
        this.opponentPlayer = new Player(color.getOpponent(), null, this);
        this.color = color;
        this.pieceSet = pieceSet;
    }

    public Player(Color color, Set<ChessPiece> pieceSet, Player player) {
        this.opponentPlayer = player;
        this.color = color;
        this.pieceSet = pieceSet;
    }

    public boolean isOpponent(Player player) {
        if (this.opponentPlayer == player) {
            return color.isOpponent(player.color);
        }
        throw new InvalidOpponentException("Cannot set the same Player object as opponent.");
    }

}
