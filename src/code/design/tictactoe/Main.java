package code.design.tictactoe;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TTT game = new TTT();
        game.placePiece(1, 1);
        game.placePiece(0, 2);
        game.placePiece(1, 2);
        game.placePiece(2, 2);
    }

    public static class TTT {

        private final String[][] board = new String[3][3];

        private boolean crossTurn = false;

        public TTT() {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[r][c] = " ";
                }
            }
        }

        public void placePiece(int r, int c) {
            if (r < 0 || r >= 3 || c < 0 || c >= 3) {
                System.out.println("r or c out of bounds");
                return;
            }

            if (!board[r][c].equals(" ")) {
                System.out.println("Can't place piece");
                return;
            }

            if (crossTurn) board[r][c] = "x";
            else board[r][c] = "o";

            crossTurn = !crossTurn;

            printBoard();
            checkWinner();
        }

        public void printBoard() {
            System.out.println(Arrays.toString(board[0]));
            System.out.println(Arrays.toString(board[1]));
            System.out.println(Arrays.toString(board[2]));
        }

        public void checkWinner() {
            // Check straights.
            for (int i = 0; i < 3; i++) {
                String row = board[i][0] + board[i][1] + board[i][2];
                String col = board[0][i] + board[1][i] + board[2][i];

                if (row.equals("xxx") || col.equals("xxx")) {
                    System.out.println("x won!");
                }

                if (row.equals("ooo") || col.equals("ooo")) {
                    System.out.println("o won!");
                }
            }

            // Check diagonals.
            String diagonal1 = board[0][0] + board[1][1] + board[2][2];
            String diagonal2 = board[0][2] + board[1][1] + board[2][0];
            if (diagonal1.equals("xxx") || diagonal2.equals("xxx")) {
                System.out.println("x won!");
            }

            if (diagonal1.equals("ooo") || diagonal2.equals("ooo")) {
                System.out.println("o won!");
            }
        }
    }
}
