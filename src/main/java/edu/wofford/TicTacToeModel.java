package edu.wofford;

public class TicTacToeModel {

    public enum Mark {EMPTY, XMARK, OMARK}

    public enum Result {XWIN, OWIN, TIE, NONE}
    
    private Mark[][] board;
    private Mark currentPlayer;

    public TicTacToeModel() {
        board = new Mark[3][3];
        intializeBoard();
        currentPlayer = Mark.XMARK;
    }

    private void intializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
    }

    private void changePlayer() {
        if (currentPlayer == Mark.XMARK) {
            currentPlayer = Mark.OMARK;
        } else {
            currentPlayer = Mark.XMARK;
        }
    }

    private boolean isBoardFull() {
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Mark.EMPTY) {
                    full = false;
                    break;
                }
            }
        }
        return full;
    }

    public boolean setMarkAt(int row, int col) {
        if ((row >= 0 && row < 3) && (col >= 0 && col < 3) && getResult() == Result.NONE) {
            if (board[row][col] == Mark.EMPTY) {
                board[row][col] = currentPlayer;
                changePlayer();
                return true;
            }
        }
        return false;
    }

    public Mark getMarkAt(int row, int col) {
        if (board[row][col] == Mark.EMPTY) {
            return Mark.EMPTY;
        } else if (board[row][col] == Mark.OMARK) {
            return Mark.OMARK;
        } else return Mark.XMARK;
    }

    private boolean winningCondition(Mark currentPlayer) {
        return ((board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer) ||
                (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer) ||
                (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer) ||
                (board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[2][0] == currentPlayer && board[1][1] == currentPlayer && board[0][2] == currentPlayer));
    }

    public Result getResult() {
        if (winningCondition(Mark.XMARK)) {
            return Result.XWIN;
        } else if (winningCondition(Mark.OMARK)) {
            return Result.OWIN;
        } else if (isBoardFull()) {
            return Result.TIE;
        } else {
            return Result.NONE;
        }
    }

    private char changeTo(int i, int j){
                if (board[i][j] == Mark.EMPTY) {
                    return (' ');
                     }
                else if(board[i][j] == Mark.OMARK){
                    return ('O');
                }
                else {
                    return ('X');
                }
    }

    public String toString() {


        return (changeTo(0,0) +"|"+ changeTo(0,1) +"|"+ changeTo(0,2) + "\n"+
                "-----\n"+
                changeTo(1,0) +"|"+ changeTo(1,1) +"|"+ changeTo(1,2) + "\n"+
                "-----\n"+
                changeTo(2,0) +"|"+ changeTo(2,1) +"|"+ changeTo(2,2));
    }

}