package popova.chessboard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Figure> figureList = new ArrayList<>(32);
    private int indexWorkFigure;

    public void add(Figure figure) throws  OccupiedWayException{
        if(!containsOtherOnSame(figure))
            figureList.add(figure);
    }


    public  boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
            Cell[] allWay = figureList.get(this.figureList.indexOf(containsFigureOnCell(source))).way(source, dest);
                for (Cell step : allWay) {
                    if(!containsOtherOnSame(step)) return false;
                }
             return true;
    }




    /**
     * Нельзя добавить фигуру, если в нашем списке на этом месте уже стоит другая
     * @param figure фигура, которую добавляют
     * @return ( true or false) стоит там другая фигура или нет
     */
    public boolean containsOtherOnSame(Figure figure) {
        for (Figure f : figureList ) {
            if(f.position.equals(figure.position)){
                throw new OccupiedWayException(" На пути уже стоит другая фигура ");
            }
        }
        return false;
    }

    /**
     * Перегрузка
     * Нельзя добавить фигуру, если в нашем списке на этом месте уже стоит другая
     * @param cell ячейка, в которой стоит фигура, которую добавляют
     * @return ( true or false) стоит там другая фигура или нет
     */
    public boolean containsOtherOnSame(Cell cell) {
        for (Figure f : figureList ) {
            if(f.position.equals(cell)){
                throw new OccupiedWayException(" На пути уже стоит другая фигура ");
            }
        }
        return true;
    }

    /**
     * Проверяет есть ли фигура в переданной ячейке
     * @param offer
     * @return true or false
     */
    public Figure containsFigureOnCell(Cell offer) throws FigureNotFoundException {
        for (Figure f : figureList ) {
            if(f.position.equals(offer)){
                return f;
            }
        }
        throw new FigureNotFoundException(" В ячейке нет фигуры ");
    }

    public void showAllFigure() {
        for (Figure f : figureList) {
            System.out.println(String.format("Figure: %s, coordinates %d , %d", f.getClass(), f.position.getX(), f.position.getY()));
        }
    }

    public void rearrange(Figure f, Cell cell) {
        if(move(f.position,cell)) {
            this.figureList.set(this.figureList.indexOf(f), f.copyC(cell)) ;
        }
    }
}
