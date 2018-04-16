package popova.itmo_lesson.thread_lesson;

class UserThread implements Runnable {
    private String nameUserThread;

    public UserThread(String newName) {
        this.nameUserThread = newName;
    }

    @Override
    public void run() {
        System.out.println(this.nameUserThread + " - name Thread");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.println(this.nameUserThread + " - name Thread" + "counter :"  + i);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
            Thread.currentThread().interrupt();// корректная обработка пррывания такого типа
        }
        System.out.println("Завершение" + this.nameUserThread);
    }
}

public class LessonThreadOne {
    public static void main(String[] args) {
        System.out.println("Start");

        UserThread one = new UserThread("# one");
        Thread newThread = new Thread(one);
        newThread.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(170);
            } catch (InterruptedException ie) {
                System.out.println("Interrupter main Thread");
                System.out.println(ie.getMessage());
            }

        }
        System.out.println("Stop main thread");

    }
}
