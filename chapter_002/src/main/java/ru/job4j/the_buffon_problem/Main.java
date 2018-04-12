package popova.itmo_lesson.the_buffon_problem;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(10);
        try {
            double result = 0;
            for(int i = 0; i < 10; i++) {
                int numberThrows = 500;
                board.throwNeedles(numberThrows,6);
                Calculation calculation = new Calculation(board);
                int numberAcross = calculation.calculationAcrossRestrictLines();
                result += calculation.calculationCoefPi()/((double) numberAcross/(double)numberThrows);
            }
            System.out.println(result/10.0);
        } catch (NeedleLengthException nle) {
            System.out.println(nle.getMessage());
        }
    }
}
