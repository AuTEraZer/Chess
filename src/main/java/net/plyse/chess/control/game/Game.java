package net.plyse.chess.control.game;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.player.Color;
import net.plyse.chess.control.player.Player;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Game {

    // winning condition - like capture the king in 2 turns, or normal game
    private ChessBoard chessBoard;
    private final Player whitePlayer;
    private final Player blackPlayer;
    // rule set
    // creating chessBoards - in Utility - stand. Chess Game eg.

    public Game(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.blackPlayer = new Player(Color.BLACK, null);
        this.whitePlayer = new Player(Color.WHITE, null, this.blackPlayer);
        this.blackPlayer.setOpponentPlayer(this.whitePlayer);
    }

    public Player getOpponent(Player player) {
        return (player == this.whitePlayer) ? this.blackPlayer : this.whitePlayer;
    }

    public Player getWhitePlayer() {
        return this.whitePlayer;
    }

    public Player getBlackPlayer() {
        return this.blackPlayer;
    }
}
