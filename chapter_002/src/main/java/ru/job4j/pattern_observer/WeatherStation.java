package popova.itmo_lesson.pattern_observer;

public class WeatherStation {

    public static void main(String[] args) {
        WhetherData whetherData = new WhetherData();

        CurrentCondition currentCondition = new CurrentCondition(whetherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(whetherData);
        whetherData.setMeasurements(200,1, 11);

    }
}
