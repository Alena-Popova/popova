package popova.characterRecognition.implement;

import popova.characterRecognition.architecture.DataJPG;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ModelBehavior {
    private List<DataJPG> mnist;
    private List<DataJPG> tests;
    private AtomicInteger atomicIteration = new AtomicInteger();
    private AtomicInteger atomicError= new AtomicInteger();
    private int task;

    public ModelBehavior(List<DataJPG> mnist, List<DataJPG> test, AtomicInteger atomicIteration, int task, AtomicInteger atomicError) {
        this.mnist = mnist;
        this.tests = test;
        this.atomicIteration = atomicIteration;
        this.atomicError = atomicError;
        this.task = task;
    }

    public void getPercentageCompletion(int i) {
        System.out.print("\rЗаверщено: " + (i/100.0) + "%.");
    }

    public void getInfo(int info) {
        System.out.println("\nКоличество ошибок: " + info);
        System.out.println("Точность распознавания: " + (10000 - info)/100.0 + "%");
    }

    public List<DataJPG> getMnist() {
        return mnist;
    }

    public List<DataJPG> getTests() {
        return tests;
    }

    public AtomicInteger getAtomicIteration() {
        return atomicIteration;
    }

    public AtomicInteger getAtomicError() {
        return atomicError;
    }

    public int getTask() {
        return task;
    }
}
