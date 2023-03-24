package org.example;

import java.util.NoSuchElementException;
import java.util.UUID;

public class MoveRobotCommandHandler implements CommandHandler {
    @Override
    public String commandName() {
        return "move-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] arguments) {
        UUID id = UUID.fromString(arguments[0]);
        try {
            map.getRobotById(id).move();
            System.out.println("Робот " + id + " перемещен");
        } catch (NoSuchElementException | PositionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public void handle(String[] arguments) {

    }
}
