package org.example;

import java.util.*;

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

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new CreateRobotCommandHandler());
        handlers.add(new MoveRobotCommandHandler());
        handlers.add(new ChangeDirectionCommandHandler());

        CommandManager commandManager = new CommandManager(map, handlers);

        System.out.println("Список доступных команд:");
        for (CommandHandler handler : handlers) {
            System.out.println(handler.commandName());
        }
        System.out.println("exit");

        while (true) {
            System.out.print("> ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                break;
            }

            commandManager.handleCommand(command);
        }

        sc.close();
    }

}
