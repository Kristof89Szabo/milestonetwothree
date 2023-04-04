package com.exam.algo;

import java.util.Stack;

public class ReverseWord {

    public static void main(String[] args) {

        stackSolution();
        charConcat();
        stringBuilder();

    }

    private static void stackSolution() {
        String myWord = "De nada";
        Stack<Character> word = new Stack<>();
        for (int i = 0; i < myWord.length(); i++) {
            Character c = myWord.charAt(i);
            word.push(c);
        }

        String resultWord = "";
        int size = word.size();
        for (int i = 0; i < size; i++) {
            Character c = word.pop();
            resultWord += c;
        }
        System.out.println(resultWord);
    }

    private static void charConcat() {
        String str = "De nada";
        String newStr = "";
        char ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i); //extracts each character
            newStr = ch + newStr; //adds each character in front of the existing string
        }
        System.out.println(newStr);
    }

    private static void stringBuilder() {
        String input = "De nada";

        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1.reverse();
        System.out.println(input1);
    }

}