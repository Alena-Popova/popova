package popova.itmo_lesson.the_buffon_problem;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(4);
        /**
         * 100 опытов с выкидыванием 500 игл на доску
         */
        try {
            double result = 0;
            for(int i = 0; i < 100; i++) {
                int numberThrows = 500;
                //бросить иглы
                board.throwNeedles(numberThrows,3);
                // создать калькулятор для доски
                Calculation calculation = new Calculation(board);
                //посчитать колличество пересечений
                int numberAcross = calculation.calculationAcrossRestrictLines();
                //только после этого посчитать результат Pi  и сложить с предыдущим
                result += calculation.calculationCoefPi()/((double) numberAcross/(double)numberThrows);
            }
            //чтобы потом все это поделить на количество опытов и найти среднее
            System.out.println(result/100.0);
        } catch (NeedleLengthException nle) {
            System.out.println(nle.getMessage());
        }
    }
}
