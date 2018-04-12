package popova.itmo_lesson.pattern_observer;

public class ForecastDisplay implements Subscriber, DisplayElements {
    private float currentPreshure = 29.92f;
    private float lastPreshure;
    Observable observable;
    private String event = "Даление изменилось!";

    /**
     * Эта реализация апдейтит только давление, например
     * @param observable
     */
    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this.event,this);
    }

    public void update(String args,Subscriber subscriber){
        if (this.observable instanceof WhetherData) {
            WhetherData whetherData = (WhetherData) this.observable;
            this.lastPreshure = whetherData.getPressure();
            displayUpdate();
        }

    }

    public void displayUpdate(){
        System.out.println(String.format("\nОповещение! :"));
        System.out.println(String.format("Давление: %s", this.lastPreshure));
    }
}
