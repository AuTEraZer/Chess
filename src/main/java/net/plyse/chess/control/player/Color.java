package net.plyse.chess.control.player;

/**
 * @author Raphael Dichler on 22.12.20
 * @project Chess
 */
public enum Color {

    WHITE,
    BLACK;

    boolean isOpponent(Color opponent){
        return !this.equals(opponent);
    }

    Color getOpponent() {
        return (this.equals(WHITE)) ? BLACK : WHITE;
    }

}
