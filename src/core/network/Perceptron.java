package core.network;

import activationfunctions.Step;
import core.NeuralNetwork;
import assistant.structure.Output;

public class Perceptron extends NeuralNetwork {

    @Override
    public void attachOutput(Output output) throws Exception {
        if (this.output == null) {
            this.output = output;
            output.getLayer().setActivationFunction(new Step());
            addLayer(output.getLayer());
            connect(input.getLayer(), output.getLayer());
        } else {
            throw new Exception("Ops! Já temos a camada input na rede");
        }
    }
}
