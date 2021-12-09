package core;

import interfac.ActivationFunction;
import activationfunctions.Sigmoid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Neuron implements Serializable, Cloneable {

    /**
     * Coleção de Connections de entrada do Neuron (conexões para este Neuron)
     */
    protected ArrayList<Connection> inputConnections;
    /**
     * Coleção de Connections de saída do Neuron (conexões deste para outro
     * Neuron)
     */
    protected ArrayList<Connection> outConnections;

    /**
     * Representa a entrada total para este neurônio recebida da função de entrada. (Somatória)
     */
    protected double value = 0;

    /**
     * Neuron output
     */
    protected double output = 0;

    /**
     * Neuron's label
     */
    private String label;

    protected ActivationFunction activationFunction;

    /**
     * Construtor neuron inicializando as listas de conections de entrada e de saida
     */
    public Neuron() {
        this.inputConnections = new ArrayList<Connection>();
        this.outConnections = new ArrayList<Connection>();
        this.activationFunction = new Sigmoid();
    }

    public Neuron(ActivationFunction activationFunction) {
        this.inputConnections = new ArrayList<Connection>();
        this.outConnections = new ArrayList<Connection>();
        this.activationFunction = activationFunction;
    }

    /**
     * Retorna verdadeiro se houver conexões de entrada para este neurônio, falso
     * por outro lado
     *
     * @return true se houver conexão de entrada, false caso contrário
     */

    public boolean hasInputConnections() {
        return (inputConnections.size() > 0);
    }

    public boolean hasOutputConnectionTo(Neuron toNeuron) {
        for (Connection connection : outConnections) {
            if (connection.getToNeuron() == toNeuron) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifique a conexão do neurônio
     *
     * @param neuron conexão do Neuron a ser verificada
     * @return true se houver conexão de entrada, false caso contrário
     */

    public boolean hasInputConnectionFrom(Neuron neuron) {
        for (Connection connection : inputConnections) {
            if (connection.getFromNeuron() == neuron) {
                return true;
            }
        }
        return false;
    }


    /**
     * Adiciona conexão de entrada de determinado neurônio
     *
     * @param fromNeuron neuron para conectar a partir do neuronio selecionado
     */

    public void addInputConnection(Neuron fromNeuron) {
        Connection connection = new Connection(fromNeuron, this);
        this.addInputConnection(connection);
    }

    /**
     * Adiciona a conexão de entrada especificada
     *
     * @param connection input connection para adicionar
     */

    public void addInputConnection(Connection connection) {
        this.inputConnections.add(connection);
        Neuron fromNeuron = connection.getFromNeuron();
        fromNeuron.addOutputConnection(connection);
    }


    /**
     * Adiciona a conexão de saída especificada
     *
     * @param connection adicionar Connection de saída
     */

    protected void addOutputConnection(Connection connection) {
        this.outConnections.add(connection);
    }

    /**
     * Sets this neuron output
     *
     * @param output value to set
     */
    public void setOutput(double output) {
        this.output = output;
    }

    /**
     * Returns conexões de entrada deste neuronio
     *
     * @return input connections of this neuron
     */
    public final List<Connection> getInputConnections() {
        return Collections.unmodifiableList(inputConnections);
    }

    /******Getters e Setters*****/

    public double getActivateValue() {
        return activationFunction.calculate(value);
    }

    /**
     * Define a entrada do neuronio, realizando a somatoria
     *
     * @param value valor de entrada para definir
     */
    public void addValue(double value) {
        this.value += value;
    }

    /**
     * Retorna a entrada
     *
     * @return input
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Retorna a saída do neurônio
     *
     * @return saída do neurônio
     */
    public double getOutput() {
        return this.output;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setActivateValue(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }
}

