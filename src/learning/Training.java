package learning;

import core.NeuralNetwork;

public class Training {


    // Fixos no treinamento (Melhorar)
    private String typeOfLearning = "Supervisioned";
    private String learningStrategies = "Backpropagation";
    private NeuralNetwork neuralNetwork;


    public Training(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        neuralNetwork.randomizeWeight();
    }

    //Fazer Feedfoward

    public void feedfoward() {

    }


    //Fazer o backpropagation



    /*
     * Getters e Setters
     * */

    public String getTypeOfLearning() {
        return typeOfLearning;
    }

    public void setTypeOfLearning(String typeOfLearning) {
        this.typeOfLearning = typeOfLearning;
    }

    public String getLearningStrategies() {
        return learningStrategies;
    }

    public void setLearningStrategies(String learningStrategies) {
        this.learningStrategies = learningStrategies;
    }
}
