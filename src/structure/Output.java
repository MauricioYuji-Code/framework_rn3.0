package structure;

import core.Layer;

import java.util.ArrayList;

public class Output {

    private Layer outputLayer;
    private ArrayList<Double> values = new ArrayList<>();

    public Output(int size) {
         this.outputLayer = new Layer(size);
    }

    public Output(Layer outputLayer) {
        this.outputLayer = outputLayer;
    }

    public Layer getLayer() {
        return outputLayer;
    }
}
