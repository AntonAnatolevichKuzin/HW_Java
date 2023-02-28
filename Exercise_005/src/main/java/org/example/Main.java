package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Написать метод, определяющую правильность расстановки скобок в выражении.
 * Могут содержаться следующие скобки: ()[]{}<>
 * () -> true
 * []{}((<>)) -> true
 * ) -> false
 * [) -> false
 * []{}(<)> -> false
 */

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> openBrackets = new HashMap<String, Integer>() {{
            put("{", 0);
            put("[", 1);
            put("(", 2);
            put("<", 3);
        }};
        HashMap<String, Integer> closeBrackets = new HashMap<String, Integer>() {{
            put("}", 0);
            put("]", 1);
            put(")", 2);
            put(">", 3);
        }};


        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String brackets = sc.nextLine();
//        String brackets = "<{}(<{})>";
        boolean result = isCorrectBackets(openBrackets, closeBrackets, brackets);

        if(result) {
            System.out.println(brackets + " -> true");
        } else {
            System.out.println(brackets + " -> false");
        }

    }


    public static boolean isCorrectBackets( HashMap<String, Integer> openBrackets,
                                    HashMap<String, Integer> closeBrackets,
                                    String brackets){

        String[] strings = brackets.split("");

        Deque<String> stack = new ArrayDeque<>();

        for (String inLine: strings) {

            for (int i = 0; i < inLine.length(); i++) {

                char character = inLine.charAt(i);
                String symbol = Character.toString(character);

                if (openBrackets.containsKey(symbol)) {
                    stack.push(symbol);
                } else if (closeBrackets.containsKey(symbol)) {

                    if(!stack.isEmpty()) {

                        Integer ordinalNumberForCheckedSymbol = closeBrackets.get(symbol);

                        String firstElemFromStack = stack.pop();
                        Integer ordinalLastAddedNumberElemFromStack = openBrackets.get(firstElemFromStack);
                        boolean isPairTheBrackets =
                                ordinalLastAddedNumberElemFromStack.equals(ordinalNumberForCheckedSymbol);

                        if(isPairTheBrackets) break;
                    }


                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
