package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand extends CommandBase implements Command {
    public TimeCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatted_time = currentTime.format(formatter);
        main.output(currentDate + " " + formatted_time);
    }

    @Override
    public String getDescription() {
        return "";
    }
}
