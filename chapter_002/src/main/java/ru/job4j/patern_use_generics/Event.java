package popova.itmo_lesson.pattern_observer.patern_use_generics;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * событие евент
 * мы создаем его для слабой связи между рассыльщикм сообщений и подписчиками
 * нам нужно,чтобы эвент был таким классом, который может изменться как угодно и это не повлияет на
 * форму взаимодействия с подписчиками
 */
public class Event {

    /**
     * эвент должен обязательно принадлежать какому-то месенджеру
     */
    private SubjectMessenger subjectMessenger;
    /**
     * у евента должно быть имя
     */
    private String nameEvent;

    /**
     * и набр данных которые мы будем обновлять в дисплее public void display()
     * Для добавления другого типа данных -(<String, String> или другие  мы просто расширяем класс
     * евент и создаем там метод, который записывает данные в нужном формате.
     * однако,ничего в subjectMessenger для расширенного класса менять не нужно будет
     */
    private Map<String, Integer>  data = new HashMap<>();

    /**
     * в конструкторе обьявляем наш мессенджер и имя евента
     * @param nameEvent
     * @param subjectMessenger
     */
    public Event(String nameEvent, SubjectMessenger subjectMessenger) {
        this.subjectMessenger = subjectMessenger;
        this.nameEvent = nameEvent;
    }

    /**
     * если хочется узнать какому мессенджеру принадлежит евент
     * @return
     */
    public SubjectMessenger getSubjectMessenger() {
        return this.subjectMessenger;
    }

    /**
     * узнать имя евента
     * @return
     */
    public String getNameEvent() {
        return nameEvent;
    }

    /**
     * возвращает данные ,записанные в евенте
     * @return
     */
    public Map<String, Integer> getData() {
        return this.data;
    }

    /**
     * добавляет данные в евент и оповещает подписанных пользователей
     * @param nameData
     * @param value
     */
    public void addData(String nameData, Integer value) {
        if(!data.containsValue(nameData) || data.get(nameData) != value) {
            data.put(nameData, value);
            subjectMessenger.notifyObserver(this);
        }
    }

    /**
     * расширяя класс эвент , мы должны учесть отображение новых данных на дисплее как в TotalEvent
     */
    public void display() {
        Date date = new Date();
        System.out.println("\nОбновление за : " + date.toString());

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
