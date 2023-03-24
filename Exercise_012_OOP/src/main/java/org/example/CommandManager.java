package org.example;

import java.util.Arrays;
import java.util.List;

public class CommandManager {

    private final RobotMap map;
    private final List<CommandHandler> handlers;

    public CommandManager(RobotMap map, List<CommandHandler> handlers) {
        this.map = map;
        this.handlers = handlers;
    }

    public void handleCommand(String command) {
        String[] splitCommand = command.split(" ");
        String commandName = splitCommand[0];
        String[] arguments = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);

        for (CommandHandler handler : handlers) {
            if (commandName.equals(handler.commandName())) {
                handler.handleCommand(map, arguments);
                return;
            }
        }
        System.out.println("Команда не найдена. Попробуйте еще раз");
    }

}
