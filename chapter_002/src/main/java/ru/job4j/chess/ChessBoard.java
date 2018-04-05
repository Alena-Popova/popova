package popova.chessboard;

public class ChessBoard extends Board {
    public static void main(String[] args) {
        ChessBoard chessTable = new ChessBoard();
        chessTable.add(new King(new Cell(1,1)));
        chessTable.add(new Bishop(new Cell(1,1)));
        chessTable.showAllFigure();
    }
}
