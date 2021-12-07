package core;

import Help.ActivationFunction;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NeuralNetwork implements Serializable {

    ArrayList<Layer> layers;

    public NeuralNetwork() {

    }

    /**
     * Cria uma instancia de connection weight com valor aleatorio de peso dentro de [-1 .. 1]
     */

    //Todo Percorrer camadas, chegar até as suas conexões e randomizar seus pesos
    public void randomizeWeight() {
        double value = Math.random() - 1d;
        for (Layer l : layers) {

        }

    }

    /**
     * Checar todos os ponteiros de neuronios e conexões
     */
    //Todo verificar integridade das conexões
    public boolean checkIntegrity() {
        return true;
    }

}
