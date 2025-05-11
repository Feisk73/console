package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.util.Random;

public class RandomCommand extends CommandBase implements Command {
    public RandomCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        int output = 0;
        int min;
        int max;
        try {
            min = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            main.output("NaN");
            return;
        }
        Random random = new Random();
        if (min < max) {
            output = random.nextInt(max - min) + min;
        }
        if (min > max) {
            output = random.nextInt(min - max) + max;
        }
        if (min == max) {
            output = min;
        }
        main.output(String.valueOf(output));
    }

    @Override
    public String getDescription() {
        return "";
    }
}
