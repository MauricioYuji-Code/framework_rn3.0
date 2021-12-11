package main;

import core.*;
import inputs.*;
import inputs.mnist.Mnist;

public class Main {

    public static void main(String[] args) throws Exception {

        Mnist mnistData = new Mnist();
        MNISTInputSamples mnistInputSamples = new MNISTInputSamples(mnistData.getAllMnistData());

//        System.out.println(mnistInputSamples.getSampleAtIndex(1).size());
        //Automátização da normalização e distribuição camada -> neuronios (Neural Network)
        mnistInputSamples.getInput().getNormalizedInput(mnistInputSamples.getSample(0));

        //Nome do arquivo
        //Tamanho dos blocos de dados que serão classificados por sample

        NeuralNetwork nn = new NeuralNetwork();
//        nn.attachInput(mnistInputSamples.getInput());
        System.out.println(nn.showInfo(true));


    }
}
