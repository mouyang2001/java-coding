package code.design.chess;

public abstract class Piece {
    private boolean dead = false;
    private boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public boolean isBlack() {
        return !white;
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        dead = true;
    }

    public abstract boolean canMove(Board board, Cell start, Cell end);
}
