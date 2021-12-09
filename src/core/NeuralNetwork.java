package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NeuralNetwork implements Serializable {

    private ArrayList<Layer> layers;

    private String label;

    public NeuralNetwork() {
        this.layers = new ArrayList<>();
    }

    /**
     * Adicionar calamda
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

    public void setInputValues(double... input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

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
