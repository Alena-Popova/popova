package popova.chessboard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;


public class BoardExceptionTest {
    Board chessTable = new Board();
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void loadMem() {
        chessTable.add(new King(new Cell(1,1)));
        chessTable.add(new Bishop(new Cell(1,2)));
    }

    @Test
    public void addExceprionTest() throws OccupiedWayException {
        exception.expect(OccupiedWayException.class);
        exception.expectMessage("На пути уже стоит фигура");
        chessTable.add(new Bishop(new Cell(1,1)));
    }

    @Test
    public void moveExceptionTestNoFigureInTheCell() throws FigureNotFoundException{
        exception.expect(FigureNotFoundException.class);
        exception.expectMessage("В ячейке нет фигуры");
        chessTable.move(new Cell(3,4), new Cell(4,5));
    }

    @Test
    public void moveExceptionTestImposibleWayForFigure() throws ImposibleMoveException{
        exception.expect(ImposibleMoveException.class);
        exception.expectMessage("Фигура не может двигаться по такому пути.");
        chessTable.move(new Cell(1,1), new Cell(4,5));

    }

    @Test
    public void moveExceptionTestSomeElseFigureStayOnWay() throws OccupiedWayException{
        exception.expect(OccupiedWayException.class);
        exception.expectMessage("Вы хотите поставить фигуру в занятую ячейку");
        chessTable.move(new Cell(1,1), new Cell(1,2));
    }

}