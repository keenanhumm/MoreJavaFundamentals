package com.kaytec.threads;

import static com.kaytec.utils.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hello from " + currentThread().getName());
        long sleepTime = 3000; // in milliseconds

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke me!");
            return;
        }

        System.out.println(ANSI_BLUE + sleepTime/1000 + " seconds passed. I'm up.");
    }
}
