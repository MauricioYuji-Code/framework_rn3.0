package main;

import core.*;

import java.io.IOException;
import java.util.ArrayList;

import enu.*;
import inputs.MNISTInput;

public class Main {

    public static void main(String[] args) throws IOException {

        //Perceptron
        NeuralNetwork nn = new NeuralNetwork();
        Layer input = new Layer();
        Layer output = new Layer();
        Neuron neuron1 = new Neuron();
        Neuron neuron2 = new Neuron();
        Neuron neuron3 = new Neuron();

        //Arquitetura
        neuron3.addInputConnection(neuron1);
        neuron3.addInputConnection(neuron2);

        //Alocando neuronios na camada
        input.addNeuron(neuron1);
        input.addNeuron(neuron2);
        output.addNeuron(neuron3);


        //Alocando camadas na rede neural
        nn.addLayer(input);
        nn.addLayer(output);
        nn.randomizeWeight();


        MNISTInput mnistInput = new MNISTInput("data/train-images.idx3-ubyte", "data/train-labels.idx1-ubyte");
        mnistInput.getMnistData()[1].getSizeOfArray();
        ArrayList<Number> mnistData = new ArrayList<>();
        for (int i = 0; i < mnistInput.getMnistData()[1].getSizeOfArray(); i++) {
            mnistData.add(mnistInput.getMnistData()[1].getValueOfArray(i));
        }
        mnistInput.getInput(mnistData,255, 0);
    }
}
