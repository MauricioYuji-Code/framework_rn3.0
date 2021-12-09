package activationfunctions;

import interfac.ActivationFunction;

class Step implements ActivationFunction {
    @Override
    public double calculate(double value) {
        if (value >= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public double derivate(double value) {
        return 0;
    }
}