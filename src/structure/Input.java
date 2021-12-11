package structure;

import core.Layer;

import java.util.ArrayList;

public class Input {

    public ArrayList<Double> values = new ArrayList<>();
    public Layer inputLayer;

    public Input(ArrayList<Double> values) {
        this.values = values;
    }

    public Input() {
    }

    public double[] getNormalizedInput(ArrayList<Number> in, double max, double min) {
        double[] result = new double[in.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (in.get(i).doubleValue() - min) / (double) (max - min);
        }
        return result;
    }

    public double[] getNormalizedInput() {
        double[] result = new double[values.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (values.get(i).doubleValue() - getMinValue()) / (double) (getMaxValue() - getMinValue());
        }
        return result;
    }

    public double[] getNormalizedInput(ArrayList<Double> values) {
        double[] result = new double[values.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = (values.get(i).doubleValue() - getMinValue()) / (double) (getMaxValue() - getMinValue());
        }
        return result;
    }

    //Todo fazer o metodo para converter o arr de double em layer normalizada
    //Se a layer estiver vazia a conversão cria novos neuronios passando valores normalizados, caso ao contrario modifica os valores ja criados na layer -> neuronios

    public void convertToLayer() {
        if (inputLayer.getNeuronsCount() != 0)
            this.inputLayer = new Layer(values.size());
        for (int i = 0; i < inputLayer.getNeuronsCount(); i++) {
            inputLayer.getNeurons().get(i).setOutput(getNormalizedInput()[i]);
        }
    }

    /**
     * Gettes e Setters
     **/

    public Double getMinValue() {
        Double minValue = Double.MAX_VALUE;
        for (Double value : values) {
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }

    public Double getMaxValue() {
        Double maxValue = Double.MIN_VALUE;
        for (Double value : values) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public Layer getLayer() {
        return inputLayer;
    }

    public void setLayer(Layer inputLayer) {
        this.inputLayer = inputLayer;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
    }
}
