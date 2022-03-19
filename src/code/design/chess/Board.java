package code.design.chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> grid;

    public Board() {
        for (int r = 0; r < 8; r++) {

            List<Cell> row = new ArrayList<>();
            for (int c = 0; c < 8; c++) {
                row.add(new Cell(r, c, null));
            }

            grid.add(row);
        }
    }
}
