package network.mnist;

import kernel.Layer;
import kernel.Output;

public class MNISTOutput extends Output {


    public MNISTOutput(Layer outputLayer) {
        super(outputLayer);
    }

    @Override
    public void defineOuput() {
        for (int i = 0; i < 10; i++)
            outputs.add(Integer.valueOf(i));
    }

    @Override
    public Integer getExpectedValue() {
        return (Integer) super.getExpectedValue();
    }

    public MNISTOutput() {
        super(10);
    }

}
