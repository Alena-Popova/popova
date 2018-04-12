package popova.itmo_lesson.the_buffon_problem;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс доски на которую кидаем иглы
 */
public class Board {
    /**
     * расстояние между прямыми на доске
     */
    private double r;
    /**
     * границы доски задаются как 5*this.r;
     */
    private double borders;
    /**
     * Список выкинутых на доску игл
     */
    List<Needle> needles = new ArrayList<>();

    /**
     * конструктор с парамером - расстояние между прямыми
     * @param r
     */
    public Board(double r) {
        this.r = r;
        this.borders = 5*this.r;
    }

    public double getR() {
        return this.r;
    }

    public double getBorders(){
        return this.borders;
    }

    public List<Needle> getNeedles() {
        return this.needles;
    }

    /**
     * Метод выбрасывающий иглы на доску.
     * устанавливает координаты игл y1 и y2 на доске.
     * сначала выкидывается yOne, потом путям рандомного выкидывания угла поворота
     * высчитывается ySec. Эти координаты записываются для каждой иглы в лист.
     * По итогу мы имеем лист, выкинытых на доску игл с рандомным поворотом List<Needle> needles
     * @param numberNeebles колличество игл
     * @param length длина игл
     */
    public void throwNeedles(int numberNeebles, double length) {
        if (this.getR() <= length) {
            throw new NeedleLengthException("Длина иглы больше расстояния сежду полосами!");
        } else {
            for (int step = 0; step < numberNeebles; step++) {
                needles.add(new Needle(length));
                Random r = new Random();
                double yOne = r.nextInt((int)this.getBorders());
                double ySec = yOne + Math.random()* length ;
                needles.get(step).setFirstPoint(yOne);
                needles.get(step).setSecondPoint(ySec);
            }
        }
    }

}
