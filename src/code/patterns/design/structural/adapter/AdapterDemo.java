package code.patterns.design.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg roundPeg = new RoundPeg(5);
        if (hole.fits(roundPeg)) System.out.println("Round peg r5 fits round hole r5");

        SquarePeg squarePeg = new SquarePeg(2);
        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);
        // The reason why squarePegAdapter is allowed. Because it's an aggregate / extension of round peg.
        if (hole.fits(squarePegAdapter)) System.out.println("Square peg w2 fits round hole r5");
    }
}
