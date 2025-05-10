package org.feisk73.consoleApp.handlers;

import org.feisk73.consoleApp.commands.Command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> commands = new HashMap<>();

    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(args);
        }
    }
    public String commandList() {
        StringBuilder result = new StringBuilder();
        commands.forEach((name, cmd) ->
                result.append(String.format("%-10s %s%n", name, cmd.getDescription()))
        );
        return result.toString();
    }
}
