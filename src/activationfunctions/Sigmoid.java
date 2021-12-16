package activationfunctions;

import interfaces.ActivationFunction;

public class Sigmoid implements ActivationFunction {
    @Override
    public double calculate(double value) {
        return 1 / (1 + Math.exp(-value));
    }

    @Override
    public double derivate(double value) {
        return value * (1 - value);
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
