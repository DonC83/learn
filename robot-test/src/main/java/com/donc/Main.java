package com.donc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by donovan on 2016/02/02.
 */
public class Main {
    private static final String INIT = "INIT";
    private static final String GPS_REPORT = "GPS_REPORT";

    RobotSim robotSim = new RobotSim();


    public void process(String s) {
        try {
            if (s.contains(INIT)) {
                s = s.substring(s.indexOf(INIT) + 5);
                String sArr[] = s.trim().split(",");
                try {
                    robotSim.init(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), RobotSim.DIRECTION.valueOf(sArr[2].toString()));
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            } else if (s.equalsIgnoreCase(GPS_REPORT)) {
                System.out.println(robotSim.getGPSReport());
            } else {
                final RobotSim.COMMAND command = RobotSim.COMMAND.valueOf(s);
                robotSim.move(command);
            }
        } catch (Exception e) {
            //ignored
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        //Assuming file input is received as a command line argument
        if (args.length>0) {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String s;
                while ((s=br.readLine())!=null) {
                    m.process(s.toUpperCase());
                }
            } catch (IOException e) {
                // ignored
            }
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s;

            while (!(s = br.readLine().toUpperCase()).equals("QUIT")) {
                m.process(s);
            }

        } catch (IOException e) {
            // ignored
        }
    }
}
