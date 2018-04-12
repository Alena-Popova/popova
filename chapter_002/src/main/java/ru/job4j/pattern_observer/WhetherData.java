package popova.itmo_lesson.pattern_observer;

import java.util.ArrayList;

/**
 * Это мессенджер ,рассылающий данные,которые он изменил
 */

public class WhetherData extends Observable {

    private float temperature;
    private float pressure;
    private float humidity;


    public void measurementChanged() {
        setChanges();
        notifyObserver(); //оповещатель подписчиков из супер класса Observable
    }

    /**
     * Вызывается этот метод, чтобы потом передать управление measurementChanged(),
     * тот в своб очередь передаст правление notifyObserver() - оповещателю подписчиков.
     * @param pressure
     * @param temperature
     * @param humidity
     */
    public void setMeasurements(float pressure, float temperature, float humidity) {
            this.temperature = temperature;
            this.pressure = pressure;
            this.humidity = humidity;
            measurementChanged();
    }

    public float getTemperature(){
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }
}
