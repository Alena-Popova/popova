package popova.itmo_lesson.pattern_observer;

/**
 * Добавляет подписчиков и оповещает их
 */
public interface TheMessenger {

    public void registerObserver(String eventType, Subscriber listener);
    public void removeObserver(String eventType, Subscriber listener);
    public void notifyObserver(String eventType);
}
