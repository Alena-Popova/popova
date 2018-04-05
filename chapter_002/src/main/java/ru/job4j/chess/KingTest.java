package popova.chessboard;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KingTest {

    @Test
    public void wayRight() {
        King figureFing = new King(new Cell(1,1));
        Cell[] result = figureFing.way(new Cell(1,1), new Cell(2,2));
        assertThat(result[0].getX(), is(new Cell(2,2).getX()));
    }

    @Test
    public void copyCRight() {
        Figure figureFing = new King(new Cell(1,1)).copyC(new  Cell(2,2));
        Figure result = new King(new Cell(2,2));
        assertThat(result.position.getX(), is(figureFing.position.getX()));
    }
}