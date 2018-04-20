package popova.itmo_lesson.pattern_observer.patern_use_generics;

/**
 * пользователь для такого эвента не существует
 */
public class ObserverOfTheEventDoesNotExist extends RuntimeException{
    public ObserverOfTheEventDoesNotExist(String oe) {
        super(oe);
    }
}
