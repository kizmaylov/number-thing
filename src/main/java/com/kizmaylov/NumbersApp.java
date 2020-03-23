package com.kizmaylov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumbersApp {

    private static final int MIN_ACCEPTABLE_NUMBER = 0;
    private static final int MAX_ACCEPTABLE_NUMBER = 1_000_000;

    private static final NumbersHolder numbersHolder = new NumbersHolder();


    public static void main(String[] args) {

        String welcomeMessage = String.format("Please, give me the number or command.\n" +
                        "Number should be decimal and in [%d, %d] range.\n" +
                        "Command should be either 'min' or 'max' or 'avg' or 'quit'",
                MIN_ACCEPTABLE_NUMBER, MAX_ACCEPTABLE_NUMBER);

        System.out.println(welcomeMessage);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Enter your input: ");
                String input = br.readLine();

                String output;
                switch (input) {
                    case "quit":
                        return;
                    case "min":
                        output = String.valueOf(numbersHolder.getMinNumber());
                        break;
                    case "max":
                        output = String.valueOf(numbersHolder.getMaxNumber());
                        break;
                    case "avg":
                        output = numbersHolder.getAverage().toPlainString();
                        break;
                    default:
                        try {
                            int newNumber = Integer.parseInt(input);
                            if (newNumber < MIN_ACCEPTABLE_NUMBER) {
                                output = "Number is too low";
                            } else if (newNumber > MAX_ACCEPTABLE_NUMBER) {
                                output = "Number is too high";
                            } else {
                                numbersHolder.consumeNewNumber(newNumber);
                                output = "number accepted";
                            }
                        } catch (NumberFormatException e) {
                            output = "Wrong number or command";
                        }
                }

                System.out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
