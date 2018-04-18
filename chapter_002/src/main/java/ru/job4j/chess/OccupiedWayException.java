package popova.chessboard;

public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String owe) {
        super(owe);
    }
}
