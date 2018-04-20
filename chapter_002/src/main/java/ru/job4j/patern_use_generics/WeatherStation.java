package popova.itmo_lesson.pattern_observer.patern_use_generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherStation<T extends Event> implements SubjectMessenger<T> {

    Map<T, List<Observer>> listeners = new HashMap<>();

    public void registerObserver(T event, Observer listener) {
        if (!listeners.containsValue(event)) {
            listeners.put(event,new ArrayList<Observer>());
            listeners.get(event).add(listener);
        } else {
            listeners.get(event).add(listener);
        }
    }

    public void removeObserver(T event, Observer listener) {
        if (listeners.containsValue(event)) {
            listeners.get(event).remove(listener);
        } else {
            throw new ObserverOfTheEventDoesNotExist("Данного наблюдателя для события не существует");
        }
    }

    public void notifyObserver(T event) {
        List<Observer> users = listeners.get(event);
        if (users != null) {
            for (Observer listener : users) {
                listener.update(event);
            }
        }
    }

}
