package code.advent2021.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day4Part1 {

    private static final int BOARD_SIZE = 5;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int minimumMovesToWin = Integer.MAX_VALUE;
        List<List<Integer>> minimumWinBoard = new ArrayList<>();

        List<Integer> bingoNumbers = new ArrayList<>();
        List<List<List<Integer>>> boards = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();

        try {
            // Extract first line bingo numbers.
            line = reader.readLine();
            String[] bingoNumbersRaw = line.split(",");
            for (String value : bingoNumbersRaw) bingoNumbers.add(Integer.valueOf(value));

            // Extract bingo board rows from data.
            while((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] rowNumbersRaw = line.trim().split("\\s+");

                    List<Integer> row = new ArrayList<>();
                    for (int c = 0; c < BOARD_SIZE; c++) {
                        row.add(Integer.valueOf(rowNumbersRaw[c]));
                    }

                    rows.add(row);
                }
            }

            // Divide rows into boards.
            List<List<Integer>> board = new ArrayList<>();
            int counter = 0;
            for (List<Integer> row : rows) {
                board.add(row);
                counter++;

                if (counter == BOARD_SIZE) {
                    boards.add(board);
                    board = new ArrayList<>();
                    counter = 0;
                }
            }

            // Find number of moves to win.
            for (List<List<Integer>> currentBoard : boards) {

                boolean[][] bingoBoard = new boolean[5][5];

                for (int bingoNumber : bingoNumbers) {

                    for (int r = 0; r < BOARD_SIZE; r++) {
                        for (int c = 0; c < BOARD_SIZE; c++) {
                            if (currentBoard.get(r).get(c) == bingoNumber) {
                                bingoBoard[r][c] = true;
                                // TODO: here.
                            }
                        }
                    }

                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkWin(boolean[][] bingoBoard) {
        for (int r = 0; r < BOARD_SIZE; r++) {
            if (bingoBoard[r][0] && bingoBoard[r][1] && bingoBoard[r][2] && bingoBoard[r][3] && bingoBoard[r][4]) {
                return true;
            }
        }
        for (int c = 0; c < BOARD_SIZE; c++) {
            if (bingoBoard[c][0] && bingoBoard[c][1] && bingoBoard[c][2] && bingoBoard[c][3] && bingoBoard[c][4]) {
                return true;
            }
        }

        return false;
    }

}
