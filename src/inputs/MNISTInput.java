package inputs;

import core.Layer;
import test.Input;
import test.InputSamples;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MNISTInputSamples extends InputSamples {

    private int min = 0;
    private int max = 255;
    private int index;
    private int numberImages;
    private int rows;
    private int columns;
    private String filePath;


//    private double[] convert() {
//        return this.getNormalizedInput();
//    }
//
//    @Override
//    public void distribute() {
//        this.inputLayer = new Layer(rows * columns);
//        for (int i = 0; i < (rows * columns); i++) {
//            inputLayer.getNeurons().get(i).setOutput(convert()[i]);
//        }
//    }

    public void readData() throws IOException {
        int pos = 0;
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
        int magicNumber = dataInputStream.readInt();
        numberImages = dataInputStream.readInt();
        rows = dataInputStream.readInt();
        columns = dataInputStream.readInt();
        for (int j = pos; j < (rows * columns); j++) {
//            values.add((double) dataInputStream.readUnsignedByte());
//            System.out.print(values.get(j));
//            if (j % 28 == 0)
//                System.out.println();
        }
    }

}
