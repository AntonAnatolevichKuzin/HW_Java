package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       System.out.println(palindrom("str"));

        Path file = Path.of("src", "main", "java", "file.txt");
        try{
            Files.createFile(file);
        }
        catch (IOException e) {
            System.out.println("Файл уже создан");
        }

        try {
            Files.writeString(file, getString("TEST"));
        }
        catch (IOException e) {
            System.out.println("Файл отсутствует");
        }


    }



    // 1. Создать метод, который проверяет, является ли строка палиндромом.
    // Палиндром - шалаш

    private static boolean palindrom(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input word: ");
        String string = sc.nextLine();
        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    // 2. С помощью Java создать файл file.txt, и записать в него слово TEST 100 раз.
    // Если уже файл создан, то перезаписываем его.

    private static String getString(String str) {
        String res = "";
        for (int i = 0; i < 100; i++) {
            res += "\n "+ str;
        }
        return res;
    }

}