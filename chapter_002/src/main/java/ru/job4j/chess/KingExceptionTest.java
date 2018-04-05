package popova.chessboard;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KingExceptionTest {

    @Test(expected = ImposibleMoveException.class)
    public void testImposibleMoveException(){
        King figureFing = new King(new Cell(1,1));
        Cell[] result = figureFing.way(new Cell(1,1), new Cell(3,2));
    }

}