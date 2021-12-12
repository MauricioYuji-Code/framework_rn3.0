package inputs.mnist;

import core.Layer;
import structure.Output;

public class MNISTOutput extends Output {

    private Layer outputLayerMnist;

    public MNISTOutput(Layer outputLayer) {
        super(outputLayer);
    }

    public MNISTOutput() {
        super(10);
    }

}
