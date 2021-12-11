package test;

import java.util.ArrayList;

public class InputSamples {

    private ArrayList<ArrayList<Double>> samples;
    private int index;
    private Input input;
    private double min;
    private double max;


    public InputSamples(ArrayList<ArrayList<Double>> samples) {
        this.samples = samples;
        input = new Input();
    }

    public ArrayList<Double> nextSample() {
        if (index < samples.size())
            return samples.get(index++);
        return null;
    }

    public boolean next() {
        if (samples.get(samples.size() - 1) == null)
            return false;
        return true;
    }

    public double findMin() {
        for (ArrayList<Double> arr : samples) {
            for (double n : arr) {
                if (n < min)
                    min = n;
            }
        }
        return min;
    }

    public double findMax() {
        for (ArrayList<Double> arr : samples) {
            for (double n : arr) {
                if (n > max)
                    max = n;
            }
        }
        return max;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

}
