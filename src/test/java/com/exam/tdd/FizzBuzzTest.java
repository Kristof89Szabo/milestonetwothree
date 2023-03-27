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
        String expected2 = "2";

        //When
        String actual1 = fizzbuzz.convert(1);
        String actual2 = fizzbuzz.convert(2);
        //Then
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    @Test
    void testThatConvertHandleThreeNumber() {
        //Given
        String expected1 = "Fizz";

        //When
        String actual1 = fizzbuzz.convert(3);

        //Then
        assertEquals(expected1, actual1);


    }

    @Test
    void testThatConvertHandleFiveNumber() {
        //Given
        String expected1 = "Buzz";

        //When
        String actual1 = fizzbuzz.convert(5);

        //Then
        assertEquals(expected1, actual1);


    }



}