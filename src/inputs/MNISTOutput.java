package inputs;

import core.Layer;
import interfac.Output;

public class MNISTOutput extends Layer implements Output {

    private Layer lastLayer;

    public MNISTOutput(Layer lastLayer) {
        this.lastLayer = lastLayer;
    }

    public MNISTOutput() {
        this.lastLayer = new Layer(10);
    }

    @Override
    public Object getOuput() {
        return null;
    }
}
