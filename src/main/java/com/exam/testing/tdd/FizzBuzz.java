package com.exam.testing.tdd;

public class FizzBuzz {

    // Please check  commits

    public String convert(int number) {

        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }

        if (number % 5 == 0) {
            return "Buzz";
        }

        if (number % 3 == 0) {
            return "Fizz";
        }

        return String.valueOf(number);
    }

}
