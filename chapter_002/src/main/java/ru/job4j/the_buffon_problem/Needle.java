package popova.itmo_lesson.the_buffon_problem;

import java.security.SecureRandom;

public class Needle {
    private double lenght;
    private double[] couplePoint = new double[2];

    public Needle(double lenght) {
        this.lenght = lenght;
    }

    public double getLenght() {
        return this.lenght;
    }

    public void setFirstPoint(double point) {
        this.couplePoint[0] = point;
    }

    public void setSecondPoint(double point) {
        this.couplePoint[1] = point;
    }

    public double getFirstPoint() {
        return this.couplePoint[0];
    }

    public double getSecondPoint() {
        return this.couplePoint[1];
    }

}
