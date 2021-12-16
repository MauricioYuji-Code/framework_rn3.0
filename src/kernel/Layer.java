package kernel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import activationfunctions.Sigmoid;
import interfaces.ActivationFunction;

public class Layer implements Serializable, Cloneable {

    //TODO Pensar numa sintaxe de nomes para ids de layres para construção automática pela Rede Neural
    //TODO Modificar os construtores, para permitir customização destas ids
    //TODO Criar método de busca utilizando as IDs na rede neural para layer, da layer para neurônio e da Rede Neural para neurônio

    /**
     * Coleção de neurônios nesta camada
     */
    protected ArrayList<Neuron> neurons;

//    private ActivationFunction activationFunction;

    /**
     * Cria uma instância de camada vazia
     */
    public Layer() {
        this.neurons = new ArrayList<Neuron>();
    }

    /**
     * Cria uma instância de camada vazia para um número especificado de neurônios
     *
     * @param neuronsCount o número de neurônios nesta camada
     */
    public Layer(int neuronsCount) {
        this.neurons = new ArrayList<Neuron>();
        populateLayer(neuronsCount, new Sigmoid());
    }

    public Layer(int qtdNeurons, ActivationFunction activationFunction) {
        this.neurons = new ArrayList<Neuron>();
        populateLayer(qtdNeurons, activationFunction);
    }

    /**
     * Limpa as outConnections
     */
    public void clearAllConnections() {
        for (Neuron n : neurons) {
            n.clearConnections();
        }
    }

    /**
     * Randomiza os pesos
     */
    public void randomizeLayerWeights() {
        for (int i = 0; i < this.getNeuronsCount(); i++) {
            this.getNeurons().get(i).radomizeOutputWeight();
        }
    }


    /**
     * Popular a camada com a função de ativação
     */
    public void populateLayer(int neuronsCount, ActivationFunction activationFunction) {
        for (int n = 1; n <= neuronsCount; n++)
            neurons.add(new Neuron(activationFunction));
    }

    /**
     * Adicionar neuronio
     *
     * @param neuron a ser adicionado
     */
    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }

    /**
     * Adicionar neuronio na posicao especifica
     *
     * @param neuron a ser adicionado
     * @param index  posicao
     */
    public void addNeuron(int index, Neuron neuron) {
        neurons.add(index, neuron);
    }

    /**
     * Substituir neuronio
     *
     * @param index  substitui no indice
     * @param neuron substituto
     */
    public void setNeuron(int index, Neuron neuron) {
        neurons.set(index, neuron);
    }

    /**
     * remover neuronio da camada
     *
     * @param neuron neuronio a ser removido
     */
    public void removeNeuron(Neuron neuron) {
        int index = indexOf(neuron);
        neurons.remove(index);
    }

    /**
     * remover todos os neuronios
     */

    public void removeAllNeurons() {
        neurons.clear();
    }

    /**
     * Retornar a posicao do neuronio
     *
     * @param neuron neuron object
     * @return index posicao especificada
     */
    public int indexOf(Neuron neuron) {
        return neurons.indexOf(neuron);
    }

    public boolean isEmpty() {
        return neurons.isEmpty();
    }

    /**
     * Checar integridade da camada
     */
    public boolean checkNeuronsActivation() {
        for (int i = 0; i < this.getNeuronsCount(); i++) {
            if (getActivationFunction(i).equals(getActivationFunction()))
                return true;
        }
        return false;
    }

/******Getters e Setters*****/

    /**
     * Returns numero de neuronios na camada
     *
     * @return number of neurons in this layer
     */
    public int getNeuronsCount() {
        return neurons.size();
    }


    /**
     * Retorna lista de neuronios da camada
     */

    public final List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neurons);
    }

    /**
     * Retorna neuronio especifico
     *
     * @param index indice do neuronio
     */
    public Neuron getNeuronAt(int index) {
        return neurons.get(index);
    }

    public ActivationFunction getActivationFunction() {
        //TODO Ideal é verificar se todos os neurônios estão com a mesma activationFunction antes de retorná-la
        return getActivationFunction(0);
    }

    public ActivationFunction getActivationFunction(int pos) {
        if (pos >= 0 && pos < neurons.size()) {
            return neurons.get(pos).getActivationFunction();
        }
        return null;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        for (Neuron n : neurons) {
            n.setActivateValue(activationFunction);
        }
    }

    public void propagate() {
        for (Neuron n : neurons) {
            n.propagate();
        }

    }
}
