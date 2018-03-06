package ru.job4j.max;

/**
 * Class for calculate max value from twos numbers.
 *@author Popova Alena
 *@version 1.0
 *@since 1.0
 */
public class Max {

    /**
     *Method for calculate .
     *@param firstValue and secondValue are numders for compare
     *@result max value
     */
    public int max(int firstValue, int secondValue) {
        return firstValue > secondValue ? firstValue : secondValue;
    }

    public int max(int firstValue, int secondValue, int therdValue) {
        int temp = this.max(firstValue,secondValue);
        return this.max(temp,therdValue);
    }
}
