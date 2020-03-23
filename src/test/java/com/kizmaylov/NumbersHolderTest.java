package com.kizmaylov;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class NumbersHolderTest {

    private NumbersHolder numbersHolder;

    @BeforeEach
    private void init() {
        numbersHolder = new NumbersHolder();
    }


    @Test
    public void emptyHolderTest() {
        Assertions.assertThat(numbersHolder.getMinNumber()).isEqualTo(0);
        Assertions.assertThat(numbersHolder.getMaxNumber()).isEqualTo(0);
        Assertions.assertThat(numbersHolder.getAverage()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void minMaxTest() {
        numbersHolder.consumeNewNumber(11);
        Assertions.assertThat(numbersHolder.getMinNumber()).isEqualTo(11);
        Assertions.assertThat(numbersHolder.getMaxNumber()).isEqualTo(11);

        numbersHolder.consumeNewNumber(5);
        Assertions.assertThat(numbersHolder.getMinNumber()).isEqualTo(5);
        Assertions.assertThat(numbersHolder.getMaxNumber()).isEqualTo(11);

        numbersHolder.consumeNewNumber(25);
        Assertions.assertThat(numbersHolder.getMinNumber()).isEqualTo(5);
        Assertions.assertThat(numbersHolder.getMaxNumber()).isEqualTo(25);

        numbersHolder.consumeNewNumber(0);
        Assertions.assertThat(numbersHolder.getMinNumber()).isEqualTo(0);
        Assertions.assertThat(numbersHolder.getMaxNumber()).isEqualTo(25);
    }

    @Test
    public void avgTest() {
        numbersHolder.consumeNewNumber(5);
        Assertions.assertThat(numbersHolder.getAverage()).isEqualTo(new BigDecimal(5));

        numbersHolder.consumeNewNumber(1);
        Assertions.assertThat(numbersHolder.getAverage()).isEqualTo(new BigDecimal(3));

        numbersHolder.consumeNewNumber(6);
        Assertions.assertThat(numbersHolder.getAverage()).isEqualTo(new BigDecimal(4));
    }
}
