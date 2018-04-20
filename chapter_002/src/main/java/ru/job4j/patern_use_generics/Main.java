package popova.itmo_lesson.pattern_observer.patern_use_generics;

public class Main {

    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation(); // мессенджер рассылающий сообщения

        Event time = new Event("Time", ws);//какой-нибудь евент
        Event pressure =  new Event("Pressure",ws); // еще евент
        TotalEvent temperature = new TotalEvent("Температура в комнатах", ws);

        Forecast fr = new Forecast(ws); //наблюдатель
        fr.registred(pressure, temperature); //подписывается на эти обновления

        time.addData("Сегодня", 1);
        pressure.addData("Давление", 100);
        pressure.addData("Давление в воде", 200);
        temperature.addData("Температура в зале", 32);
        temperature.addData("Температура в спальне", 22);
        temperature.addData("Срeднeе отклонение", "нормальное");
    }
}
