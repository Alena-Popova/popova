package popova.strategypattern;

/**
 * Class Paint
 * @author HelenaPopova
 * @since 1.0
 */
public class Paint {
    private Shape form;

    public Paint(Shape form){
        this.form = form;
    }

    public void draw(){
        System.out.println(this.form.draw());
    }

    public static void main(String[] args) {
        Paint figure = new Paint(new Square());
        figure.draw();

        figure = new Paint(new Triangle());
        figure.draw();
    }
}
