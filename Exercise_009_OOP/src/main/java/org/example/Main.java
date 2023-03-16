package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Создать класс Notebook с полями:
//        1. Стоимость (int)
//        2. Оперативная память (int)
//                Нагенерить объектов этого класса, создать список и отсортировать его в трех вариантах:
//        1. По возрастанию цены
//        2. По убыванию цены
//        3. По оперативке по убыванию. Если оперативки равны - по убыванию цены.
//        4.+ придумать свои параметры и отсортировать по ним

        List<Notebook> notebooks = new ArrayList<>();
        int numberOfNotebooks = 10;
        for (int i = 0; i < numberOfNotebooks; i++) {
            Notebook notebook = NotebookGenerator.generateRandomNotebook();
            notebooks.add(notebook);
        }
        System.out.println("Список до сортировки:");
        TableFormater.printNotebooks(notebooks);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    NotebookSorter.sortByCostAscending(notebooks);
                    TableFormater.printNotebooks(notebooks);
                    break;
                case 2:
                    NotebookSorter.sortByCostDescending(notebooks);
                    TableFormater.printNotebooks(notebooks);
                    break;
                case 3:
                    NotebookSorter.sortByMemoryAndCostDescending(notebooks);
                    TableFormater.printNotebooks(notebooks);
                    break;
                case 4:
                    NotebookSorter.sortByDisplayAscending(notebooks);
                    TableFormater.printNotebooks(notebooks);
                    break;
                case 5:
                    NotebookSorter.sortByDisplayDescending(notebooks);
                    TableFormater.printNotebooks(notebooks);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Выберите действие из списка!");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1 - Сортировка по возрастанию цены");
        System.out.println("2 - Сортировка по убыванию цены");
        System.out.println("3 - Сортировка по оперативной памяти и цене");
        System.out.println("4 - Сортировка по возрастанию диаганали дисплея");
        System.out.println("5 - Сортировка по убыванию диаганали дисплея");
        System.out.println("6 - Выход");
        System.out.print("Выберите действие: ");
    }
//        System.out.println("Список до сортировки:");
////        System.out.println(notebooks);
//        TableFormater.printNotebooks(notebooks);
//        System.out.println();
//
//        NotebookSorter.sortByCostAscending(notebooks);
//        System.out.println("Список после сортировки по возрастанию цены:");
//        TableFormater.printNotebooks(notebooks);
////        System.out.println(notebooks);
//        System.out.println();
//
//        NotebookSorter.sortByCostDescending(notebooks);
//        System.out.println("Список после сортировки по убыванию цены:");
////        System.out.println(notebooks);
//        TableFormater.printNotebooks(notebooks);
//        System.out.println();
//
//        NotebookSorter.sortByMemoryAndCostDescending(notebooks);
//        System.out.println("Список после сортировки по оперативной памяти и цене:");
////        System.out.println(notebooks);
//        TableFormater.printNotebooks(notebooks);
//    }
}