package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.util.Arrays;
import java.util.Base64;

public class Base64Command extends CommandBase implements Command{
    public Base64Command(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            print("Usage: base64 <decode/encode> <text>");
            return;
        }
        String input = Arrays.toString(Arrays.copyOfRange(args, 1, args.length));
        String text = input.substring(1, input.length() - 1).replaceAll("[^A-Za-z0-9+/=]", "");
        String output = "";
        switch (args[0]) {
            case "decode":
                try {
                    byte[] decodedBytes = Base64.getDecoder().decode(text);
                    output = new String(decodedBytes);
                } catch (IllegalArgumentException ignored) {}
                break;
            case "encode":
                output = Base64.getEncoder().encodeToString(text.getBytes());
                break;
            default:
                print("Usage: base64 <decode/encode> <text>");
        }
        printf("\"%s\" >> \"%s\"", text, output);
    }

    @Override
    public String getDescription() {
        return "decrypts and encrypts base64";
    }
}
