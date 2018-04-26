package popova.characterRecognition.implement;

import popova.characterRecognition.architecture.DataJPG;
import popova.characterRecognition.architecture.MinimumStrategy;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  int count - количество гонщиков
    theThreads[] - массив потоков
    Thread thisThread - основной поток (поток, который управляет другими потоками)
    boolean inApplet = true;
    int numberOfTheradAtStart - в конце программы при помощи этой переменной
    определяем, все ли потоки прекратили существование
    CheckingAccuracy checkingAccuracy - инициализирует класс проверки точности, который проверяет
    по 1000 чисел в заданном диапазоне с  метки taskIndex в chechTestImages(taskIndex);
 */
public class Recognition extends ModelBehavior implements Runnable {
    private AtomicInteger atomicIteration = new AtomicInteger();
    private AtomicInteger atomicError= new AtomicInteger();

    public Recognition(List<DataJPG> mnist, List<DataJPG> test, AtomicInteger atomicIteration, int task, AtomicInteger atomicError) {
        super(mnist, test, atomicIteration, task, atomicError);
        this.atomicIteration = atomicIteration;
        this.atomicError = atomicError;
    }


    @Override
    public void run(){
        MinimumStrategy minimumStrategy = new MinimumStrategy(this.getMnist());
        for (int i = this.getTask()*2500; i < this.getTask()*2500 + 2500; i++) {
            this.atomicIteration.incrementAndGet();
            DataJPG newData = this.getTests().get(i);
            if(newData.getLable() != minimumStrategy.mostOftenIncomingClass(newData)) {
                atomicError.incrementAndGet();
            }
            getPercentageCompletion( this.atomicIteration.get());
            if(this.atomicIteration.get() == 9999) {
                getInfo(atomicError.get());
            }
        }
    }
}
