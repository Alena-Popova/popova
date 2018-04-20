package popova.itmo_lesson.pattern_observer.patern_use_generics;

public interface SubjectMessenger <T extends Event> {
    /**
     * реализуя этот интерфейс - делает мессенджер
     * @param event
     * @param listener
     */
    public void registerObserver(T event, Observer listener);
    public void removeObserver(T event, Observer listener);
    public void notifyObserver(T event);
}
