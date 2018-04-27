package popova.characterRecognition.implement;

import popova.characterRecognition.architecture.DataJPG;
import popova.characterRecognition.architecture.TheCornersStrategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RecognitionByCorner extends ModelBehavior implements Runnable {

    private AtomicInteger atomicIteration = new AtomicInteger();
    private AtomicInteger atomicError= new AtomicInteger();

    public RecognitionByCorner(List<DataJPG> mnist, List<DataJPG> test, AtomicInteger atomicIteration, int task, AtomicInteger atomicError) {
        super(mnist, test, atomicIteration, task, atomicError);
        this.atomicIteration = atomicIteration;
        this.atomicError = atomicError;
    }


    @Override
    public void run(){
        TheCornersStrategy theCornersStrategy = new TheCornersStrategy(this.getMnist());
        for (int i = this.getTask()*2500; i < this.getTask()*2500 + 2500; i++) {
            this.atomicIteration.incrementAndGet();
            DataJPG newData = this.getTests().get(i);
            if(newData.getLable() != theCornersStrategy.getMinNeighborbyCos(newData)) {
                atomicError.incrementAndGet();
            }

            getPercentageCompletion( this.atomicIteration.get());
            if(this.atomicIteration.get() == 9999) {
                getInfo(atomicError.get());
            }
        }
    }

}
