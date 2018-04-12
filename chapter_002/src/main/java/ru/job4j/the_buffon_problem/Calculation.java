package popova.itmo_lesson.the_buffon_problem;

/**
 * высчитать формулу
 */
public class Calculation {
    private Board board;

    public Calculation(Board board) {
        this.board = board;
    }

    /**
     * Метод считает количетсво пересечений выкинутых игл с полосами на доске
     * @return количество пересечений
     */
    public int calculationAcrossRestrictLines() {
        int result  = 0;
        for (Needle needle : board.getNeedles()) {
            for (double lines = 0; lines <= board.getBorders();) {
                lines += board.getR();
                //если пересеклось с какой-то линией на доске:
                 if( needle.getFirstPoint() <= lines && needle.getSecondPoint() >= lines) {
                     result++;
                 }
            }
        }
        return result;
    }

    /**
     * считаеся коефециент при PI = koef * колличетсво игл / колличество пересечений
     * @return koef
     */
    public double calculationCoefPi() {
        return (2.0 * board.getNeedles().get(0).getLenght() / board.getR());
    }
}
