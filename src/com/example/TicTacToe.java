package com.example;

public class TicTacToe {

    public static Evaluation evaluateBoard(String boardState) {
        // implement your code here
        if (boardState == null || boardState.equals("") || boardState.length() != 9) {
            return Evaluation.InvalidInput;
        }
        int xCount = 0;
        int oCount = 0;
        char[] board = boardState.toLowerCase().toCharArray();
        // count xs and os
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 'x') {
                xCount++;
            }
            if (board[i] == 'o') {
                oCount++;
            }
        }
        // check for unreachable state
        if (xCount < oCount || xCount - 1 > oCount) {
            return Evaluation.UnreachableState;
        }
        // make string into 2D matrix
        char[][] matrixBoard = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixBoard[i][j] = board[index];
                index++;
            }
        }
        int horizXWin = 0;
        int horizOWin = 0;
        int vertXWin = 0;
        int vertOWin = 0;
        int diagXWin = 0;
        int diagOWin = 0;
        // check horiz winners
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                if (matrixBoard[i][j] == matrixBoard[i][j + 1] && matrixBoard[i][j + 2] == matrixBoard[i][j + 1] && matrixBoard[i][j] == 'x') {
                    horizXWin++;
                }
                if (matrixBoard[i][j] == matrixBoard[i][j + 1] && matrixBoard[i][j + 2] == matrixBoard[i][j + 1] && matrixBoard[i][j] == 'o') {
                    horizOWin++;
                }
            }
        }
        // check vertical winners
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrixBoard[i][j] == matrixBoard[i + 1][j] && matrixBoard[i + 2][j] == matrixBoard[i + 1][j] && matrixBoard[i][j] == 'x') {
                    vertXWin++;
                }
                else if (matrixBoard[i][j] == matrixBoard[i + 1][j] && matrixBoard[i + 2][j] == matrixBoard[i + 1][j] && matrixBoard[i][j] == 'o') {
                    vertOWin++;
                }
            }
        }
        // check diagonal winners from left diagonal
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                if (matrixBoard[i][j] == matrixBoard[i + 1][j + 1] && matrixBoard[i + 2][j + 2] == matrixBoard[i + 1][j + 1] && matrixBoard[i][j] == 'x') {
                    diagXWin++;
                }
                if (matrixBoard[i][j] == matrixBoard[i + 1][j + 1] && matrixBoard[i + 2][j + 2] == matrixBoard[i + 1][j + 1] && matrixBoard[i][j] == 'o') {
                    diagOWin++;
                }
            }
        }
        //check diagonal winners from right diagonal
        for (int i = 0; i < 1; i++) {
            for (int j = 2; j > 1; j--) {
                if (matrixBoard[i][j] == matrixBoard[i + 1][j - 1] && matrixBoard[i + 1][j - 1] == matrixBoard[i + 2][j - 2] && matrixBoard[i][j] == 'x') {
                    diagXWin++;
                }
                if (matrixBoard[i][j] == matrixBoard[i + 1][j - 1] && matrixBoard[i + 1][j - 1] == matrixBoard[i + 2][j - 2] && matrixBoard[i][j] == 'o') {
                    diagOWin++;
                }
            }
        }
        //check for unreachable state
        if ((horizXWin == 1 && horizOWin == 1) || (horizOWin == 1 && vertXWin == 1) || (vertOWin == 1 && vertXWin == 1)) {
            return Evaluation.UnreachableState;
        }
        // check for a win
        if (horizXWin == 1 || vertXWin == 1 || diagXWin == 1) {
            return Evaluation.Xwins;
        }
        if (horizOWin == 1 || vertOWin == 1 || diagOWin == 1) {
            return Evaluation.Owins;
        }
        return Evaluation.NoWinner;
    }
}
