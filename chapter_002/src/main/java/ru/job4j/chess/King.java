package popova.chessboard;

public class King extends Figure {

    public King(Cell cell){
        super(cell);
    }
    public  Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if(Math.abs(dest.getY()-source.getY()) <= 1 && Math.abs(dest.getX()-source.getX()) <= 1) {
            return new Cell[]{dest};
        }
        else {
            throw  new ImposibleMoveException("Фигура не может двигаться по такому пути.");
        }
    }

    public  Figure copyC(Cell dest) {
        return new King(dest);
    }
}
