package net.plyse.chess.control.movement;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.player.Player;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public abstract class Move {

    protected final ChessBoard chessBoard;
    protected Position position;
    protected Player player;

    public Move(ChessBoard chessBoard, Position position, Player player) {
        this.chessBoard = chessBoard;
        this.position = position;
        this.player = player;
    }

}
