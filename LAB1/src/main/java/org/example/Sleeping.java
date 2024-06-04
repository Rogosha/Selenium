package org.example;

import java.util.concurrent.TimeUnit;

public class Sleeping {
    public static void sleep(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("ERROR WAIT");
        }
    }
}
