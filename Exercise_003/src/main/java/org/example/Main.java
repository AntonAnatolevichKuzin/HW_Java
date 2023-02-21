package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> myList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            myList.add(rnd.nextInt(80));
        }

        System.out.println(myList.toString());

        Iterator<Integer> it = myList.iterator();

        while (it.hasNext())
        {
            if (it.next() % 2 == 0) {
                it.remove();
            }
        }
        System.out.println(myList.toString());

        System.out.println("Максимальное значение в списке: " + Collections.max(myList));
        System.out.println("Минимальное значение в списке: " + Collections.min(myList));
        int average = (Collections.max(myList) + Collections.min(myList))/2;
        System.out.println("Среднее арифметическое min & max: " + average);

    }
}