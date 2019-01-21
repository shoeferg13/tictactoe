package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by srf3
 */
public class TicTacToeTest {
    //InvalidInput tests
    @Test
    public void checkEmptyString() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(""));
    }

    @Test
    public void checkNull() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(null));
    }

    @Test
    public void checkTooShortString() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("XO."));
    }
    @Test
    public void checkTooLongString() throws Exception {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("XO.XOXOXOXOX.......X"));
    }

    //NoWinner tests
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }
    @Test
    public void complexNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("XOXXOXOXO"));
    }
    @Test
    public void emptyNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("........."));
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
    }
    @Test
    public void multipleHorizWinners() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXX...OOO"));
    }
    @Test
    public void multipleVertWinners() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("X.OX.OX.O"));
    }
    @Test
    public void tooManyXs() throws Exception {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XX.XOOX.."));
    }
}