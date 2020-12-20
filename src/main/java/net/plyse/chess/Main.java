package net.plyse.chess;

import net.plyse.chess.control.board.ChessBoard;
import net.plyse.chess.control.board.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raphael Dichler on 15.12.20
 * @project Chess
 */
public class Main {

    public static void main(String[] args) {


        List<Position> pos = new ArrayList<>();

        pos.add(new Position(1,1));
        pos.add(new Position(2,1));
        pos.add(new Position(3,1));

        System.out.println(pos.indexOf(new Position(5, 1)));


    }

}
