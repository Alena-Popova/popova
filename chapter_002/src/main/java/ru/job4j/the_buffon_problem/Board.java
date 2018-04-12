package popova.itmo_lesson.the_buffon_problem;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private double r;
    private double borders;
    List<Needle> needles = new ArrayList<>();

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

    public void throwNeedles(int numberNeebles, double length) {
        if (this.getR() <= length) {
            throw new NeedleLengthException("Длина иглы больше расстояния сежду полосами!");
        } else {
            for (int step = 0; step < numberNeebles; step++) {
                needles.add(new Needle(length));
                double cosinus = -1.0 + Math.random()*2.0;
                double sinus = Math.sqrt(1 - Math.pow(cosinus,2));
                double yOne = Math.random()*this.getBorders();
                double ySec = yOne + sinus * length;
                needles.get(step).setFirstPoint(yOne);
                needles.get(step).setSecondPoint(ySec);
            }
        }
    }

}
