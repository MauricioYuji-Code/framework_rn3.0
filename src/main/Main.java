package main;

import core.*;
import inputs.*;
import inputs.mnist.Mnist;

public class Main {

    public static void main(String[] args) throws Exception {

//        Mnist mnistData = new Mnist();
//        MNISTInputSamples mnistInputSamples = new MNISTInputSamples(mnistData.getAllMnistData());
        //Automátização da normalização e distribuição camada -> neuronios (Neural Network)
//        mnistInputSamples.nextSample();
//        for (int i = 0; i < mnistInputSamples.getInput().getValues().size(); i++) {
//            System.out.print(mnistInputSamples.getInput().getLayer().getNeurons().get(i).getOutput());
//            if (i % 28 == 0) {
//                System.out.println();
//            }
//        }
        //Nome do arquivo
        //Tamanho dos blocos de dados que serão classificados por sample

        NeuralNetwork nn = new NeuralNetwork();
        Neuron neuron1 = new Neuron();
        Neuron neuron2 = new Neuron();
        Neuron neuron3 = new Neuron();
        Neuron neuron4 = new Neuron();
        Layer layer1 = new Layer();
        Layer layer2 = new Layer();
        layer1.addNeuron(neuron1);
        layer1.addNeuron(neuron2);
        layer2.addNeuron(neuron3);
        layer2.addNeuron(neuron4);
//        nn.addLayer(layer1);
        nn.addLayer(0, layer1);
        nn.addLayer(1, layer2);

//        mnistInputSamples.nextSample();
//        mnistInputSamples.getSample(5);
//        nn.attachInput(mnistInputSamples.getInput());
//        System.out.println(nn.showInfo(true));


    }
}
