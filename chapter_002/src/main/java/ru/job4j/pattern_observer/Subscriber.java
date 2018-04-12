package popova.itmo_lesson.pattern_observer;

/**
 * Интерфейс подписчиков(слушателей), они апдейтят все данные
 */
public interface Subscriber {
    String event = "";

    default public String getEvent(){
        return this.event;
    }
    public void update(String args,Subscriber observer);
}
