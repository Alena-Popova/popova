package popova.chessboard;

public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String ime) {
        super(ime);
    }
}

