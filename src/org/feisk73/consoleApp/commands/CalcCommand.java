package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.text.DecimalFormat;

public class CalcCommand extends CommandBase implements Command {

    public CalcCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        float result = 0;
        float a;
        float b;
        String operation;

        try {
            if (args.length != 1) {
                a = Float.parseFloat(args[0]);
                b = Float.parseFloat(args[2]);
                operation = args[1];
            } else {
                String[] newargs = args[0].split("");
                a = Float.parseFloat(newargs[0]);
                b = Float.parseFloat(newargs[2]);
                operation = newargs[1];
            }
        } catch (NumberFormatException e) {
            print("NaN");
            return;
        }

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {result = a / b;}
                else {result = 0;}
                break;
            case "%":
                result = a % b;
                break;
        }
        print(formatNumber(a) + operation + formatNumber(b) + " = " + formatNumber(result));
    }

    @Override
    public String getDescription() {
        return "returns the result of operations: + − × ÷ %";
    }
    public static String formatNumber(double num) {
        DecimalFormat df = new DecimalFormat("#.########");
        df.setDecimalSeparatorAlwaysShown(false);
        return df.format(num);
    }
}
