package main;

import activationfunctions.*;
import core.*;
import inputs.and.ANDInputSamples;
import inputs.and.And;
import inputs.mnist.MNISTInputSamples;
import inputs.mnist.MNISTOutput;
import inputs.mnist.Mnist;
import network.Perceptron;

public class Main {

    public static void main(String[] args) throws Exception {

//        Mnist mnist = new Mnist();
//        MNISTInputSamples mnistInputSamples = new MNISTInputSamples(mnist.getAllMnistData());
//        mnistInputSamples.getSample(0);
//        System.out.println(mnistInputSamples.getInput().getLayer().getNeurons().get(153).getOutput());


        And and = new And();
        ANDInputSamples andInputSamples = new ANDInputSamples(and.getAllANDData());
        NeuralNetwork perceptron = new Perceptron();


    }
}
