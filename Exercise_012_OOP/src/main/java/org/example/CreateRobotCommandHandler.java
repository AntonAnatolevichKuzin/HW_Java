package org.example;

public class CreateRobotCommandHandler implements CommandHandler {
    @Override
    public String commandName() {
        return "create-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] arguments) {
        int x = Integer.parseInt(arguments[0]);
        int y = Integer.parseInt(arguments[1]);
        try {
            RobotMap.Robot robot = map.createRobot(new Point(x, y));
            System.out.println("Создан робот " + robot.getId());
        } catch (PositionException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    @Override
    public void handle(String[] arguments) {

    }
}
