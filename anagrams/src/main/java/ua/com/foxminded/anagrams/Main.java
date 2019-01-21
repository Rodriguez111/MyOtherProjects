package ua.com.foxminded.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputText = "";
            printQuestionToTheUser();
            while (!(inputText = reader.readLine()).equals("exit")) {
                System.out.println("Результат: " + anagram.reverse(inputText));
                printQuestionToTheUser();

            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

    }

    private static void printQuestionToTheUser() {
        System.out.println("Введите текст или \"exit\" для выхода");
    }
}
