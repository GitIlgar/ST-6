package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.ArrayList;

public class GameTest {
    @Test
    public void testTicTacToeGrid() {
        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        assertNotNull(panel);
        assertEquals(9, panel.getComponentCount());

        // Проверка, что все элементы - это TicTacToeCell
        for (Component component : panel.getComponents()) {
            assertTrue(component instanceof TicTacToeCell);
        }
    }

    @Test
    void testGameInitialization() {
        Game game = new Game();
        assertEquals(State.PLAYING, game.state);
        assertEquals('X', game.player1.symbol);
        assertEquals('O', game.player2.symbol);
        assertArrayEquals(new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, game.board);
    }

    @Test
    void testCheckStateWinningForX() {
        Game game = new Game();
        game.symbol = 'X';
        char[] board = {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
        assertEquals(State.XWIN, game.checkState(board));
    }

    @Test
    void testEvaluatePositionDraw() {
        Game game = new Game();
        char[] board = {'X', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'X'};
        assertEquals(0, game.evaluatePosition(board, game.player1));
    }

}
