package popova.itmo_lesson.thread_lesson;

/**
 * Выводит название потоков поочереди
 */
class PrThread implements Runnable {
    int count;
    static String currentName;

    Thread thread;
    static boolean stop = false;

    public PrThread(String name) {
        thread = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    @Override
    public void run() {
        do {
            if(currentName.compareTo(thread.getName()) != 0) {
                currentName = thread.getName();
                System.out.println("Current name  " + currentName);
            }
        } while ( stop == false);
        stop = true;
    }
}

public class PriorityLesson {
    public static void main(String[] args) {

        PrThread high = new PrThread("High priority");
        PrThread low = new PrThread("Low priority");

        high.thread.setPriority(Thread.NORM_PRIORITY + 2);
        low.thread.setPriority(Thread.NORM_PRIORITY - 2);

        high.thread.start();
        low.thread.start();
        try {
            high.thread.join();
            low.thread.join();
            Thread.sleep(300);
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
        System.out.println("Счетчик потока high " + high.count);
        System.out.println("Счетчик потока low " + low.count);

    }
}
