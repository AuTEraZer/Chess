package net.plyse.chess.control;

import net.plyse.chess.piece.ChessPiece;

/**
 * @author Raphael Dichler on 17.12.20
 * @project Chess
 */
public class Turn {

    private Position destinationPosition;
    private ChessBoard chessBoard;

    public void makeTurn(ChessPiece chessPiece) {
        Position oldPositionOfChessPiece = chessPiece.getPosition();
        chessPiece.setPosition(destinationPosition);
        Tile startTile = chessBoard.getTile(oldPositionOfChessPiece);
        startTile.setOccupied(false);
        Tile destinationTile = chessBoard.getTile(this.destinationPosition);
        destinationTile.setOccupied(true);
    }

}
