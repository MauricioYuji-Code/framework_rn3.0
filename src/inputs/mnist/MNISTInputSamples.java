package inputs.mnist;

import structure.InputSamples;

import java.util.ArrayList;

public class MNISTInputSamples extends InputSamples {

    private int min = 0;
    private int max = 255;
    private int index;
//    private int numberImages;
//    private int rows;
//    private int columns;
//    private String filePath;

    public MNISTInputSamples(ArrayList<ArrayList<Double>> samples) {
        super(samples);
    }


}
