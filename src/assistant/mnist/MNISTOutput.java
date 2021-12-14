package assistant.mnist;

import core.Layer;
import assistant.structure.Output;

import java.util.Arrays;

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
