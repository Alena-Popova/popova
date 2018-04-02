package popova.tracker;

public class StubInput implements Input {
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }


    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(""));
        boolean exist = false;
        for (int i : range) {
            if (i == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }

    }
}
