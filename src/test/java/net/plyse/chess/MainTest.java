package net.plyse.chess;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raphael Dichler on 15.12.20
 * @project Chess
 */
class MainTest {

    @org.junit.jupiter.api.Test
    void returnNumberOne() {
        Main main = new Main();
        assertEquals(1,main.returnNumberOne(), "Should be 1");
    }
}