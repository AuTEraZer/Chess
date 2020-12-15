package net.plyse.chess;


import static org.junit.Assert.assertEquals;

/**
 * @author Raphael Dichler on 15.12.20
 * @project Chess
 */
public class MainTest {


    @org.junit.Test
    public void returnNumberOne() {
        Main main = new Main();
        assertEquals(2, main.returnNumberOne());
    }
}