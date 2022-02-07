package code.patterns.design.structural.adapter;

/**
 * Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
 *
 * Pros: SRP allows you separate data conversion from business logic. Open/Close introduce new adapters without breaking
 * existing, main client code.
 *
 * Cons: Increases complexity of code.
 *
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
