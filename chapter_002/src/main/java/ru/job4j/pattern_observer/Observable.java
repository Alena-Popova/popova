package popova.itmo_lesson.pattern_observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация программы оповещения
 */
public class Observable implements TheMessenger {
    /**
     * тут список эвентов - в ключах, а список подписчиков в List<Subscriber>
     */
    Map<String, List<Subscriber>> listeners = new HashMap<>();

    private float temperature;
    private float pressure;
    private float humidity;
    private boolean flag;

    /**
     * можем добавить эвернты на сдаии создание мессенджера, когда еще даже нет подписчиков
     * @param operations
     */
    public Observable(String... operations) {
        for(String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * регистрируем пришедщего извне listener - а, в тот список,на который он хочет подписаться
     * @param eventType
     * @param listener
     */
    public void registerObserver(String eventType, Subscriber listener) {
        if(!listeners.containsKey(eventType)) {
            listeners.put(eventType, new ArrayList<>());
            listeners.get(eventType).add(listener);
        } else {
            listeners.get(eventType).add(listener);
        }
    }

    /**
     * Удаляем слушателя из потока оповещений
     * @param eventType
     * @param listener
     */
    public void removeObserver(String eventType, Subscriber listener) {
        if(listeners.containsKey(eventType)) {
            listeners.get(eventType).remove(listener);
        }
    }

    /**
     * Оповещения по входящей заявке eventType, на которую подписались слушатели
     * @param eventType
     */
    public void notifyObserver(String eventType) {
        List<Subscriber> users = listeners.get(eventType);
        for (Subscriber listener : users) {
            listener.update(eventType, listener);
        }
    }

    public void setMeasurements(float pressure, float temperature, float humidity) {
            this.temperature = temperature;
            this.pressure = pressure;
            this.humidity = humidity;
            notifyObserver();
            this.flag = false;
    }
    public void setChanges() {
        this.flag = true;
    }

    /**
     * оповещения по всем eventType
     */
    public void notifyObserver() {
        for (String event : listeners.keySet()) {
            notifyObserver(event);
        }
    }

}
