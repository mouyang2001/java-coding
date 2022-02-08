package code.patterns.design.behavioral.chainOfResponsibility;

import java.util.Objects;

public class MultiplyNumbers implements Chain {
    private Chain nextInChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (Objects.equals(request.getCalculationWanted(), "mult")) {
            int ans = request.getNumber1() * request.getNumber2();
            System.out.println(request.getNumber1() + " x " + request.getNumber2() + " = " + ans);
        } else {
            nextInChain.calculate(request);
        }
    }
}
