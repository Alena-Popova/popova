package popova.itmo_lesson.pattern_observer;

public class CurrentCondition implements  DisplayElements, Subscriber{
    private float temperature;
    private float pressure;
    private float humidity;
    Observable observable;
    private String event = "Общее оповещение"; //наш новый эвент, на который подпишется

    /**
     *  регистрируем слушателя в его Observable observable
     * @param observable
     */
    public CurrentCondition(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this.event,this);
    }

    /**
     * Апдейтим
     * @param args
     * @param observable
     */
    public void update(String args,Subscriber observable) {
        if (this.observable instanceof WhetherData) {
            WhetherData whetherData = (WhetherData) this.observable;
            this.pressure = whetherData.getPressure();
            this.temperature = whetherData.getTemperature();
            this.humidity = whetherData.getHumidity();
            displayUpdate(); //вызываем интерейс вывода
        }
    }
    public void displayUpdate() {
        HeatIndex index = new HeatIndex(this.temperature);
        System.out.println(String.format("\nОповещение !: \nДавление: %s", this.pressure));
        System.out.println(String.format("Температура: %s", this.temperature));
        System.out.println(String.format("Влажность: %s", this.humidity));
    }
}
