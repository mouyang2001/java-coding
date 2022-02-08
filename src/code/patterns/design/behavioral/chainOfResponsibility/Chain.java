package code.patterns.design.behavioral.chainOfResponsibility;

/**
 * is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request,
 * each handler decides either to process the request or to pass it to the next handler in the chain.
 *
 * Pros: control the order of checks, SRP decouple classes that invoke operations and those that perform it
 * Open/Close principle introduce new handlers without breaking existing code ie add another chain anywhere.
 *
 * Cons: some requests may end up unhandled if it passes all the way down without someone picking it up.
 * So to solve this always add a final chain that absolutely must process it.
 */
public interface Chain {
    public void setNextChain(Chain nextChain);

    public void calculate(Numbers request);
}
