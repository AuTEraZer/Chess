package net.plyse.chess.control;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public abstract class Move {

    protected final ChessBoard chessBoard;
    protected Position position;

    public Move(ChessBoard chessBoard, Position position) {
        this.chessBoard = chessBoard;
        this.position = position;
    }

}
