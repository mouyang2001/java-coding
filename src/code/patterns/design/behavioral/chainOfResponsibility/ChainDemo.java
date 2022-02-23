package code.patterns.design.behavioral.chainOfResponsibility;

public class ChainDemo {
    public static void main(String[] args) {
        Chain operation1 = new AddNumbers();
        Chain operation2 = new SubtractNumbers();
        Chain operation3 = new MultiplyNumbers();
        Chain operation4 = new DivideNumbers();

        operation1.setNextChain(operation2);
        operation2.setNextChain(operation3);
        operation3.setNextChain(operation4);

        Numbers request = new Numbers(4, 2, "div");
        // Because "div" is not operation1 it will pass it down the chain until one of the operation chains can process it.
        operation1.calculate(request);
    }
}
