package com.donc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by donovan on 2016/02/02.
 */
public class Main {
    private static final String INIT = "INIT";
    private static final String GPS_REPORT = "GPS_REPORT";

    public static void main(String[] args) {
        RobotSim robotSim = new RobotSim();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s;

            while (!(s = br.readLine().toUpperCase()).equals("QUIT")) {
                try {
                    if (s.contains(INIT)) {
                        s = s.substring(s.indexOf(INIT) + 5);
                        String sArr[] = s.trim().split(",");
                        try {
                            robotSim.init(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), RobotSim.DIRECTION.valueOf(sArr[2].toString()));
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (s.equalsIgnoreCase("GPS_REPORT")) {
                        System.out.println(robotSim.getGPSReport());
                    } else {
                        final RobotSim.COMMAND command = RobotSim.COMMAND.valueOf(s);
                        robotSim.move(command);
                    }
                } catch (Exception e) {
                    //ignored
                }
            }

        } catch (IOException e) {
            // ignored
        }
    }
}
