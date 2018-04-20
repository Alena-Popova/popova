package popova.itmo_lesson.pattern_observer.patern_use_generics;

public interface Observer<T extends Event> {
    /**
     * регистрируется на какой-либо эвент
     * @param event
     */
    public void registred(T... event);

    /**
     * обновляет данные если изменился какой-нибудь евент,на которые он подписан
     * @param event
     */
    public void update(T event);
}
