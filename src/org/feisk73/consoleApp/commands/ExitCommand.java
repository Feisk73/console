package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.util.Timer;
import java.util.TimerTask;

public class ExitCommand extends CommandBase implements Command {
    public ExitCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
                System.exit(0);

        } else {
            int delay = Integer.parseInt(args[0]);
            printf("Console will shut after %ds", delay);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.exit(0);
                }
            }, delay * 1000L);
        }
    }

    @Override
    public String getDescription() {
        return "shuts console";
    }
}
