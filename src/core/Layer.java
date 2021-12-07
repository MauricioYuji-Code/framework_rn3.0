package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Layer implements Serializable, Cloneable {

    /**
     * Coleção de neurônios nesta camada
     */
    protected List<Neuron> neurons;

    /**
     * Cria uma instância de camada vazia
     */
    public Layer() {
        neurons = new ArrayList<>();
    }

    /**
     * Cria uma instância de camada vazia para um número especificado de neurônios
     *
     * @param neuronsCount o número de neurônios nesta camada
     */
    public Layer(int neuronsCount) {
        neurons = new ArrayList<>(neuronsCount);
        for (int n = 1 ; n <= neuronsCount ; n++){
            Neuron neuron = new Neuron();
            neurons.add(neuron);
        }
    }


    public final List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neurons);
    }

    /**
     * Retornar a posicao do neuronio
     *
     * @param neuron neuron object
     * @return index posicao especificada
     */
//    public int indexOf(Neuron neuron) {
//        return neurons.indexOf(neuron);
//    }

    /**
     * Returns numero de neuronios na camada
     *
     * @return number of neurons in this layer
     */
    public int getNeuronsCount() {
        return neurons.size();
    }

    //Ta vazio?
    public boolean isEmpty() {
        return neurons.isEmpty();
    }

}
