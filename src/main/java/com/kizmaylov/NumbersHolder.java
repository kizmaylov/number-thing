package com.kizmaylov;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumbersHolder {

    private int minNumber;
    private int maxNumber;

    private BigDecimal sumOfNumbers = BigDecimal.ZERO;
    private int numbersCount;


    void consumeNewNumber(int number) {
        if (numbersCount == 0) {
            minNumber = number;
            maxNumber = number;
        }

        sumOfNumbers = sumOfNumbers.add(new BigDecimal(number));
        numbersCount++;

        if (number < minNumber) {
            minNumber = number;
        }
        if (number > maxNumber) {
            maxNumber = number;
        }
    }

    int getMaxNumber() {
        return maxNumber;
    }

    int getMinNumber() {
        return minNumber;
    }

    BigDecimal getAverage() {
        if (numbersCount == 0) {
            return BigDecimal.ZERO;
        }

        int divisionScale = 2;
        return sumOfNumbers.divide(new BigDecimal(numbersCount), divisionScale, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }
}
