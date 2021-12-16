package interfaces;

public interface ActivationFunction {
    public double calculate(double value);

    public double derivate(double value);

    public String getName();

}
