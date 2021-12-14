package assistant.structure;

import core.Layer;
import interfac.ActivationFunction;

import java.util.ArrayList;

public class Input {

    public ArrayList<Double> values = new ArrayList<>();
    public Layer inputLayer = new Layer();

    public Input(ArrayList<Double> values) {
        this.values = values;
        convertToLayer();
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
//            System.out.println(result[i]);
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

    //Com a normalização

    public void convertToLayer() {
        if (inputLayer.getNeuronsCount() == 0)
            this.inputLayer = new Layer(values.size());
        inputLayer.setActivationFunction(new ActivationFunction() {
            @Override
            public double calculate(double value) {
                return value;
            }

            @Override
            public double derivate(double value) {
                return value;
            }

            @Override
            public String getName() {
                return "None";
            }
        });
        double[] store = getNormalizedInput();
        for (int i = 0; i < inputLayer.getNeuronsCount(); i++) {
            inputLayer.getNeurons().get(i).setOutput(store[i]);
        }
    }

    //Sem a normalização

    private void convertSimpleToLayer() {
        if (inputLayer.getNeuronsCount() == 0)
            this.inputLayer = new Layer(values.size());
        for (int i = 0; i < inputLayer.getNeuronsCount(); i++) {
//            System.out.println(values.get(i));
            inputLayer.getNeurons().get(i).setOutput(values.get(i));
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
