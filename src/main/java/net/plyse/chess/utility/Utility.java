package net.plyse.chess.utility;

import net.plyse.chess.control.board.Position;
import net.plyse.chess.control.movement.Turn;
import net.plyse.chess.control.piece.ChessPiece;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public final class Utility {

    private static final StringBuilder NOTATION_BUILDER = new StringBuilder();

    public static final int CHESS_GRID_LENGTH = 8;
    public static final char KING_NOTATION = 75;
    public static final char QUEEN_NOTATION = 81;
    public static final char ROOK_NOTATION = 82;
    public static final char BISHOP_NOTATION = 66;
    public static final char KNIGHT_NOTATION = 78;
    public static final char PAWN_NOTATION = 0;
    public static final char CAPTURE_TURN = 120;
    public static final char MOVE_TURN = 45;
    public static final char MATT = 35;
    public static final char CHECKMATE = 35;
    public static final char CHECK = 43;


    // only basic moves
    public static String getDetailedAlgebraicNotation(Turn turn, ChessPiece chessPiece) {
        String startPosition = getPositionNotation(chessPiece.getPosition());
        String destinationPosition = getPositionNotation(turn.getDestinationPosition());
        return NOTATION_BUILDER
                .append(chessPiece.getPieceNotation())
                .append(startPosition)
                .append(turn.getTurnNotation())
                .append(destinationPosition)
                .toString();
    }

    private static String getPositionNotation(Position position) {
        StringBuilder positionNotation = new StringBuilder();
        return positionNotation
                .append((char) (position.getXCoordinate() + 96))
                .append(position.getYCoordinate())
                .toString();
    }


}
