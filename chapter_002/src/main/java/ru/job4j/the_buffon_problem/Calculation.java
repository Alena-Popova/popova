package popova.itmo_lesson.the_buffon_problem;

public class Calculation {
    private Board board;

    public Calculation(Board board) {
        this.board = board;
    }

    public int calculationAcrossRestrictLines() {
        int result  = 0;
        for (Needle needle : board.getNeedles()) {
            for (double lines = 0; lines < board.getBorders();) {
                lines += board.getR();
                 if( needle.getFirstPoint() <= lines && needle.getSecondPoint() >= lines) {
                     result++;
                 }
            }
        }
        return result;
    }

    public double calculationCoefPi() {
        return (2.0 * board.getNeedles().get(0).getLenght() / board.getR());
    }
}
