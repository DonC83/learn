package com.donc.dragon;

import java.io.PrintStream;

/**
 * Created by donovan on 15/05/22.
 */
public class SlayDragonQuest implements Quest {


    private PrintStream printStream;


    public SlayDragonQuest(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void embark() {
        printStream.println("Slaying dragon!");
    }
}
