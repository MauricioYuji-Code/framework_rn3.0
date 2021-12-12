package structure;

import java.util.ArrayList;

public class InputSamples {

    private ArrayList<ArrayList<Double>> samples;
    private int index = 0;
    private Input input;
    private double min;
    private double max;


    public InputSamples(ArrayList<ArrayList<Double>> samples) {
        this.samples = samples;
        input = new Input(samples.get(0));
    }

    public InputSamples(ArrayList<ArrayList<Double>> samples, boolean flag) {
        this.samples = samples;
        input = new Input(samples.get(0), flag);
    }

    //Deixar void?
//    public ArrayList<Double> nextSample() {
//        if (index < samples.size())
//            return samples.get(index++);
//        return null;
//    }

    public void nextSample() {
        if (index < samples.size())
            input = new Input(samples.get(index++));
//            input.setValues(samples.get(index++));
    }

    //Deixar void?
//    public ArrayList<Double> getSample(int i) {
//        if (!samples.get(i).isEmpty())
//            return samples.get(i);
//        return null;
//    }

    public void getSample(int i) {
        if (!samples.get(i).isEmpty())
            input = new Input(samples.get(i));
//            input.setValues(samples.get(i));
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

    /**
     * Gettes e Setters
     **/
    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public ArrayList<ArrayList<Double>> getSamples() {
        return samples;
    }

    public void setSamples(ArrayList<ArrayList<Double>> samples) {
        this.samples = samples;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

}
