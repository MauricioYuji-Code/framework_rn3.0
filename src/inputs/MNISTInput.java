package inputs;

import core.Layer;
import inputs.mnist.Mnist;
import inputs.mnist.MnistData;
import interfac.Input;

import java.io.IOException;
import java.util.ArrayList;

public class MNISTInput extends Layer implements Input {

    private int min = 0;
    private int max = 255;
    private int[] data;
    private MnistData[] mnistData;
    private Layer firstLayer;

    public MNISTInput() {
        firstLayer = new Layer(784);
    }

    public MNISTInput(String filePathTrain, String filePathLabel) throws IOException {
        mnistData = new Mnist().readData(filePathTrain, filePathLabel);
    }

    @Override
    public double[] getInput(ArrayList<Number> in, double max, double min) {
        double[] result = new double[in.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = in.get(i).doubleValue() / (double) (max - min);
//            System.out.println(result[i]);
        }
        return result;
    }

    public MnistData[] getMnistData() {
        return mnistData;
    }
}
