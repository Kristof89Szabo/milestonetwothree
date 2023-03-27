package com.exam.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    FizzBuzz fizzbuzz;

    @BeforeEach
    void init() {
        fizzbuzz = new FizzBuzz();
    }


    @Test
    void testThatConvertHandleNotSpecialNumber() {
        //Given
        String expected1 = "1";

        //When
        String actual1 = fizzbuzz.convert(1);
        //Then
        assertEquals(expected1, actual1);

    }

}