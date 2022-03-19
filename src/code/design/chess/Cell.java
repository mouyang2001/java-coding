package code.design.chess;

public class Cell {
    private Piece piece;
    private int x;
    private int y;

    public Cell (int x, int y, Piece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece newPiece) {
        piece = newPiece;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
