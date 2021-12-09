package activationfunctions;

import interfac.ActivationFunction;

public class Sigmoid implements ActivationFunction {
    @Override
    public double calculate(double value) {
        return 1 / (1 + Math.exp(-value));
    }

    @Override
    public double derivate(double value) {
        return value * (1 - value);
    }
}
