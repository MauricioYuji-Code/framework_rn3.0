package assistant.structure;

import core.Layer;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Output {

    protected Layer outputLayer;
    protected ArrayList<Object> outputs = new ArrayList<>();
    protected double max = 0;

    public Output(int size) {
        this.outputLayer = new Layer(size);
    }

    public Output(Layer outputLayer) {
        this.outputLayer = outputLayer;
    }

    public Layer getLayer() {
        return outputLayer;
    }

    public abstract void defineOuput();

    public Object getExpectedValue() {
        double n;
        int index = 0;
        for (int i = 0; i < outputLayer.getNeuronsCount(); i++) {
            n = outputLayer.getNeurons().get(i).getValue();
            if (n > max) {
                max = n;
                index = i;
            }
        }
        return outputs.get(index);
    }
//Todo realizar o retorno com mais de um elemento
//  public Object[] getExpectedValues() {}
}
