package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by srf3
 */
public class TicTacToeTest {
    //InvalidInput tests
    @Test
    public void checkProperLength() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(null));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(""));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("."));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(".."));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("..."));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("...."));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("....."));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("......"));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("......."));
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("........"));
    }

    //NoWinner tests
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }

    //XWins tests
    @Test
    public void horizontalXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XXXO.O..."));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("O..XXX.O."));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("...OO.XXX"));
    }
    @Test
    public void verticalXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XO.XO.X.."));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard(".X.OXO.X."));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("..XO.XO.X"));
    }
    @Test
    public void diagonalXWins() throws Exception {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("X.O.X.O.X"));
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("..XOXOX.."));
    }

    //OWins tests
    @Test
    public void horizontalOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OOO.XXX.X"));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XX.OOOXX."));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XX.XX.OOO"));
    }
    @Test
    public void verticalOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OXXOXXO.."));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XOXXOX.O."));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XXO..OXXO"));
    }
    @Test
    public void diagonalOWins() throws Exception {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OXXXO.X.O"));
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("X.OXOXO.X"));
    }

    //UnreachableState tests
    @Test
    public void moreOsThanXs() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXXXOOOOO"));
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXXOOOO.."));

    }
}