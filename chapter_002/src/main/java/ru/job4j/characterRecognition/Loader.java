package popova.characterRecognition;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ярлыки представляют собой целые числа от 0 до 9,
 * а изображения представляют собой значения пикселей строки /
 * столбца от 0 до 255, чтобы указать интенсивность пикселей.
 * Это параллельные массивы, где метка [i] указывает метку для изображений [i].
 */

public class Loader {
    private final String trainImages = "D:\\java-a-to-z\\libMNIST\\train-images-idx3-ubyte\\train-images.idx3-ubyte";
    private final String trainLabels = "D:\\java-a-to-z\\libMNIST\\train-labels-idx1-ubyte\\train-labels.idx1-ubyte";
    static String testFile = "D:\\java-a-to-z\\libMNIST\\t10k-images-idx3-ubyte\\t10k-images.idx3-ubyte";
    static String testLabel = "D:\\java-a-to-z\\libMNIST\\t10k-labels-idx1-ubyte\\t10k-labels.idx1-ubyte";
    private List<DataJPG> mnist = new ArrayList<>();

    /**
     * c этого метода все начинается. считывает байты картинок в ArrayList<Integer[]>
     * @param trainImages
     * @return возвращает лист с байтами картинок
     * @throws IOException что то тоже про файл
     * @throws FileExceprion не тот файл
     */
    public ArrayList<Integer[]>  getColorsMatrix(String trainImages) throws IOException, FileExceprion {
        ByteBuffer bb = loadFile(trainImages);
        checkExceprion(2051, bb.getInt());
        int numberItems  = bb.getInt();
        int numberRows = bb.getInt();
        int numberColumns = bb.getInt();

        ArrayList<Integer[]> images = new ArrayList<>();

        for (int i = 0; i < numberItems; i++)
            images.add(readImage(numberRows, numberColumns, bb));
        return images;
    }

    private static Integer[] readImage(int numRows, int numCols, ByteBuffer bb) {
        Integer[] image = new Integer[numRows * numCols];
        for (int index = 0; index < numRows * numCols; index++)
            image[index] = bb.get() & 0xFF;
        return image;
    }

    /**
     * считывает значащие лейблы к картинкам
     * @param trainLabels название файла
     * @return возвращает массив соответственно значащих лейблов к картинкам
     * @throws IOException
     */
    public int[] getLabel(String trainLabels) throws IOException {

        ByteBuffer bb = loadFile(trainLabels);
        checkExceprion(2049, bb.getInt());
        int numLabels = bb.getInt();
        int[] digits = new int[numLabels];

        for (int i = 0; i < numLabels; ++i)
            digits[i] = bb.getInt();
        return  digits;
    }

    public void checkExceprion(int exeption, int value) {
        if (exeption != value) {
            switch (exeption) {
                case 2049:
                    throw new FileExceprion("This is not a label file.");
                case 2051:
                    throw new FileExceprion("This is not an image file.");
                default:
                    throw new FileExceprion("Unknown exception");
            }
        }
    }


    public static ByteBuffer loadFile(String fileName) {
        try {
            RandomAccessFile f = new RandomAccessFile(fileName, "r");
            FileChannel chan = f.getChannel();
            long fileSize = chan.size();
            ByteBuffer bb = ByteBuffer.allocate((int) fileSize);
            chan.read(bb);
            bb.flip();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            for (int i = 0; i < fileSize; i++)
                baos.write(bb.get());
            chan.close();
            f.close();
            return ByteBuffer.wrap(baos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<DataJPG>  getMap() throws IOException, FileExceprion{
        List<Integer[]> color = getColorsMatrix(trainImages);
        int[] label = getLabel(trainLabels);
        if(color.size() != label.length) {
            throw new FileExceprion("Считано неверно");
        } else {
            for(int i = 0; i < label.length; i++) {
                DataJPG dataJPG = new DataJPG(label[i], color.get(i));
                this.mnist.add(dataJPG);
            }
        }
        return this.mnist;
    }

}
