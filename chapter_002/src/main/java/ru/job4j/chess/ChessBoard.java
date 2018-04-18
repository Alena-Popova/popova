package popova.chessboard;

public class ChessBoard extends Board {
    public static void main(String[] args) {
        ChessBoard chessTable = new ChessBoard();
        King fF = new King(new Cell(1,1));
        Bishop fS = new Bishop(new Cell(5,5));
        chessTable.add(fF );
        chessTable.add(fS );
        chessTable.move(new Cell(1,1), new Cell(1,2));
        chessTable.move(new Cell(5,5), new Cell(2,5));
        chessTable.rearrange(fF , new Cell(1,2));
        chessTable.showAllFigure();
    }
}
