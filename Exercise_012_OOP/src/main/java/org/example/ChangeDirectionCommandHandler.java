package org.example;

import java.util.UUID;

public class ChangeDirectionCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "change-direction";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        UUID id = UUID.fromString(args[0]);
        RobotMap.Direction newDirection = RobotMap.Direction.valueOf(args[1]);

        RobotMap.Robot robotById = map.getRobotById(id);
        if (robotById != null) {
            robotById.changeDirection(newDirection);
            System.out.println("Направление робота " + id + " изменено на " + newDirection);
        } else {
            System.out.println("Робот с идентификаторо " + id + " не найден");
        }
    }

    @Override
    public void handle(String[] arguments) {

    }
}
