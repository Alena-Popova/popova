package popova.chessboard;

import java.util.LinkedList;
import java.util.List;

public class Bishop extends Figure  {

    public Bishop(Cell cell){
        super(cell);
    }

    /**
     * У ладьи существует два типа джижения :
     * когда она двигается по ВЕРТИКАЛИ, то координата по x сохраняется,
     * по у  имеет границы вверх: 8 - source.getY() и вниз: source.getY() - 1,
     * по ГОРИЗОНТАЛИ соответсвено, y не менятеся, x - по аналогии.
     * то есть dest координаты не должны выходить за массив доски
     * @param source
     * @param dest
     * @return
     * @throws ImposibleMoveException
     */
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int index = 0;
        if(dest.getY() <= 8 && dest.getX() == source.getX()) {
            Cell[] result = new Cell[Math.abs(dest.getY()-source.getY())];
            for (int stepY = source.getY(); stepY != dest.getY() ; ) {
                stepY = dest.getY() > source.getY() ? ++stepY :  --stepY;
                result[index++] = new Cell(dest.getX(), stepY);
            }
            return result;
        } else if (dest.getX() <= 8 && dest.getY() == source.getY()) {
            Cell[] result = new Cell[Math.abs(dest.getX()-source.getX())];
            for (int stepX = source.getX(); stepX != dest.getX() ; ) {
                stepX = dest.getX() > source.getX() ? ++stepX :  --stepX;
                result[index++] = new Cell(stepX, source.getY());
            }
            return result;
        }
        else {
            throw  new ImposibleMoveException("Bishop: ");
        }
    }

    public Figure copyC(Cell dest) {
        return new Bishop(dest);
    }

}
