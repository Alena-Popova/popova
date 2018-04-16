package popova.itmo_lesson.thread_lesson;

class UserThreadS extends Thread {

    public UserThreadS(String newName) {
        super(newName);
        start();
    }

    @Override
    public void run() {
        System.out.println("Stert" + this.getName());
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println("Run " + this.getName() + " count : " + i);
            }
        }catch (InterruptedException ie) {
            System.out.println(ie.getMessage() + "прервано");
        }

        System.out.println("Stop " + this.getName());
    }
}

public class ThreadSecond {
    public static void main(String[] args) {
        System.out.println("Запуск нового потока:");
        UserThreadS river = new UserThreadS(" # one");
        UserThreadS founderate = new UserThreadS(" # sec");
        UserThreadS ocean = new UserThreadS(" # thed");
        for (int i = 0; i < 20; i ++) {
            System.out.println(".");
            try {
                river.join();
                System.out.println("river присоединен");
                founderate.join();
                System.out.println("founderate присоединен");
                ocean.join();
                System.out.println("ocean присоединен");
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.out.println("Прерывание основного потока");
            }
        }

        System.out.println("Завершение основного потока");

    }
}
