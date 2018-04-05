package popova.chessboard;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopTest {

    @Test
    public void wayIsRight() {
        Bishop  bishop = new Bishop(new Cell(5,5));
        Cell[] result = bishop.way(new Cell(5,5), new Cell(5,8));
        assertThat(result[0].getX(),is(new Cell(5,6).getX()));
    }

    @Test
    public void wayIsNotRight() throws ImposibleMoveException {
        Bishop  bishop = new Bishop(new Cell(5,5));
        try {
            bishop.way(new Cell(5,5), new Cell(5,-1));
        } catch (ImposibleMoveException ime) {
            Assert.assertNotEquals("", ime.getMessage());
        }
    }


    @Test
    public void copyC() {
        Bishop  bishop = new Bishop(new Cell(5,5));
        assertThat(bishop.copyC(new Cell(1,1)).position.getX(),is(new Cell(1,1).getX()));
    }
}