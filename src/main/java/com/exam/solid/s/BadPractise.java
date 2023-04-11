package com.exam.solid.s;

import java.util.Scanner;

public class BadPractise {

    public static void main(String[] args) {

        System.out.println("Welcome to the Application!");

        Scanner scanner = new Scanner(System.in);

        //Inputs
        System.out.println("Enter your first number: ");
        String firstNumber = scanner.nextLine();
        System.out.println("Enter your second number: ");
        String secondNumber = scanner.nextLine();

        scanner.close();

        //Validate
        int firstInteger = 0;
        int secondInteger = 0;

        if (firstNumber == null) {
            System.out.println("First number is not valid...");
            return;
        }

        try {
            firstInteger = Integer.parseInt(firstNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("First number is not valid...");
        }

        if (secondNumber == null) {
            System.out.println("Second number is not valid...");
            return;
        }

        try {
            secondInteger = Integer.parseInt(secondNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Second number is not valid...");
        }

        //Operation
        int result = firstInteger + secondInteger;
        System.out.println("The result is " + result);
        System.out.println("End of the application");


    }

}
