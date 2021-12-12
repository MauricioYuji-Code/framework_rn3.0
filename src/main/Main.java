package main;

import core.*;
import inputs.and.ANDInputSamples;
import inputs.and.And;
import inputs.mnist.MNISTInputSamples;
import inputs.mnist.MNISTOutput;
import inputs.mnist.Mnist;
import network.Perceptron;

public class Main {

    public static void main(String[] args) throws Exception {
        NeuralNetwork perceptron = new Perceptron();
        And and = new And();
        ANDInputSamples andInputSamples = new ANDInputSamples(and.getAllANDData());
        andInputSamples.getSample(0);
        System.out.println(andInputSamples.getInput().getLayer().getNeurons().get(0).getOutput());
        perceptron.attachInput(andInputSamples.getInput());
    }
}
