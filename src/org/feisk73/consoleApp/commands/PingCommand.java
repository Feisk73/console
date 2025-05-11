package org.feisk73.consoleApp.commands;

import org.feisk73.consoleApp.ConsoleMain;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class PingCommand extends CommandBase implements Command {
    public PingCommand(ConsoleMain main) {
        super(main);
    }

    @Override
    public void execute(String[] args) {
        int attempts = 5;
        int timeout = 5000;
        String url;
        try {
            url = args[0];
        } catch (Exception e) {
            main.output("Argument \"URL\" not found");
            return;
        }

        try {
            String targetUrl = url.startsWith("http") ? url : "https://" + url;
            URL target = new URL(targetUrl);
            String host = target.getHost();
            InetAddress ip = InetAddress.getByName(host);

            main.output(String.format("Pinging %s [%s]:", host, ip.getHostAddress()));

            long[] pings = new long[attempts];

            for (int i = 0; i < attempts; i++) {
                HttpURLConnection conn = (HttpURLConnection) new URL(targetUrl).openConnection();
                conn.setRequestMethod("HEAD");
                conn.setConnectTimeout(timeout);
                conn.setReadTimeout(timeout);
                long startTime = System.currentTimeMillis();
                conn.connect();
                int code = conn.getResponseCode();
                long ping = System.currentTimeMillis() - startTime;
                main.output(String.format("%s: time=%d status=%d %s", ip.getHostAddress(), ping, code, getHttpStatusMessage(code)));
                pings[i] = ping;
                conn.disconnect();
            }
            printStats(pings);
        } catch (Exception e) {
            main.output(e.getMessage());
        }

    }

    @Override
    public String getDescription() {
        return "returns ping of given url";
    }

    private static String getHttpStatusMessage(int code) {
        return switch(code) {
            case 200 -> "OK";
            case 301 -> "Moved Permanently";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default -> "";
        };
    }
    private void printStats(long[] times) {
        long min = times[0];
        long max = times[0];
        long sum = 0;

        for (long time : times) {
            min = Math.min(min, time);
            max = Math.max(max, time);
            sum += time;
        }

        main.output("");
        main.output("- Min ping: " + min + " ms");
        main.output("- Max ping: " + max + " ms");
        main.output("- Average ping: " + (double)sum/times.length + " ms");
    }
}
