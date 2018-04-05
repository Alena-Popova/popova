package popova.chessboard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;


public class BoardExceptionTest {
    Board chessTable = new Board();

    @Before
    public void loadMem() {
        chessTable.add(new King(new Cell(1,1)));
        chessTable.add(new Bishop(new Cell(1,2)));
    }

    @Test
    public void addExceprionTest() throws OccupiedWayException {
        try {
            chessTable.add(new Bishop(new Cell(1,1)));
        } catch (OccupiedWayException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void moveExceptionTestNoFigureInTheCell() throws FigureNotFoundException{
        try {
            chessTable.move(new Cell(3,4), new Cell(4,5));
        } catch (FigureNotFoundException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void moveExceptionTestImposibleWayForFigure() throws ImposibleMoveException{
        try {
            chessTable.move(new Cell(1,1), new Cell(4,5));
        } catch (ImposibleMoveException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void moveExceptionTestSomeElseFigureStayOnWay() throws OccupiedWayException{
        try {
            chessTable.move(new Cell(1,1), new Cell(1,2));
        } catch (OccupiedWayException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

}