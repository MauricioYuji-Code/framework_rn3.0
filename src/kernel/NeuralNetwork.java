package kernel;

import learning.Training;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe de base para redes neurais artificiais
 *
 * @see NeuralNetwork
 */
public class NeuralNetwork implements Serializable {

    /**
     * Coleção de camadas
     */
    protected ArrayList<Layer> layers;

    /**
     * Coleção de amostras
     */
    protected ArrayList<ArrayList<Double>> samples;

    /**
     * Rótulo
     */
    protected String label;

    /**
     * Objeto para a camada de entrada
     */
    protected Input input;

    /**
     * Objeto para a camada de saída
     */
    protected Output output;

    /**
     * Cria uma instância da rede neural vazia e criando a lista de camadas
     */
    public NeuralNetwork() {
        this.layers = new ArrayList<>();
    }

    /**
     * propagação dos valores
     */
    public boolean propagate() {
        if (layers.isEmpty() || output == null || input == null)
            return false;
        for (Layer l : layers) {
            l.propagate();
        }
        return true;
    }

    /**
     * Adicionar camada
     *
     * @param layer camada adicionada
     */
    public void addLayer(Layer layer) {
        if (layers.size() == 0) {
            layers.add(layer);
        } else {
            addLayer(layers.size() - 1, layer);
        }
    }

    /**
     * Adiciona camada em um indice especifico
     *
     * @param index indice
     * @param layer camada adicionada
     */
    public boolean addLayer(int index, Layer layer) {
        if (layer.getNeuronsCount() == 0 || index == 0) {
//            System.out.println("Camada está sem neurônios ou o indíce está na posição zero");
            return false;
        } else {
            if (index == layers.size() - 1)
                connect(layers.get(index - 1), layer);
//            layers.add(index, layer);
            if (index < layers.size() - 1) {
                layers.get(index - 1).clearAllConnections();
                connect(layers.get(index - 1), layer);
                connect(layer, layers.get(index + 1));
            }
        }
        layers.add(index, layer);
        return true;
    }

    /**
     * Remover camada
     *
     * @param layer camada removida
     */
    public void removeLayer(Layer layer) {
        layers.remove(layer);
    }

    /**
     * Remove camada no indice especifico
     *
     * @param index indice
     */
    public boolean removeLayerAt(int index) {
        //Todo verificar quando tiver input
        //Todo verificar quando tiver output
        //Todo verificar quando tiver apenas uma layer
        if (layers.get(index).equals(null))
            return false;
        if (index == 0 || index == layers.size() - 1)
            return false;
        Layer l1 = layers.get(index - 1);
        Layer l2 = layers.get(index + 1);
        l1.clearAllConnections();
        connect(l1, l2);
        layers.get(index).removeAllNeurons();
        layers.remove(index);
        return true;
    }

    /**
     * Conetar duas camadas
     *
     * @param l1 camada 1
     * @param l2 camada 2
     */
    protected void connect(Layer l1, Layer l2) {
        for (int i = 0; i < l1.getNeuronsCount(); i++) {
            for (int j = 0; j < l2.getNeuronsCount(); j++) {
                l1.getNeurons().get(i).addOutputConnection(l2.getNeurons().get(j));
            }
        }
        this.randomizeWeight();
    }

    /**
     * Retorna posição da camada
     *
     * @param layer camada
     */
    public int indexOf(Layer layer) {
        return layers.indexOf(layer);
    }

    /**
     * Obter numero de camadas
     */
    public int getLayersCount() {
        return layers.size();
    }

    /**
     * Recebe a camada de entrada
     *
     * @param input Camada de entrada
     * @throws Exception já existe camada de entrada
     */
    public void attachInput(Input input) throws Exception {
        if (this.input == null) {
            this.input = input;
            connect(input.getLayer(), layers.get(0));
            layers.add(0, input.getLayer());
        } else {
            throw new Exception("Ops! Já temos a camada input na rede");
        }
    }

    /**
     * Recebe a camada de saída
     *
     * @param output Camada de saída
     * @throws Exception já existe camada de saída
     */
    public void attachOutput(Output output) throws Exception {
        if (this.output == null) {
            this.output = output;
            addLayer(layers.size(), output.getLayer());
        } else {
            throw new Exception("Ops! Já temos a camada input na rede");
        }
    }

    /**
     * Mostra informações da arquitetura da rede neural
     *
     * @param verbose verdadeiro se a informção for mais detalhada e falso se não
     * @return informações da arquitetura
     */
    public String showInfo(boolean verbose) {
        StringBuilder info = new StringBuilder();
        info.append("Neural Network Info: \n");
        info.append("Layers: " + layers.size() + "\n");
        info.append("Input attached: " + (input != null) + "\n");
        info.append("Output attached: " + (output != null) + "\n");
        for (int i = 0; i < layers.size(); i++) {
            info.append("Layer index: " + i + " Number of neurons: " + layers.get(i).getNeuronsCount() + "\n");
            info.append("Layer index: " + i + " Activation Function: " + layers.get(i).getActivationFunction().getName() + "\n");
            if (verbose) {
                for (int j = 0; j < layers.get(i).getNeuronsCount(); j++) {
                    Neuron n = layers.get(i).getNeurons().get(j);
                    info.append("Neuron: " + j + " Value:" + n.getValue() + "\n");
                    info.append("Neuron: " + j + " Activated Value:" + n.getActivateValue() + "\n");
                }
            }
        }
        return info.toString();
    }

    /**
     * Cria uma instancia de connection weight com valor aleatorio de peso dentro de [-1 .. 1]
     */
    public void randomizeWeight() {
        for (Layer l : layers) {
            l.randomizeLayerWeights();
        }
    }

    /**
     * Checar todos os ponteiros de neuronios e conexões
     *
     * @return verdeiro se toda a arquiterura estiver integro
     */
    public boolean checkIntegrity() {
        //Todo verificar integridade das conexões
        return true;
    }

    /**
     * Realização do treinamento
     */
    public void training() {
        Training training = new Training(this);
    }

    /**
     * Obter coleção de camadas
     *
     * @return camadas
     */
    public List<Layer> getLayers() {
        return Collections.unmodifiableList(this.layers);
    }

    /**
     * Rótulo da rede neural
     *
     * @return rótulo
     */
    public String getLabel() {
        return label;
    }

    /**
     * Definir rótulo
     *
     * @param label rótulo
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
