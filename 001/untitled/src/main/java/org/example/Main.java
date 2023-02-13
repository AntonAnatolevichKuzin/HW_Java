package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false

        System.out.println(isPositive(5));
        System.out.println(isLeapYear(2005));
        printString("abcd", 5); // abcdabcdabcdabcdabcd
        createArray(8, 8);

        int[] array  = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        replaceArray(array);

        int[] array2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        replaceArray2(array2);

//
//        int[][] array = new int[4][4]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x], [0, 0, 0, 1]]
//        int x = array[2][3];
//
//        String[] stringArray = {"aaa", "aab", "aa"};
//        System.out.println(findCommonPrefix(stringArray)); // aa
//        String[] stringArray2 = {"abc", "bca", "cda"};
//        System.out.println(findCommonPrefix(stringArray2)); // ""
    }

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number A: ");
        int num1 = sc.nextInt();
        System.out.println("Input number B: ");
        int num2 = sc.nextInt();
        int sumNumber = num1 + num2;
        if (sumNumber >= 10 && sumNumber <= 20){
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        Scanner sc = new Scanner(System.in);
        System.out.println("Input X: ");
        int number = sc.nextInt();
        if (number > 0){
            return true;
        }
        else {
            return false;
        }
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        Scanner sc = new Scanner(System.in);
        System.out.println("Input text: ");
        String text = sc.nextLine();
        System.out.println("Input number of repeats: ");
        int num = sc.nextInt();
        for (int i = 0; i < num ; i++) {
            System.out.print(text);
        }

    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        Scanner sc = new Scanner(System.in);
        System.out.println("Input year: ");
        int num = sc.nextInt();
        if(num % 4 == 0) {
            if (num % 100 == 0){
                if(num % 400 == 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    private static int[] createArray(int len, int initalValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initalValue;
            System.out.print(array[i] +" ");
        }
        return array;
    }

    private static int[] replaceArray(int array[]) {
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            }
            else {
                array[i] = 0;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }

    private static int[] replaceArray2(int array2[]){
        // числа меньшие 6 умножить на 2
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < 6) {
                array2[i] = array2[i] * 2;
            }
            System.out.print(array2[i] + " ");
        }
        return array2;
    }

//    private static String findCommonPrefix(String[] source) {
//        /** Найти общий префикс среди слов из одного массива.
//         * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
//         */
//        return null;
//    }

}



//* 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//* и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
//* Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
//* 4. Задать одномерный массив и найти в нем минимальный и максимальный элементы