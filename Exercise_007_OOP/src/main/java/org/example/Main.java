package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. Создать класс Player с полями id (long), name (String), damage (double) healthPoint (hp) (double)
        // У класса должен быть конструктор, который принимает только name.
        // Идентификатор присваивается автоматически из последовательности (1, 2, ...)
        // Каждый класс должен уметь "бить" другого Player'а
        // void attack(Player player) -> player1.attack(player2)
        // Внутри метода игрок, на котором вызван метод уменьшает здоровье игрока, который передан в метод
        // Придумать несколько классов с разными параметрами жизней и атаки по-умолчанию
        // Player player = new Tank("name");
        // 2. * Придумать, все, что захочется и обогатить проект
        // 3. Понасоздавать объектов и стравить их друг с другом


        ArrayList<Player> players = new ArrayList<>();
        Random random = new Random();
        int figters = 6;
        int firstPlayer;
        int secondPlayer;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < figters; i++) {
            int temp = random.nextInt(3);

            if (temp == 0) {
                players.add(new Tank("Tank-" + (i + 1)));
            } else {
                players.add(new Shooter("Shooter-" + (i + 1)));
            }
        }

        while (players.size() > 1) {
            firstPlayer = random.nextInt(players.size());
            secondPlayer = random.nextInt(players.size());


            while (firstPlayer == secondPlayer) {
                secondPlayer = random.nextInt(players.size());
            }

            System.out.print(players.get(firstPlayer).getName());
            System.out.print(" и ");
            System.out.print(players.get(secondPlayer).getName());
            System.out.println(" готовы сражаться.");
            System.out.println("-> Нажмите Enter, для начала боя.");
            scanner.nextLine();

            if (fight(players.get(firstPlayer), players.get(secondPlayer))) {
                System.out.print(players.get(firstPlayer).getName());
//                players.get(firstPlayer).getHealthPoint();
                players.remove(secondPlayer);
            } else {
                System.out.print(players.get(secondPlayer).getName());
//                players.get(secondPlayer).getHealthPoint();
                players.remove(firstPlayer);
            }
            System.out.println(" - Победил!");
            System.out.println();
        }
        scanner.close();
    }

    public static boolean fight(Player firstFighter, Player secondFighter) {
        while (true) {
            firstFighter.attack(secondFighter);

            if (secondFighter.isDead()) {
                return true;
            } else {
                secondFighter.attack(firstFighter);

                if (firstFighter.isDead()) {
                    return false;
                }
            }
        }
    }
}
