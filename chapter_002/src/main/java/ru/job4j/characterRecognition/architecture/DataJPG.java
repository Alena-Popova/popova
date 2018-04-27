package popova.characterRecognition.architecture;

import java.util.Arrays;
import java.util.Objects;

public class DataJPG {
    private int lable;
    private int[] linearVector;

    /**
     * В конструкторе записывается значение, которое принадлежит картинке
     * и леаниризированная матрица (вектор)
     * @param lable - число с картинки
     * @param linearVector - вектор
     */
    public DataJPG(int lable, int[] linearVector) {
        this.lable = lable;
        this.linearVector = linearVector;
    }

    public int getLable() {
        return this.lable;
    }

    public int[] getLinearVector() {
        return this.linearVector;
    }

    /**
     * Вычисляет длины вектора
     * @return длена вектора
     */
    public double getLenght() {
        double result = 0;
        int[] coord = getLinearVector();
        for (int coordinate = 0; coordinate < getLinearVector().length - 1 ; coordinate++) {
            result += Math.pow(coord[coordinate] - coord[coordinate + 1], 2) + 1;
        }
        return Math.sqrt(result);
    }

    /**
     * Вычисляет интеграл, описанный ветктором - площадь под ним
     * @return вес веткора
     */
    public double getWeight() {
        double result = 0;
        int[] coord = getLinearVector();
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {

            result += coord[coordinate];
        }
        return result;
    }

    /**
     * вычисляте расстояние от вектора до вектора искомого обьекта  - DataJPG dataJPG
     * @param dataJPG - обьект, который надо распознать
     * @return расстояние от вектора до вектора ( всегдаполодительно )
     */
    public double getDifference(DataJPG dataJPG) {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(this.getLinearVector()[coordinate] - dataJPG.getLinearVector()[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    /**
     * Получаем скалярное произведение векторов
     * @param dataJPG
     * @return
     */
    public double getScalar(DataJPG dataJPG) {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += this.getLinearVector()[coordinate] * dataJPG.getLinearVector()[coordinate];
        }

        return result;
    }

    /**
     * Получить модуль вектора
     * @return
     */
    public double getModule() {
        double result = 0;
        for (int coordinate = 0; coordinate < getLinearVector().length; coordinate++) {
            result += Math.pow(this.getLinearVector()[coordinate], 2);
        }
        return Math.sqrt(result);
    }

    public double getCos(DataJPG dataJPG) {
        double result = this.getScalar(dataJPG)/(this.getModule() * dataJPG.getModule());
        return Math.acos(result);
    }

    /**
     * переопределение equals для операций сравнения обьектов типа DataJPG
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o && Arrays.equals(this.linearVector, ((DataJPG)o).getLinearVector())) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataJPG dataJPG = (DataJPG) o;
        return Objects.equals(lable, dataJPG.lable) &&
                Arrays.equals(linearVector, dataJPG.linearVector);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(lable);
        result = 31 * result + Arrays.hashCode(linearVector);
        return result;
    }

    /**
     * Выводит число, которым индетенфицированна картинка в библиотеке MNIST
     * @return - лейбл
     */
    @Override
    public String toString() {
        return "DataJPG { "
                + " lable="
                + lable
                + '}';
    }
}
