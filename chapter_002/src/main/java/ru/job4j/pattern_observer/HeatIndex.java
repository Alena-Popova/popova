package popova.itmo_lesson.pattern_observer;

public class HeatIndex  implements DisplayElements{
    private float value;

    public HeatIndex(float value) {
        this.value = value;
        displayUpdate();
    }
    public void displayUpdate() {
        System.out.println(String.format("Оповещение ! Тепловой индекс: %s", this.value));
    }
}
