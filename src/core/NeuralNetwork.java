package core;

import test.Input;
import test.Output;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NeuralNetwork implements Serializable {

    private ArrayList<Layer> layers;

    private ArrayList<ArrayList<Double>> samples;

    private String label;

    private Input input;

    private Output output;


    public NeuralNetwork() {
        this.layers = new ArrayList<>();
    }

    /**
     * Adicionar camada
     *
     * @param layer camada adicionada
     */
    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    /**
     * Adiciona camada em um indice especifico
     *
     * @param index indice
     * @param layer camada adicionada
     */
    public void addLayer(int index, Layer layer) {
        layers.add(index, layer);
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
    public void removeLayerAt(int index) {
        layers.remove(index);
    }

    /**
     * retorna posicao da camada
     *
     * @param layer camada
     */
    public int indexOf(Layer layer) {
        return layers.indexOf(layer);
    }

    /**
     * Retorna numero de camadas
     */
    public int getLayersCount() {
        return layers.size();
    }

    /**
     * recebe a camada de entrada
     */
    public void attachInput(Input input) throws Exception {
        if (this.input == null) {
            this.input = input;
            addLayer(0, input.getLayer());
        } else {
            throw new Exception("Ops! Já temos a camada input na rede");
        }
    }

    /**
     * recebe a camada de saída
     */
//    public void attachOutput(Output output) throws Exception {
//        if (this.output == null) {
//            this.output = output;
//            addLayer(0, output.getLayer());
//        } else {
//            throw new Exception("Ops! Já temos a camada input na rede");
//        }
//    }

    /**
     * Cria uma instancia de connection weight com valor aleatorio de peso dentro de [-1 .. 1]
     */
    //Todo Percorrer camadas, chegar até as suas conexões e randomizar seus pesos (Ainda a avaliar)
    public void randomizeWeight() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (Layer l : layers) {
            for (int i = 0; i < l.getNeuronsCount(); i++) {
//                System.out.println("Numero de neuronios: " + l.getNeuronsCount() + " na camada " + l.getLabel());
                for (int j = 0; j < l.getNeurons().get(i).getInputConnections().size(); j++) {
//                    System.out.println("Neuronio: " + l.getLabel() + " Numero de conexões: " + j);
                    l.neurons.get(i).getInputConnections().get(j).setWeightValue(tlr.nextDouble(-1, 1));
                }
            }
        }
    }

    /**
     * Checar todos os ponteiros de neuronios e conexões
     */
    //Todo verificar integridade das conexões
    public boolean checkIntegrity() {
        return true;
    }

    /******Getters e Setters*****/

    public List<Layer> getLayers() {
        return Collections.unmodifiableList(this.layers);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
