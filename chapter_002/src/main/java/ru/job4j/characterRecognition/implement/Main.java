package popova.characterRecognition.implement;

import popova.characterRecognition.architecture.DataJPG;
import popova.characterRecognition.architecture.Loader;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String argv[]) throws IOException {

        Loader loader = new Loader();
        List<DataJPG> mnist = loader.getMNIST();
        loader.getTestsImages();
        List<DataJPG> tests = loader.getTest();
        AtomicInteger atomicIterarion = new AtomicInteger();
        AtomicInteger atomicError = new AtomicInteger();
        for(int i = 0;i < 4;i++) {
            new Thread(new RecognitionByCorner(mnist, tests, atomicIterarion, i, atomicError)).start();
            // new Thread(new Recognition(mnist, tests, atomicIterarion, i, atomicError)).start();
        }
    }
}
