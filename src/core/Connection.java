package core;

import java.io.Serializable;

public class Connection implements Serializable {

    protected Neuron fromNeuron;
    protected Neuron toNeuron;
    protected double weightValue;

    public Connection() {

    }

    public Connection(Neuron fromNeuron, Neuron toNeuron, double weightValue) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weightValue = weightValue;
    }

    public Connection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
    }

    public Connection(double weightValue) {
        this.weightValue = weightValue;
    }

    public void propagate() {
        toNeuron.addValue(fromNeuron.getActivateValue() * weightValue);
    }

    /******Getters e Setters*****/

    public double getInput() {
        return fromNeuron.getOutput();
    }

    public final Neuron getFromNeuron() {
        return fromNeuron;
    }

    public final Neuron getToNeuron() {
        return toNeuron;
    }

    /**
     * Define um valor de peso
     */
    public final void setWeightValue(double value) {
        this.weightValue = value;
    }

    /**
     * Retorna o valor do peso
     */
    public final double getWeightValue() {
        return this.weightValue;
    }


}
