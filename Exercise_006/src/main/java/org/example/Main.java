package org.example;

import java.util.Random;

public class Main {
    // ДЗ:
// while (true) -> while (!plate.isEmpty())
// 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
// В конце каждого цикла мы досыпаем в тарелку еду.
// Для досыпания еды сделать метод increaseFood в классе Plate.
// 2. Поменять поле satiety у кота с boolean на int.
// Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
// 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.
    public static void main(String[] args) throws InterruptedException {

        int catsNumber = 5;
        int maxCatAppetite = 10;
        int minCatAppetite = maxCatAppetite;
        int plateVolume = 50;
        int maxFoodToPutInPlate = 30;

        Plate plate = new Plate(plateVolume);
        Cat[] cats = new Cat[catsNumber];
        Random random = new Random();


        for (int i = 0; i < catsNumber; i++) {
            int catAppetite = random.nextInt(maxCatAppetite) + 1;
            cats[i] = new Cat("Cat" + (i + 1), catAppetite);
            if (minCatAppetite > catAppetite) {
                minCatAppetite = catAppetite;
            }
        }
        System.out.println(plate);

        while (plate.remainderPlate() >= minCatAppetite) {
            for (Cat cat : cats) {
                cat.eat(plate);
            }
            System.out.println(plate);
            System.out.println();

            if (plate.remainderPlate() < 8) {

                System.out.println(
                        plate.increaseFood(maxFoodToPutInPlate) + " еды положили на тарелку.");
            } else {
                System.out.println("На тарелку ничего не положили.");
            }
            System.out.println(plate);

            System.out.println();
            Thread.sleep(3* 1000);
        }
    }
}