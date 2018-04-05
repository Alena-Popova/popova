package popova.chessboard;

import java.util.Arrays;

public abstract class Figure {
    final Cell position;

    private int[] moveDirection = new int[4];

    public Figure(Cell position) {
        this.position = position;
    }


    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public abstract Figure copyC(Cell dest);



}
