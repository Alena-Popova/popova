package popova.itmo_lesson.pattern_observer.patern_use_generics;

public class Forecast<T extends Event> implements Observer {
    private SubjectMessenger subjectMessenger;

    /**
     * это наш подписчик. Он регистрируется в мессенджере subjectMessenger
     * @param subjectMessenger
     */
    public Forecast(SubjectMessenger subjectMessenger) {
        this.subjectMessenger = subjectMessenger;
    }

    /**
     * регистрирует евенты себе
     * @param event
     */
    @Override
    public void registred(Event... event) {
        for (Event e : event) {
            subjectMessenger.registerObserver(e,this);
        }
    }

    /**
     * обновляется
     * @param e
     */
    public void update(Event e) {
        e.display();
    }
}
