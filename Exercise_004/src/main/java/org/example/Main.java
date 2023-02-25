package org.example;
import java.util.ArrayList;
import java.util.Scanner;

//        Реализовать консольное приложение, которое:
//        Принимает от пользователя строку вида -> text~num
//        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
//        Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
// text~num (например, word~4)
// print~num (распечатать текст)

// word~1
// foo~5
// qwerty~10
// bar~5
// print~10 -> qwerty
// print~1 -> word
// print~2 -> пустая строка или исключение NoSuchElementException
// print~5 -> bar

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Boolean notStop = true;

        System.out.println("Введите данные в формате: text~value ");
        System.out.println("(для выхода из программы введите 'quit')");

        while (notStop) {
            String[] userInput = sc.nextLine().split("~");
            if (userInput[0].equals("print")) {
                System.out.println(getData(list, userInput[1]));
            } else if (userInput[0].equals("quit")) {
                notStop = false;
            } else {
                saveData(list, userInput);
            }
        }
    }

    public static void saveData(ArrayList<String> list, String[] array) {
        boolean found = list.contains(array[1]);
        int index = list.indexOf(array[1]);
        if (found) {
            list.remove(index + 1);
            list.add(index + 1, array[0]);
        } else {
            list.add(array[1]);
            list.add(array[0]);
        }
        System.out.println(list);
    }



    public static String getData(ArrayList<String> list, String key) {
        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i).equals(key)) {
                return list.get(i + 1);
            }
        }
        return "Элемент с таким номером отсутствует!";
    }

}

