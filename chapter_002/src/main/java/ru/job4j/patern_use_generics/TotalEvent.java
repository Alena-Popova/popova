package popova.itmo_lesson.pattern_observer.patern_use_generics;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * нужен для примера расширения класса эвент
 */
public class TotalEvent extends Event {

    /**
     * у нас новое хранилище для событий
     */
    private Map<String, String> word = new HashMap<>();

    public TotalEvent(String nameEvent, SubjectMessenger subjectMessenger) {
        super(nameEvent, subjectMessenger);
    }


    public Map<String, String> getWord() {
        return this.word;
    }

    public void addData(String nameData, String value) {
        if(!word.containsValue(nameData) || word.get(nameData) != value) {
            word.put(nameData, value);
            this.getSubjectMessenger().notifyObserver(this);
        }
    }

    /**
     * тут учли все нововведенные данные
     */
    @Override
    public void display() {
        Date date = new Date();
        System.out.println("\nОбновление за : " + date.toString());

        for (Map.Entry<String, Integer> entry : this.getData().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        for (Map.Entry<String, String> entry : word.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
