package popova.chessboard;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void wayIsRight() {
        Bishop  bishop = new Bishop(new Cell(5,5));
        Cell[] result = bishop.way(new Cell(5,5), new Cell(5,8));
        assertThat(true,is(result[0].equals(new Cell(5,6))));
    }

    @Test
    public void wayIsNotRight() throws ImposibleMoveException {
        exception.expect(ImposibleMoveException.class);
        exception.expectMessage("Выход за границу доски");

        Bishop  bishop = new Bishop(new Cell(5,5));
        bishop.way(new Cell(5,5), new Cell(5,-1));
    }


    @Test
    public void copyC() {
        Bishop  bishop = new Bishop(new Cell(5,5));
        assertThat(bishop.copyC(new Cell(1,1)).position.getX(),is(new Cell(1,1).getX()));
    }
}