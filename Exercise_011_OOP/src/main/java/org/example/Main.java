package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите команду для создания карты:");
        RobotMap map = null;
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("create-map")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);

                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
        }

        System.out.println("ИГРАЕМ...");

        RobotMap.Robot robot1 = null;
        RobotMap.Robot robot2 = null;
        RobotMap.Robot robot3 = null;
        try {
            robot1 = map.createRobot(new Point(2, 5));
            robot2 = map.createRobot(new Point(4, 5));
            robot3 = map.createRobot(new Point(5, 10));

            System.out.println(robot1);
            System.out.println(robot2);
            System.out.println(robot3);
        } catch (PositionException e) {
            System.out.println("Во время создания робота случилось исключение: " + e.getMessage());
        }

        System.out.println("Список допустимых команд: " +
                "create-robot -> создать робота;" +
                "move-robot -> двигать робота;" +
                "change-direction -> сменить направление;");
        while (true) {
            System.out.println("Введите команду:");
            String command = sc.nextLine();
            String[] split = command.split(" ");
            String commandName = split[0];
            switch (commandName) {
                case "create-robot":
                    int x = Integer.parseInt(split[1]);
                    int y = Integer.parseInt(split[2]);
                    try {
                        RobotMap.Robot robot = map.createRobot(new Point(x, y));
                        System.out.println("Создан робот с id=" + robot.getId());
                    } catch (PositionException e) {
                        System.out.println("Не удалось создать робота: " + e.getMessage());
                    }
                    break;
                case "move-robot":
                    UUID id = UUID.fromString(split[1]);
                    RobotMap.Robot robot = map.getRobotById(id);
                    if (robot != null) {
                        try {
                            robot.move();
                            System.out.println("Робот с id=" + id + " перемещен");
                        } catch (PositionException e) {
                            System.out.println("Не удалось переместить робота: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Робот с id=" + id + " не найден");
                    }
                    break;
                case "change-direction":
                    UUID id2 = UUID.fromString(split[1]);
                    RobotMap.Robot rob = map.getRobotById(id2);
                    if (rob != null) {
                        try {
                            String newDirection = split[2];
                            rob.changeDirection(RobotMap.Direction.valueOf(newDirection));
                            System.out.println("Направление робота с id=" + id2 + " изменено на " + newDirection);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Не удалось изменить направление робота: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Робот с id=" + id2 + " не найден");
                    }
                    break;
                default:
                    System.out.println("Команда не найдена. Попробуйте еще раз");
                    break;
            }
        }
    }
}
