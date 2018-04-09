package popova.chessboard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Figure> figureList = new ArrayList<>(32);
    private int indexWorkFigure;

    public void add(Figure figure) {
        try{
            if(!containsOtherOnSame(figure)) {
                figureList.add(figure);
            }
        }catch (OccupiedWayException owe){
            System.out.println(" На этом месте уже стоит фигура ");
        }
    }



    public  boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean result = false;
        int indexObjectWork;
        try {
            containsFigureOnCell(source);
            indexObjectWork = this.indexWorkFigure;
            int last = figureList.get(indexObjectWork).way(source, dest).length;
            Cell[] allWay = figureList.get(indexObjectWork).way(source, dest);
                for (Cell step : allWay) {
                    System.out.println(String.format("%s step: %d, %d",figureList.get(indexObjectWork).getClass().toString(), step.getX(),step.getY()));
                    containsOtherOnSame(step);
                }
             return true;
        } catch (FigureNotFoundException fnfe) {
            System.out.println(" В ячейке нет фигуры ");
        } catch (ImposibleMoveException ime) {
            System.out.println(" Фигура не может двигаться по такому пути ");
        } catch(OccupiedWayException owe){
            System.out.println(" На пути уже стоит фигура ");
        }
        return result;
    }




    /**
     * Нельзя добавить фигуру, если в нашем списке на этом месте уже стоит другая
     * @param figure фигура, которую добавляют
     * @return можно довабить или нет ( true or false)
     */
    public boolean containsOtherOnSame(Figure figure) {
        for (Figure f : figureList ) {
            if(f.position.getX() == figure.position.getX() && f.position.getY() == figure.position.getY()){
                throw new OccupiedWayException(" На пути уже стоит фигура ");
            }
        }
        return false;
    }

    /**
     * Перегрузка
     * Нельзя добавить фигуру, если в нашем списке на этом месте уже стоит другая
     * @param figure фигура, которую добавляют
     * @return можно довабить или нет ( true or false)
     */
    public boolean containsOtherOnSame(Cell figure) {
        for (Figure f : figureList ) {
            if(f.position.getX() == figure.getX() && f.position.getY() == figure.getY()){
                throw new OccupiedWayException(String.format(" Исключение в  %d, %d ", f.position.getX(), f.position.getY()));
            }
        }
        return true;
    }

    /**
     * Проверяет есть ли фигура в переданной ячейке
     * @param offer
     * @return true or false
     */
    public void containsFigureOnCell(Cell offer) throws FigureNotFoundException {
        for (Figure f : figureList ) {
            if(f.position.getX() == offer.getX() && f.position.getY() == offer.getY()){
                this.indexWorkFigure = figureList.indexOf(f);
                return;
            }
        }
        throw new FigureNotFoundException(" В ячейке нет фигуры ");
    }

    public void showAllFigure() {
        for (Figure f : figureList) {
            System.out.println(String.format("Figure: %s, coordinates %d , %d", f.getClass(),f.position.getX(), f.position.getY()));
        }
    }

    public void rearrange(Figure f, Cell cell) {
        this.indexWorkFigure = 0;
        containsFigureOnCell(f.position);
        if(move(f.position,cell)) {
            this.figureList.set(this.indexWorkFigure, f.copyC(cell)) ;
        }
    }
}